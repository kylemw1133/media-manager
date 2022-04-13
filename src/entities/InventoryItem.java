package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class InventoryItem implements Entity {

	private final static String insertInventoryItemSQL = "INSERT INTO INVENTORY_ITEM VALUES (?, ?, ?, ?);";
	private final static String editInventoryItemSQL = " UPDATE INVENTORY_ITEM SET Quantity=?, Format=?, Location=? WHERE Inventory_ID=?;";
	private final static String deleteInventoryItemSQL = "DELETE FROM INVENTORY_ITEM WHERE Inventory_ID = ?;";
	private static final String maxInventoryIDSQL = "SELECT MAX(Inventory_ID) AS Max_ID FROM INVENTORY_ITEM;";

	private LinkedList<TypedAttribute> data;
	
	public InventoryItem() {
		this.data = null;
	}
	
	public InventoryItem(LinkedList<TypedAttribute> data) {
		this.data = data;
	}
	
	public static int getNextInventoryID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxInventoryIDSQL, "Max_ID");
	}

	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = 0;
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "INVENTORY_ITEM");
		PreparedStatement insertInventoryItemStmt = conn.prepareStatement(insertInventoryItemSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				id = getNextInventoryID(conn);
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertInventoryItemStmt, i);
			i++;
		}

		insertInventoryItemStmt.execute();
		insertInventoryItemStmt.close();

		return id;
	}

	public void edit(Connection conn, Scanner s) throws SQLException {
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "MOVIE");
		PreparedStatement editInventoryItemStmt = conn.prepareStatement(editInventoryItemSQL);
		int i = 1;
		int id = 0;

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				System.out.print("Provide the ID of the item you want to edit: ");
				id = Integer.parseInt(s.nextLine());
			} else {
				a.promptForValue(s);
				a.fillInStmt(editInventoryItemStmt, i++);
			}
		}

		editInventoryItemStmt.setInt(i, id);

		editInventoryItemStmt.executeUpdate();
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
		deleteInventoryItemStmt.executeQuery();
		deleteInventoryItemStmt.close();
	}
	
	public static InventoryItem searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = InventoryItem.search(conn, s);
		if (rs.first()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "INVENTORY_ITEM");
			Utils.fillRowData(rs, rowData);
			return new InventoryItem(rowData);
		} else {
			return null;
		}
	}
	
	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		System.out.println("Which field do you want to search by?");
		System.out.println("1: Quantity | 2: Format | 3: Location | 4: EXIT: ");
		String input = s.nextLine();
		String searchInputString = "";
		int searchInputInt;
		PreparedStatement searchInventoryItemSQLStmt = null;
		switch (input) {
		case "1":
			System.out.println("Enter search name");
			searchInputString = s.nextLine();
			searchInventoryItemSQLStmt = conn.prepareStatement("SELECT * FROM INVENTORY_ITEM WHERE Quantity = ?;");
			searchInventoryItemSQLStmt.setString(1, searchInputString);
			break;
		case "2":
			System.out.println("Enter search Length");
			searchInputInt = Integer.parseInt(s.nextLine());
			searchInventoryItemSQLStmt = conn.prepareStatement("SELECT * FROM INVENTORY_ITEM WHERE Format = ?;");
			searchInventoryItemSQLStmt.setInt(1, searchInputInt);
			break;
		case "3":
			System.out.println("Enter search year");
			searchInputString = s.nextLine();
			searchInventoryItemSQLStmt = conn.prepareStatement("SELECT * FROM INVENTORY_ITEM WHERE Location = ?;");
			searchInventoryItemSQLStmt.setString(1, searchInputString);
			break;

		case "4":
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		
		if (searchInventoryItemSQLStmt != null) {
			ResultSet rs = searchInventoryItemSQLStmt.executeQuery();
			return rs;
		} else {
			System.out.println("No search performed");
			return null;
		}
	}
}
