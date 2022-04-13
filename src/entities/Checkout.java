package entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Checkout implements Entity {

	private final static String insertCheckoutSQL = "INSERT INTO CHECKOUT VALUES (?, ?, ?, ?, ?, ?, ?);";
	private final static String editCheckoutSQL = "UPDATE CHECKOUT SET Card_ID=?, Inventory_ID=?, Return_Date=?, Checkout_Status=?, Start_Date=?, Due_Date=? WHERE Checkout_ID=?";
	private final static String returnCheckoutSQL = "UPDATE CHECKOUT SET Checkout_Status='Returned', Return_Date=? WHERE Checkout_ID=?";
	private static final String maxCheckoutIDSQL = "SELECT MAX(Checkout_ID) AS Max_ID FROM CHECKOUT;";

	private int checkoutID;
	private int inventoryItemID;
	private int cardItemID;
	private LinkedList<TypedAttribute> data;

	public Checkout() {
		this.data = null;
	}

	public Checkout(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Checkout_ID")) {
				this.checkoutID = (int) ta.value;
			} else if (ta.name.equals("Inventory_ID")) {
				this.inventoryItemID = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
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
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;
		Checkout a = new Checkout();

		if (insert) {
			key = (int) a.insert(conn, s);
		} else {
			a = Checkout.searchForOne(conn, s);
			key = a.checkoutID;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public void returnCheckout(Connection conn, Scanner s) throws SQLException {
		System.out.println("Returning this checkout.");
		System.out.println(this.toString());
		System.out.println("Returning checked-out item...");

		// Updating checkout record;
		PreparedStatement returnCheckoutStmt = conn.prepareStatement(returnCheckoutSQL);
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		returnCheckoutStmt.setString(1, date.toString());
		returnCheckoutStmt.setInt(2, this.checkoutID);
		returnCheckoutStmt.execute();

		// Updating inventory_item record;
		InventoryItem.changeQuantity(conn, this.inventoryItemID, 1);
	}

	public static Checkout searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "CHECKOUT");
			Utils.fillRowData(rs, rowData);
			return new Checkout(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "CHECKOUT");
	}

	public static int getNextCheckoutID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxCheckoutIDSQL, "Max_ID");
	}
}
