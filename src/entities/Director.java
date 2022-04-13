package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Director implements Entity {
	private final static String insertDirectorSQL = "INSERT INTO DIRECTOR VALUES (?, ?);";
	private final static String editDirectorSQL = " UPDATE DIRECTOR SET Name=? WHERE Director_ID=?";
	private static final String maxDirectorIDSQL = "SELECT MAX(Director_ID) AS Max_ID FROM DIRECTOR;";

	private LinkedList<TypedAttribute> data;

	public Director() {
		this.data = null;
	}

	public Director(LinkedList<TypedAttribute> data) {
		this.data = data;
	}

	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextDirectorID(conn);
		return Utils.executeInsertion(conn, s, id, insertDirectorSQL, "DIRECTOR", "Director_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editDirectorSQL, "Director_ID");
	}
	
	public static int getNextDirectorID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxDirectorIDSQL, "Max_ID");
	}
}
