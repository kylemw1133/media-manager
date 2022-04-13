package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Person implements Entity {

	private final static String insertPersonSQL = "INSERT INTO PERSON VALUES (?, ?, ?);";
	private final static String editPersonSQL = " UPDATE PERSON SET P_Email=?, P_Address=?, P_Name=? WHERE P_Email=?;";

	private final static String deleteInventoryItemSQL = "DELETE FROM INVENTORY_ITEM WHERE Inventory_ID = ?;";
	private static final String maxInventoryIDSQL = "SELECT MAX(Inventory_ID) AS Max_ID FROM INVENTORY_ITEM;";

	private final static String getQuantitySQL = "SELECT Quantity FROM INVENTORY_ITEM WHERE Inventory_ID=?";
	private final static String updateQuantitySQL = "UPDATE INVENTORY_ITEM SET Quantity=? WHERE Inventory_ID=?";

	public String pEmail;
	public LinkedList<TypedAttribute> data;

	public Person() {
		this.data = null;
	}

	public Person(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("P_Email")) {
				this.pEmail = (String) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		String pEmail = "";
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "PERSON");
		PreparedStatement insertStmt = conn.prepareStatement(insertPersonSQL);

		for (TypedAttribute a : colSet) {
			a.promptForValue(s);

			if (a.name.equals("P_Email")) {
				pEmail = (String) a.value;
			}

			a.fillInStmt(insertStmt, i++);
		}

		insertStmt.execute();
		insertStmt.close();

		return pEmail;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editPersonSQL, "P_Email");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		String key = "";
		Person a = new Person();

		if (insert) {
			key = (String) a.insert(conn, s);
		} else {
			a = Person.searchForOne(conn, s);
			key = a.pEmail;
		}

		return key;
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

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static String insertSingle(Connection conn, Scanner s) throws SQLException {
		System.out.println("| 1: Create Person | 2: Search for Person |");
		int input = Integer.parseInt(s.nextLine());

		Person p = new Person();
		String pEmail = (String) p.insertOrSearch(conn, s, input == 1);
		return pEmail;
	}

	public static Person searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "PERSON");
			Utils.fillRowData(rs, rowData);
			return new Person(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "PERSON");
	}
}
