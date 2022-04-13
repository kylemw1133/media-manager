package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Genre implements Entity {

	private final static String insertGenreSQL = "INSERT INTO GENRE VALUES (?);";
	private final static String editGenreSQL = " UPDATE GENRE SET Name=? WHERE Name=?";

	private final static String insertMediaGenreSQL = "INSERT INTO MEDIA_GENRE VALUES (?, ?);";

	public String name;
	public LinkedList<TypedAttribute> data;

	public Genre() {
		this.data = null;
	}

	public Genre(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Name")) {
				this.name = (String) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		String name = "";
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "GENRE");
		PreparedStatement insertGenreStmt = conn.prepareStatement(insertGenreSQL);

		for (TypedAttribute a : colSet) {
			a.promptForValue(s);

			if (a.name.equals("Genre_Name")) {
				name = (String) a.value;
			}

			a.fillInStmt(insertGenreStmt, i++);
		}

		insertGenreStmt.execute();
		insertGenreStmt.close();

		return name;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "GENRE");
		PreparedStatement editStmt = conn.prepareStatement(editGenreSQL);

		TypedAttribute a = rowData.getFirst();
		a.promptForValue(s);
		a.fillInStmt(editStmt, 1);
		a.fillInStmt(editStmt, 2);

		editStmt.execute();
		editStmt.close();
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		String key = "";

		if (insert) {
			key = (String) this.insert(conn, s);
		} else {
			key = Genre.searchForOne(conn, s).name;
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
			System.out.println("| 1: Create Genre | 2: Choose Genre | 3: Finish with Genres |");
			input = Integer.parseInt(s.nextLine());

			if (input == 3) {
				break;
			}

			Genre g = new Genre();
			String genreName = (String) g.insertOrSearch(conn, s, input == 1);

			PreparedStatement insertJoinTupleStmt = conn.prepareStatement(insertMediaGenreSQL);
			insertJoinTupleStmt.setObject(1, inventoryID);
			insertJoinTupleStmt.setObject(2, genreName);
			insertJoinTupleStmt.execute();
		} while (input != 3);

		System.out.println("Finished with Genres.");
	}

	public static Genre searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "GENRE");
			Utils.fillRowData(rs, rowData);
			return new Genre(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet list(Connection conn) throws SQLException {
		return Utils.executeList(conn, "GENRE");
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "GENRE");
	}
}
