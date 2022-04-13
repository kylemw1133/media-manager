package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Order implements Entity {

	private final static String insertOrderSQL = "INSERT INTO [ORDER] VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final static String editOrderSQL = "UPDATE [ORDER] SET P_Email=?, Seller_ID=?, Inventory_ID=?, Date=?, ETA=?, Status=?, Copies=?, Price=? "
			+ "WHERE Order_ID=?";
	private final static String selectOrderSQL = "SELECT * FROM [ORDER] WHERE Order_ID=?;";
	private final static String updateInventorySQL = "UPDATE INVENTORY_ITEM SET Quantity=? WHERE INVENTORY_ITEM.Inventory_ID=?";
	private final static String fulfillOrderSQL = "UPDATE [ORDER] SET Status='Fulfilled' WHERE Order_ID=?";
	private static final String maxOrderIDSQL = "SELECT MAX(Order_ID) AS Max_ID FROM [ORDER];";

	public int orderID;
	public int inventoryItemID;
	public int copies;
	public LinkedList<TypedAttribute> data;

	public Order() {
		this.data = null;
	}

	public Order(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Order_ID")) {
				this.orderID = (int) ta.value;
			} else if (ta.name.equals("Inventory_ID")) {
				this.inventoryItemID = (int) ta.value;
			} else if (ta.name.equals("Copies")) {
				this.copies = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextOrderID(conn);
		return Utils.executeInsertion(conn, s, id, insertOrderSQL, "ORDER", "Order_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editOrderSQL, "Order_ID");
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;
		Order a = new Order();

		if (insert) {
			key = (int) a.insert(conn, s);
		} else {
			a = Order.searchForOne(conn, s);
			key = a.orderID;
		}

		return key;
	}

	public void activate(Connection conn, Scanner s) throws SQLException {
		System.out.println("Activating this order.");
		System.out.println(this.toString());
		System.out.println("Activating order item...");

		// Updating order record;
		PreparedStatement fulfillOrderStmt = conn.prepareStatement(fulfillOrderSQL);
		fulfillOrderStmt.setInt(1, this.orderID);
		fulfillOrderStmt.execute();

		// Updating inventory_item record;
		InventoryItem.changeQuantity(conn, this.inventoryItemID, this.copies);
	}

	public static Order searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ORDER");
			Utils.fillRowData(rs, rowData);
			return new Order(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "ORDER");
	}

	public static ResultSet list(Connection conn) throws SQLException {
		return Utils.executeList(conn, "ORDER");
	}

	public static int getNextOrderID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxOrderIDSQL, "Max_ID");
	}
}
