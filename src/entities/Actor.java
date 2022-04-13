package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Actor implements Entity {

	private final static String insertActorSQL = "INSERT INTO Actor VALUES (?, ?);";
	private final static String editActorSQL = " UPDATE ACTOR SET Name=? WHERE Actor_ID=?";
	private static final String maxActorSQL = "SELECT MAX(Actor_ID) AS Max_ID FROM Actor;";

	private LinkedList<TypedAttribute> data;

	public Actor() {
		this.data = null;
	}

	public Actor(LinkedList<TypedAttribute> data) {
		this.data = data;
	}

	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextActorID(conn);
		return Utils.executeInsertion(conn, s, id, insertActorSQL, "ACTOR", "Actor_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editActorSQL, "Actor_ID");
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Album searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ACTOR");
			Utils.fillRowData(rs, rowData);
			return new Album(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "ACTOR");
	}

	public static int getNextActorID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxActorSQL, "Max_ID");
	}
}
