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
	private static final String maxDirectorIDSQL = "SELECT MAX(Director_ID) AS Max_ID FROM DIRECTOR;";
	public static int getNextDirectorID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxDirectorIDSQL, "Max_ID");
	}
	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = 0;
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "DIRECTOR");
		PreparedStatement insertArtistStmt = conn.prepareStatement(insertDirectorSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Director_ID")) {
				id = getNextDirectorID(conn);
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertArtistStmt, i);
			i++;
		}

		insertArtistStmt.execute();

		return id;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		// TODO Auto-generated method stub

	}

}
