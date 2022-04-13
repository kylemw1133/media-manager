package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Author implements Entity {

	private final static String insertAuthorSQL = "INSERT INTO AUTHOR VALUES (?, ?);";
	private final static String editAuthorSQL = " UPDATE AUTHOR SET Name=? WHERE Author_ID=?";
	private static final String maxAuthorSQL = "SELECT MAX(Author_ID) AS Max_ID FROM AUTHOR;";

	public int id;
	public LinkedList<TypedAttribute> data;

	public Author() {
		this.data = null;
	}

	public Author(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Author_ID")) {
				this.id = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextAuthorID(conn);
		return Utils.executeInsertion(conn, s, id, insertAuthorSQL, "AUTHOR", "Author_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editAuthorSQL, "Author_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = searchForOne(conn, s).id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Author searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "AUTHOR");
			Utils.fillRowData(rs, rowData);
			return new Author(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "AUTHOR");
	}

	public static ResultSet list(Connection conn) throws SQLException {
		return Utils.executeList(conn, "AUTHOR");
	}

	public static int getNextAuthorID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxAuthorSQL, "Max_ID");
	}
}
