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
	private final static String editMovieSQL = " UPDATE MOVIE SET Name=?, Length=?, Year=?, Content_Rating=? WHERE Inventory_ID=?";
	
	public static int insert(Connection conn, Scanner s) throws SQLException {
		int id = InventoryItem.insert(conn, s);
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "MOVIE");
		PreparedStatement insertMovieStmt = conn.prepareStatement(insertMovieSQL);
		int i = 1;

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
	
	public static void edit(Connection conn, Scanner s) throws SQLException {
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "MOVIE");
		PreparedStatement editMovieStmt = conn.prepareStatement(editMovieSQL);
		int i = 1;
		int id = 0;

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				System.out.print("Provide the ID of the item you want to edit: ");
				id = Integer.parseInt(s.nextLine());
			} else {
				a.promptForValue(s);
				a.fillInStmt(editMovieStmt, i++);
			}
		}
		
		editMovieStmt.setInt(i, id);
		
		editMovieStmt.executeUpdate();
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
