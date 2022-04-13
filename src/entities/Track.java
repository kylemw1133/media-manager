package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Track implements Entity {

	private final static String insertTrackSQL = "INSERT INTO TRACK VALUES (?, ?, ?, ?, ?);";
	private final static String editTrackSQL = " UPDATE TRACK SET Artist_ID=?, Name=?, Year=?, Length=? WHERE Inventory_ID=?, Name=?";

	public int inventoryID;
	public LinkedList<TypedAttribute> data;

	public Track() {
		this.data = null;
	}

	public Track(int id) {
		this.inventoryID = id;
		this.data = null;
	}

	public Track(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Inventory_ID")) {
				this.inventoryID = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		return Utils.executeInsertion(conn, s, this.inventoryID, insertTrackSQL, "TRACK", "Inventory_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editTrackSQL, "Inventory_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = Track.searchForOne(conn, s).inventoryID;
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
			System.out.println("| 1: Create Track | 2: Finish with Track |");
			input = Integer.parseInt(s.nextLine());

			if (input == 2) {
				break;
			}

			Track t = new Track(inventoryID);
			int tID = (int) t.insert(conn, s);
		} while (input != 2);

		System.out.println("Finished with Tracks.");
	}

	public static Track searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ACTOR");
			Utils.fillRowData(rs, rowData);
			return new Track(rowData);
		} else {
			return null;
		}
	}


        public static ResultSet list(Connection conn) throws SQLException {
        return Utils.executeList(conn, "ACTOR");
    }



	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "ACTOR");
	}
}
