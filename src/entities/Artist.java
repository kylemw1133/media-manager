package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Artist implements Entity {

	private final static String insertArtistSQL = "INSERT INTO ARTIST VALUES (?, ?);";
	private final static String editArtistSQL = " UPDATE ARTIST SET Name=? WHERE Artist_ID=?";
	private static final String maxArtistIDSQL = "SELECT MAX(Artist_ID) AS Max_ID FROM ARTIST;";

	private final static String insertAlbumArtistSQL = "INSERT INTO ALBUM_ARTIST VALUES (?, ?);";
	
	public int id;
	public LinkedList<TypedAttribute> data;

	public Artist() {
		this.data = null;
	}

	public Artist(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Artist_ID")) {
				this.id = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextArtistID(conn);
		return Utils.executeInsertion(conn, s, id, insertArtistSQL, "ARTIST", "Artist_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editArtistSQL, "Artist_ID");
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

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}
	
	public static void insertMultiple(Connection conn, Scanner s, int inventoryID) throws SQLException {
		int input;
		do {
			System.out.println("| 1: Create Artist | 2: Choose Artist | 3: Finish with Artists |");
			input = Integer.parseInt(s.nextLine());

			if (input == 3) {
				break;
			}

			Artist a = new Artist();
			int aID = (int) a.insertOrSearch(conn, s, input == 1);
						
			PreparedStatement insertJoinTupleStmt = conn.prepareStatement(insertAlbumArtistSQL);
			insertJoinTupleStmt.setInt(1, inventoryID);
			insertJoinTupleStmt.setInt(2, aID);
			insertJoinTupleStmt.execute();
		} while (input != 3);
		
		System.out.println("Finished with Artists.");
	}

	public static Artist searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ARTIST");
			Utils.fillRowData(rs, rowData);
			return new Artist(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "ARTIST");
	}

	public static int getNextArtistID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxArtistIDSQL, "Max_ID");
	}
}
