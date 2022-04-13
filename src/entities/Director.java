package entities;

import java.sql.Connection;
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
		Director a = new Director();

		if (insert) {
			key = (int) a.insert(conn, s);
		} else {
			a = Director.searchForOne(conn, s);
			key = a.id;
		}

		return key;
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

	public static int getNextDirectorID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxDirectorIDSQL, "Max_ID");
	}
}
