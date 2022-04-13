package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class InventoryItem implements Entity {

	private final static String insertInventoryItemSQL = "INSERT INTO INVENTORY_ITEM VALUES (?, ?, ?, ?);";
	private final static String editInventoryItemSQL = " UPDATE INVENTORY_ITEM SET Quantity=?, Format=?, Location=? WHERE Inventory_ID=?;";
	private final static String deleteInventoryItemSQL = "DELETE FROM INVENTORY_ITEM WHERE Inventory_ID = ?;";
	private static final String maxInventoryIDSQL = "SELECT MAX(Inventory_ID) AS Max_ID FROM INVENTORY_ITEM;";

	private final static String getQuantitySQL = "SELECT Quantity FROM INVENTORY_ITEM WHERE Inventory_ID=?";
	private final static String updateQuantitySQL = "UPDATE INVENTORY_ITEM SET Quantity=? WHERE Inventory_ID=?";

	public int id;
	public LinkedList<TypedAttribute> data;

	public InventoryItem() {
		this.data = null;
	}

	public InventoryItem(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Inventory_ID")) {
				this.id = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextInventoryID(conn);
		Utils.executeInsertion(conn, s, id, insertInventoryItemSQL, "INVENTORY_ITEM", "Inventory_ID");
		Genre.insertMultiple(conn, s, id);
		return id;

	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editInventoryItemSQL, "Inventory_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;
		InventoryItem a = new InventoryItem();

		if (insert) {
			key = (int) a.insert(conn, s);
		} else {
			a = InventoryItem.searchForOne(conn, s);
			key = a.id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static void delete(Connection conn, Scanner s) throws SQLException {
		System.out.println("Enter the inventory ID of the item you wish to delete:");
		PreparedStatement deleteInventoryItemStmt = conn.prepareStatement(deleteInventoryItemSQL);

		String id = "";
		// repeat promp for inventory id until user inputs a valid integer
		while (id.equals("") || !id.matches("\\-?\\d+")) {
			id = s.nextLine();
		}

		deleteInventoryItemStmt.setString(1, id);
		deleteInventoryItemStmt.execute();
		deleteInventoryItemStmt.close();
	}

	public static void changeQuantity(Connection conn, int id, int delta) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(getQuantitySQL);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		rs.next();
		int prevQuantity = rs.getInt("Quantity");
		int newQuantity = prevQuantity + delta;

		if (newQuantity < 0) {
			newQuantity = 0;
		}

		stmt.close();
		stmt = conn.prepareStatement(updateQuantitySQL);
		stmt.setInt(1, newQuantity);
		stmt.setInt(2, id);
		stmt.execute();
		stmt.close();
	}

	public static InventoryItem searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "INVENTORY_ITEM");
			Utils.fillRowData(rs, rowData);
			return new InventoryItem(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "INVENTORY_ITEM");
	}

	public static ResultSet list(Connection conn) throws SQLException {
		return Utils.executeList(conn, "INVENTORY_ITEM");
	}

	public static int getNextInventoryID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxInventoryIDSQL, "Max_ID");
	}
}
