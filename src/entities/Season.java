package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Season implements Entity {

	private final static String insertSeasonSQL = "INSERT INTO SEASON VALUES (?, ?, ?)";
	private final static String editSeasonSQL = "UPDATE SEASON SET Season_Year=? WHERE Inventory_ID=? AND Season_Number=?";
	
	private static final String maxSeasonNumberSQL = "SELECT MAX(Season_Number) AS Max_Season_Number FROM SEASON WHERE Inventory_ID=?;";
	
	public int inventoryID;
	public int seasonNo;
	public LinkedList<TypedAttribute> data;

	public Season() {
		this.data = null;
	}
	
	public Season(int id) {
		this.inventoryID = id;
		this.data = null;
	}

	public Season(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Inventory_ID")) {
				this.inventoryID = (int) ta.value;
			} else if (ta.name.equals("Season_Number")) {
				this.seasonNo = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int seasonNo = this.getNextSeasonNumber(conn);
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "SEASON");
		PreparedStatement insertStmt = conn.prepareStatement(insertSeasonSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				a.value = this.inventoryID;
			} else if (a.name.equals("Season_Number")) {
				a.value = seasonNo;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertStmt, i++);
		}

		insertStmt.execute();
		insertStmt.close();

		Utils.executeInsertion(conn, s, this.inventoryID, insertSeasonSQL, "SEASON", "Inventory_ID");
		Episode.insertMultiple(conn, s, this.inventoryID, this.seasonNo);
		
		return this.seasonNo;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editSeasonSQL, "Inventory_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = Season.searchForOne(conn, s).inventoryID;
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
			System.out.println("| 1: Create Season | 2: Finish with Seasons |");
			input = Integer.parseInt(s.nextLine());

			if (input == 2) {
				break;
			}

			Season se = new Season(inventoryID);
			int seID = (int) se.insert(conn, s);
		} while (input != 2);
		
		System.out.println("Finished with Seasons.");
	}

	public static Season searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ALBUM");
			Utils.fillRowData(rs, rowData);
			return new Season(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "ALBUM");
	}
	
	public int getNextSeasonNumber(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(maxSeasonNumberSQL);
		stmt.setInt(1, this.inventoryID);
		ResultSet rs = stmt.executeQuery();
		int maxID = rs.getInt("Max_Season_Number");
		stmt.close();
		return maxID + 1;	
	}
}