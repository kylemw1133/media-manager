package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Episode implements Entity {

	private final static String insertEpisodeSQL = "INSERT INTO EPISODE VALUES (?, ?, ?, ?, ?);";
	private final static String editEpisodeSQL = " UPDATE EPISODE SET Director_ID=?, Episode_Name=?, Episode_Length=? WHERE Inventory_ID=? AND Season_Number=?";
	
	public int inventoryID;
	public int seasonNo;
	public String name;
	public LinkedList<TypedAttribute> data;

	public Episode() {
		this.data = null;
	}
	
	public Episode(int inventoryID, int seasonNo) {
		this.inventoryID = inventoryID;
		this.seasonNo = seasonNo;
		this.data = null;
	}

	public Episode(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Inventory_ID")) {
				this.inventoryID = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "EPISODE");
		PreparedStatement insertStmt = conn.prepareStatement(insertEpisodeSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				a.value = this.inventoryID;
			} else if (a.name.equals("Season_Number")) {
				a.value = this.seasonNo;
			} else {
				a.promptForValue(s);
			}

			if (a.name.equals("Episode_Name")) {
				this.name = (String) a.value;
			}
			
			a.fillInStmt(insertStmt, i++);
		}

		insertStmt.execute();
		insertStmt.close();

		return this.name;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editEpisodeSQL, "Actor_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = Episode.searchForOne(conn, s).inventoryID;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static void insertMultiple(Connection conn, Scanner s, int inventoryID, int seasonNo) throws SQLException {
		int input;
		do {
			System.out.println("| 1: Create Episode | 2: Finish with Episodes |");
			input = Integer.parseInt(s.nextLine());

			if (input == 2) {
				break;
			}

			Episode e = new Episode(inventoryID, seasonNo);
			e.insert(conn, s);
		} while (input != 2);
		
		System.out.println("Finished with Tracks.");
	}
	
	public static Episode searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ACTOR");
			Utils.fillRowData(rs, rowData);
			return new Episode(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "ACTOR");
	}
}
