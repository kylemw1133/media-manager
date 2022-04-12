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
	private final static String selectMovieSQL = "SELECT * FROM MOVIE WHERE Inventory_ID = ?";
	private final static String editMovieSQL = "UPDATE MOVIE SET ? WHERE Inventory_ID = ?";

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

		insertMovieStmt.executeUpdate();

		return id;
	}

	public static void edit(Connection conn, Scanner s) throws SQLException {
		PreparedStatement selectMovieStmt = conn.prepareStatement(selectMovieSQL);
		PreparedStatement editMovieStmt = conn.prepareStatement(editMovieSQL);

		System.out.println("Enter the inventory ID of the movie ");

		String id = "";
		// repeat promp for inventory id until user inputs a valid integer
		while (id.equals("") || !id.matches("\\-?\\d+")) {
			id = s.nextLine();
		}

		selectMovieStmt.setString(1, id);
		editMovieStmt.setString(2, id);

		ResultSet selectedRecord = selectMovieStmt.executeQuery();

		if (selectedRecord.next()) {
			Utils.printRecords(selectedRecord);
			System.out.println("Which field do you want to edit?");
			System.out.println("1: Name | 2: Length | 3: Year | 4: Content_Rating | 5: EXIT");
			String input = s.nextLine();
			String newInput = "";

			switch (input) {
			case "1":
				System.out.println("Enter new Name");
				newInput = "Name=" + s.nextLine();
			case "2":
				System.out.println("Enter new Length");
				newInput = "Length=" + s.nextLine();
			case "3":
				System.out.println("Enter new Year");
				newInput = "Year=" + s.nextLine();
			case "4":
				System.out.println("Enter new Content_Rating");
				newInput = "Content_Rating=" + s.nextLine();

			case "5":
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid input");
				break;
			}

			if (newInput != "") {
				editMovieStmt.setString(1, newInput);
				editMovieStmt.executeUpdate();
			}

		} else {
			System.out.println("Record not found...");
		}
		editMovieStmt.close();
		selectMovieStmt.close();
		/*
		 * LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "MOVIE");
		 * PreparedStatement editMovieStmt = conn.prepareStatement(editMovieSQL); int i
		 * = 1; int id = 0;
		 * 
		 * for (TypedAttribute a : colSet) { if (a.name.equals("Inventory_ID")) {
		 * System.out.print("Provide the ID of the item you want to edit: "); id =
		 * Integer.parseInt(s.nextLine()); } else { a.promptForValue(s);
		 * a.fillInStmt(editMovieStmt, i++); } }
		 * 
		 * editMovieStmt.setInt(i, id);
		 * 
		 * editMovieStmt.executeUpdate();
		 */
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

	public static void search(Connection conn, Scanner s) throws SQLException {
		Statement stmt = conn.createStatement();
		System.out.println("Which field do you want to search by?");
		System.out.println("1: Name | 2: Length | 3: Year | 4: Content_Rating | 5: EXIT");
		String input = s.nextLine();
		String searchInputString = "";
		int searchInputInt;
		String searchCol = "";
		String searchMovieSQL = "";
		switch (input) {
		case "1":
			System.out.println("Enter search name");
			searchCol = "name";
			searchInputString = s.nextLine();
			searchMovieSQL = "SELECT * FROM MOVIE WHERE " + searchCol + "=" + "\"" + searchInputString + "\";";
			break;
		case "2":
			System.out.println("Enter search Length");
			searchCol = "length";
			searchInputInt = Integer.parseInt(s.nextLine());
			searchMovieSQL = "SELECT * FROM MOVIE WHERE " + searchCol + "=" + searchInputInt + ";";

			break;
		case "3":
			System.out.println("Enter search Year");
			searchCol = "year";
			searchInputInt = Integer.parseInt(s.nextLine());
			searchMovieSQL = "SELECT * FROM MOVIE WHERE " + searchCol + "=" + searchInputInt + ";";

			break;
		case "4":
			System.out.println("Enter search Content_Rating");
			searchCol = "content_rating";
			searchInputString = s.nextLine();
			searchMovieSQL = "SELECT * FROM MOVIE WHERE " + searchCol + "=" + "\"" + searchInputString + "\"; ";
			break;
		case "5":
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		if (searchCol != "") {

			ResultSet rs = stmt.executeQuery(searchMovieSQL);
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
		} else {
			System.out.println("...");
		}
	}
}
