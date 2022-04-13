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
	private final static String editEpisodeSQL = "UPDATE EPISODE "
			+ "SET Inventory_ID=?, Season_Number=?, Director_ID=?, Episode_Name=?, Episode_Length=? "
			+ "WHERE Inventory_ID=? AND Season_Number=? AND Episode_Name=?;";
	
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

		Actor.insertMultiple(conn, s, this.inventoryID);

		return this.name;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		PreparedStatement editStmt = conn.prepareStatement(editEpisodeSQL);
		int i = 1;
		int id = 0;
		int seasonNo = 0;
		String episodeName = "";

		for (TypedAttribute a : this.data) {
			if (a.name.contains("Inventory_ID")) {
				id = (int) a.value;
			} else if (a.name.contains("Season_Number")) {
				seasonNo = (int) a.value;
				a.promptForValue(s);
			} else if (a.name.contains("Episode_Name")) {
				episodeName = (String) a.value;
				a.promptForValue(s);
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(editStmt, i++);
		}

		editStmt.setInt(i++, id);
		editStmt.setInt(i++, seasonNo);
		editStmt.setString(i, episodeName);

		editStmt.execute();
		editStmt.close();
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

		System.out.println("Finished with Episodes.");
	}

	public static Episode searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "EPISODE");
			Utils.fillRowData(rs, rowData);
			return new Episode(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "EPISODE");
	}

                    public static ResultSet list(Connection conn) throws SQLException {
        return Utils.executeList(conn, "EPISODE");
    }
}
