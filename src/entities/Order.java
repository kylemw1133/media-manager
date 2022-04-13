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

public class Order implements Entity {

	private final static String insertOrderSQL = "INSERT INTO [ORDER] VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final static String editOrderSQL = "INSERT INTO [ORDER] VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final static String selectOrderSQL = "SELECT * FROM [ORDER] WHERE Order_ID=?;";
	private final static String updateInventorySQL = "UPDATE INVENTORY_ITEM SET Quantity=? WHERE INVENTORY_ITEM.Inventory_ID=?";
	private final static String updateOrderSQL = "UPDATE [ORDER] SET Status='FULFILLED' WHERE Order_ID=?";
	private static final String maxOrderIDSQL = "SELECT MAX(Order_ID) AS Max_ID FROM [ORDER];";

	private LinkedList<TypedAttribute> data;
	
	public Order() {
		this.data = null;
	}
	
	public Order(LinkedList<TypedAttribute> data) {
		this.data = data;
	}
	
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = 0;
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "ORDER");
		PreparedStatement insertOrderStmt = conn.prepareStatement(insertOrderSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Order_ID")) {
				id = getNextOrderID(conn);
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertOrderStmt, i++);
		}

		insertOrderStmt.execute();
		insertOrderStmt.close();

		return id;
	}
	
	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editOrderSQL, "Order_ID");
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
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT INVENTORY_ITEM.Quantity, [ORDER].Copies, INVENTORY_ITEM.Inventory_ID FROM INVENTORY_ITEM, [ORDER] WHERE INVENTORY_ITEM.Inventory_ID = [ORDER].Inventory_ID AND Order_ID="
							+ order_id);

			rs.next();
			int prevQuantity = rs.getInt("Quantity");
			int newQuantity = prevQuantity + rs.getInt("Copies");
			int inventoryID = rs.getInt("Inventory_ID");

			stmt.executeUpdate(updateOrderSQL);
			stmt.close();

			PreparedStatement updateStmt = conn.prepareStatement(updateInventorySQL);
			updateStmt.setInt(1, newQuantity);
			updateStmt.setInt(2, inventoryID);
			updateStmt.execute();
		} else {
			System.out.println("Activation cancelled.");
		}
		selectOrderStatement.close();
	}
	
	public static Order searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = Album.search(conn, s);
		if (rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ORDER");
			Utils.fillRowData(rs, rowData);
			return new Order(rowData);
		} else {
			return null;
		}
	}
	
	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		System.out.println("Which field do you want to search by?");
		System.out.println("1: Name | 2: Length | 3: Year | 4: EXIT: ");
		String input = s.nextLine();
		String searchInputString = "";
		int searchInputInt;
		PreparedStatement searchAlbumSQLstmt = null;
		switch (input) {
		case "1":
			System.out.println("Enter search name");
			searchInputString = s.nextLine();
			searchAlbumSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE name = ?;");
			searchAlbumSQLstmt.setString(1, searchInputString);
			break;
		case "2":
			System.out.println("Enter search Length");
			searchInputInt = Integer.parseInt(s.nextLine());
			searchAlbumSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE length = ?;");
			searchAlbumSQLstmt.setInt(1, searchInputInt);
			break;
		case "3":
			System.out.println("Enter search year");
			searchInputString = s.nextLine();
			searchAlbumSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE year = ?;");
			searchAlbumSQLstmt.setString(1, searchInputString);
			break;

		case "4":
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		
		if (searchAlbumSQLstmt != null) {
			ResultSet rs = searchAlbumSQLstmt.executeQuery();
			return rs;
		} else {
			System.out.println("No search performed");
			return null;
		}
	}

	public static int getNextOrderID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxOrderIDSQL, "Max_ID");
	}
}
