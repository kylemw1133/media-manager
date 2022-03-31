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

public class Movie {

	private final static String insertMovieSQL = "INSERT INTO MOVIE VALUES (?, ?, ?, ?, ?);";
	private final static String retrieveMovieSQL = "SELECT * FROM MOVIE;";
	private final static String editMovieSQL = "UPDATE MOVIE SET ";

	public static int insert(Connection conn, Scanner s) throws SQLException {
		int id = InventoryItem.insert(conn, s);
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "MOVIE");
		PreparedStatement insertMovieStmt = conn.prepareStatement(insertMovieSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertMovieStmt, i);
			i++;
		}

		insertMovieStmt.executeUpdate();

		return id;
	}

	public static void edit(Connection conn, Scanner s) {

	}

	public static void retrieve(Connection conn, Scanner s) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(retrieveMovieSQL);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String value = rsmd.getColumnName(i);
				System.out.print(value);
				if (i < columnCount)
					System.out.print(",  ");
			}
			System.out.print("\n");
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String columnValue = rs.getString(i);
					System.out.print(columnValue);
					if (i < columnCount)
						System.out.print(",  ");
				}
				System.out.print("\n");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
