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

public class Checkout implements Entity {

	private final static String insertCheckoutSQL = "INSERT INTO CHECKOUT VALUES (?, ?, ?, ?, ?, ?, ?);";
	private final static String editCheckoutSQL = "UPDATE CHECKOUT SET Card_ID=?, Inventory_ID=?, Return_Date=?, Checkout_Status=?, Start_Date=?, Due_Date=? WHERE Checkout_ID=?";
	
	private final static String selectCheckoutSQL = "SELECT * FROM CHECKOUT WHERE Order_ID=?;";
	private final static String updateInventorySQL = "UPDATE INVENTORY_ITEM SET Quantity=? WHERE INVENTORY_ITEM.Inventory_ID=?";
	private final static String updateOrderSQL = "UPDATE [ORDER] SET Status='FULFILLED' WHERE Order_ID=?";
	private static final String maxCheckoutIDSQL = "SELECT MAX(Checkout_ID) AS Max_ID FROM CHECKOUT;";

	private int inventoryItemID;
	private int cardItemID;
	private LinkedList<TypedAttribute> data;

	public Checkout() {
		this.data = null;
	}

	public Checkout(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Inventory_ID")) {
				this.inventoryItemID = (int) ta.value;
			}
		}
	}

	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextCheckoutID(conn);
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "CHECKOUT");
		PreparedStatement insertAlbumStmt = conn.prepareStatement(insertCheckoutSQL);
		
		for (TypedAttribute a : colSet) {
			if (a.name.equals("Checkout_ID")) {
				a.value = id;
			} else if (a.name.equals("Inventory_ID")) {
				this.inventoryItemID = 1;
				a.value = 1;
			} else if (a.name.equals("Card_ID")) {
				this.cardItemID = 1;
				a.value = 1;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertAlbumStmt, i);
			i++;
		}

		insertAlbumStmt.execute();
		insertAlbumStmt.close();

		return id;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editCheckoutSQL, "Order_ID");
	}
	
	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public void returnCheckout(Connection conn, Scanner s) throws SQLException {
		// Get an order
		// Get the associated inventory item
		// increase the items quantity by the order's quantity
		// change the order status	
		System.out.println("Returning this checkout.");
		System.out.println(this.toString());
		System.out.println("Returning checked-out item...");
		InventoryItem.changeQuantity(conn, this.inventoryItemID, 1);
	}

	public static Checkout searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = Checkout.search(conn, s);
		if (rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "CHECKOUT");
			Utils.fillRowData(rs, rowData);
			return new Checkout(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		System.out.println("Which field do you want to search by?");
		
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "Checkout");
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < colSet.size(); i++) {
			sb.append("| " + (i+1) + ": " + colSet.get(i).name + " ");
		}
		sb.append("| " + (i+1) + ": EXIT |");

		System.out.println(sb.toString());
		int input = Integer.parseInt(s.nextLine());
		TypedAttribute chosenAttribute = colSet.get(input - 1);
		String selectCheckoutSQL = "SELECT * FROM CHECKOUT WHERE " + chosenAttribute.name + "=?;";
		PreparedStatement selectCheckoutStmt = conn.prepareStatement(selectCheckoutSQL);
		chosenAttribute.promptForValue(s);
		chosenAttribute.fillInStmt(selectCheckoutStmt, 1);
		ResultSet rs = selectCheckoutStmt.executeQuery();
		return rs;
		
//		System.out.println("1: Card_ID | 2: Inventory_ID | 3: Return_Date | 4: Checkout_Status | 5: Start_Date | 6: Due_Date | 7: EXIT: ");
//
//		PreparedStatement searchCheckoutSQLstmt = null;
//		switch (input) {
//		case "1":
//			System.out.println("Enter Card_ID");
//			searchInputString = s.nextLine();
//			searchCheckoutSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE name = ?;");
//			searchCheckoutSQLstmt.setString(1, searchInputString);
//			break;
//		case "2":
//			System.out.println("Enter Inventory_ID");
//			searchInputInt = Integer.parseInt(s.nextLine());
//			searchCheckoutSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE length = ?;");
//			searchCheckoutSQLstmt.setInt(1, searchInputInt);
//			break;
//		case "3":
//			System.out.println("Enter Return_Date");
//			searchInputString = s.nextLine();
//			searchCheckoutSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE year = ?;");
//			searchCheckoutSQLstmt.setString(1, searchInputString);
//			break;
//		case "4":
//			System.out.println("Enter Checkout_Status");
//			searchInputString = s.nextLine();
//			searchCheckoutSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE name = ?;");
//			searchCheckoutSQLstmt.setString(1, searchInputString);
//			break;
//		case "5":
//			System.out.println("Enter Start_Date");
//			searchInputInt = Integer.parseInt(s.nextLine());
//			searchCheckoutSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE length = ?;");
//			searchCheckoutSQLstmt.setInt(1, searchInputInt);
//			break;
//		case "6":
//			System.out.println("Enter Due_Date");
//			searchInputString = s.nextLine();
//			searchCheckoutSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE year = ?;");
//			searchCheckoutSQLstmt.setString(1, searchInputString);
//			break;
//		case "7":
//			System.out.println("Exit");
//			break;
//		default:
//			System.out.println("Invalid input");
//			break;
//		}
//
//		if (searchAlbumSQLstmt != null) {
//			ResultSet rs = searchAlbumSQLstmt.executeQuery();
//			return rs;
//		} else {
//			System.out.println("No search performed");
//			return null;
//		}
	}

	public static int getNextCheckoutID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxCheckoutIDSQL, "Max_ID");
	}
}
