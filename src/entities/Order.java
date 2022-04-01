package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Order {

	private final static String insertOrderSQL = "INSERT INTO [ORDER] VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final static String selectOrderSQL = "SELECT * FROM [ORDER] WHERE Order_ID=?;";

	public static void insert(Connection conn, Scanner s) throws SQLException {
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "ORDER");
		PreparedStatement insertOrderStmt = conn.prepareStatement(insertOrderSQL);

		for (TypedAttribute a : colSet) {
			a.promptForValue(s);
			a.fillInStmt(insertOrderStmt, i++);
		}

		insertOrderStmt.executeUpdate();
		insertOrderStmt.close();
	}

	public static void activate(Connection conn, Scanner s) throws SQLException {
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
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT INVENTORY_ITEM.Quantity, [ORDER].Copies, INVENTORY_ITEM.Inventory_ID FROM INVENTORY_ITEM, [ORDER] WHERE INVENTORY_ITEM.Inventory_ID = [ORDER].Inventory_ID AND Order_ID="
							+ order_id);

			rs.next();
			int prevQuantity = rs.getInt("Quantity");
			int newQuantity = prevQuantity + rs.getInt("Copies");
			int inventory_id = rs.getInt("Inventory_ID");

			stmt.executeUpdate("UPDATE INVENTORY_ITEM SET Quantity=" + Integer.toString(newQuantity)
					+ " WHERE  INVENTORY_ITEM.Inventory_ID = [ORDER].Inventory_ID AND Inventory_ID =" + inventory_id);
			stmt.executeUpdate("UPDATE [ORDER] SET Status='FULFILLED' WHERE Order_ID =" + order_id);

			stmt.close();
		} else {
			System.out.println("Activation cancelled.");
		}
		selectOrderStatement.close();
	}
}
