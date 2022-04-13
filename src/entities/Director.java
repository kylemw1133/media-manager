package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Director implements Entity {
	private final static String insertDirectorSQL = "INSERT INTO DIRECTOR VALUES (?, ?);";
	private final static String editDirectorSQL = " UPDATE DIRECTOR SET Name=? WHERE Director_ID=?";
	private static final String maxDirectorIDSQL = "SELECT MAX(Director_ID) AS Max_ID FROM DIRECTOR;";

	private final static String insertDirectsSQL = "INSERT INTO DIRECTS VALUES (?, ?);";

	public int id;
	public LinkedList<TypedAttribute> data;

	public Director() {
		this.data = null;
	}

	public Director(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Director_ID")) {
				this.id = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextDirectorID(conn);
		return Utils.executeInsertion(conn, s, id, insertDirectorSQL, "DIRECTOR", "Director_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editDirectorSQL, "Director_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = Director.searchForOne(conn, s).id;
		}

		return key;
	}

	public static void insertMultiple(Connection conn, Scanner s, int inventoryID) throws SQLException {
		int input;
		do {
			System.out.println("| 1: Create Director | 2: Choose Director | 3: Finish with Directors |");
			input = Integer.parseInt(s.nextLine());

			if (input == 3) {
				break;
			}

			Director d = new Director();
			int dID = (int) d.insertOrSearch(conn, s, input == 1);

			PreparedStatement insertJoinTupleStmt = conn.prepareStatement(insertDirectsSQL);
			insertJoinTupleStmt.setInt(1, inventoryID);
			insertJoinTupleStmt.setInt(2, dID);
			insertJoinTupleStmt.execute();
		} while (input != 3);

		System.out.println("Finished with Directors.");
	}

	public static Director searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs.first()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "DIRECTOR");
			Utils.fillRowData(rs, rowData);
			return new Director(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "DIRECTOR");
	}

                public static ResultSet list(Connection conn) throws SQLException {
        return Utils.executeList(conn, "DIRECTOR");
    }

	public static int getNextDirectorID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxDirectorIDSQL, "Max_ID");
	}
}
