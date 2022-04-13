package entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Artist implements Entity {

	private final static String insertArtistSQL = "INSERT INTO ARTIST VALUES (?, ?);";
	private final static String editArtistSQL = " UPDATE ARTIST SET Name=? WHERE Artist_ID=?";
	private static final String maxArtistIDSQL = "SELECT MAX(Artist_ID) AS Max_ID FROM ARTIST;";

	private LinkedList<TypedAttribute> data;

	public Artist() {
		this.data = null;
	}

	public Artist(LinkedList<TypedAttribute> data) {
		this.data = data;
	}

	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextArtistID(conn);
		return Utils.executeInsertion(conn, s, id, insertArtistSQL, "ARTIST", "Artist_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editArtistSQL, "Artist_ID");
	}

	public static int getNextArtistID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxArtistIDSQL, "Max_ID");
	}
}
