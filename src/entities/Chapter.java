package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Chapter implements Entity {

	private final static String insertChapterSQL = "INSERT INTO CHAPTER VALUES (?, ?, ?)";
	private final static String editChapterSQL = "UPDATE CHAPTER "
			+ "SET Inventory_ID=?, Name=?, Length=? "
			+ "WHERE Inventory_ID=? AND Name=?;";

	public int inventoryID;
	public String name;
	public LinkedList<TypedAttribute> data;

	public Chapter() {
		this.data = null;
	}

	public Chapter(int id) {
		this.inventoryID = id;
		this.data = null;
	}

	public Chapter(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Inventory_ID")) {
				this.inventoryID = (int) ta.value;
			} else if (ta.name.equals("Name")) {
				this.name = (String) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		return Utils.executeInsertion(conn, s, this.inventoryID, insertChapterSQL, "CHAPTER", "Inventory_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		PreparedStatement editStmt = conn.prepareStatement(editChapterSQL);
		int i = 1;
		int id = 0;
		String name = "";

		for (TypedAttribute a : this.data) {
			if (a.name.contains("Inventory_ID")) {
				id = (int) a.value;
			} else if (a.name.contains("Name")) {
				name = (String) a.value;
				a.promptForValue(s);
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(editStmt, i++);
		}

		editStmt.setInt(i++, id);
		editStmt.setString(i, name);

		editStmt.execute();
		editStmt.close();
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = Chapter.searchForOne(conn, s).inventoryID;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static void insertMultiple(Connection conn, Scanner s, int inventoryID) throws SQLException {
		int input;
		do {
			System.out.println("| 1: Create Chapter | 2: Finish with Chapters |");
			input = Integer.parseInt(s.nextLine());

			if (input == 2) {
				break;
			}

			Chapter c = new Chapter(inventoryID);
			int cID = (int) c.insert(conn, s);
		} while (input != 2);

		System.out.println("Finished with Chapters.");
	}

	public static Chapter searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "CHAPTER");
			Utils.fillRowData(rs, rowData);
			return new Chapter(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet list(Connection conn) throws SQLException {
		return Utils.executeList(conn, "CHAPTER");
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "CHAPTER");
	}
}
