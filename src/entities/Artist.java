package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Artist implements Entity {

	private final static String insertArtistSQL = "INSERT INTO ARTIST VALUES (?, ?);";
	private static final String maxArtistIDSQL = "SELECT MAX(Artist_ID) AS Max_ID FROM ARTIST;";

	public static int getNextArtistID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxArtistIDSQL, "Max_ID");
	}

	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = 0;
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "ARTIST");
		PreparedStatement insertArtistStmt = conn.prepareStatement(insertArtistSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				id = getNextArtistID(conn);
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
