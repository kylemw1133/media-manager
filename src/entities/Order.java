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
//	private final static String editOrderSQL = "UPDATE [ORDER] SET Name=?, Length=?, Year=? WHERE Inventory_ID=?";
	private final static String selectOrderSQL = "SELECT * FROM [ORDER] WHERE Order_ID=?;";
	private final static String updateInventorySQL = "UPDATE INVENTORY_ITEM SET Quantity=? WHERE INVENTORY_ITEM.Inventory_ID=?";
	private final static String updateOrderSQL = "UPDATE [ORDER] SET Status='FULFILLED' WHERE Order_ID=?";
	private static final String maxOrderIDSQL = "SELECT MAX(Order_ID) AS Max_ID FROM [ORDER];";

	private int inventoryItemID;
	private int copies;
	private LinkedList<TypedAttribute> data;

	public Order() {
		this.data = null;
	}

	public Order(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Inventory_ID")) {
				this.inventoryItemID = (int) ta.value;
			} else if (ta.name.equals("Copies")) {
				this.copies = (int) ta.value;
			}
		}
	}

	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextOrderID(conn);
		return Utils.executeInsertion(conn, s, id, insertOrderSQL, "ORDER", "Order_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
//		Utils.executeEdit(conn, s, this.data, editOrderSQL, "Order_ID");
	}

	public void activate(Connection conn, Scanner s) throws SQLException {
		// Get an order
		// Get the associated inventory item
		// increase the items quantity by the order's quantity
		// change the order status
		PreparedStatement selectOrderStatement = conn.prepareStatement(selectOrderSQL);

		System.out.println("Enter the order ID to fulfill:");

		String order_id = "";
		// repeat promp for inventory id until user inputs a valid integer
		while (order_id.equals("") || !order_id.matches("\\-?\\d+")) {
			order_id = s.nextLine();
		}

		ResultSet rs = selectOrderStatement.executeQuery();
		System.out.println(
				"Do you wish to activate this order? Quantity will be increased and order status will change from PENDING to FULFILLED.");
		Utils.printRecords(rs);
		System.out.println("Y/N");

		String input = s.nextLine();
		if (input.equals("Y")) {
			System.out.println("Activating order...");
			InventoryItem.changeQuantity(conn, this.inventoryItemID, this.copies);
		} else {
			System.out.println("Activation cancelled.");
		}
		selectOrderStatement.close();
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

	public static int getNextOrderID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxOrderIDSQL, "Max_ID");
	}
}
