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

public class Movie implements Entity {

	private final static String insertMovieSQL = "INSERT INTO MOVIE VALUES (?, ?, ?, ?, ?);";
	private final static String retrieveMovieSQL = "SELECT * FROM MOVIE;";
	private final static String selectMovieSQL = "SELECT * FROM MOVIE WHERE Inventory_ID = ?";
	private final static String editMovieSQL = "UPDATE MOVIE SET ? WHERE Inventory_ID = ?";

	private LinkedList<TypedAttribute> data;
	
	public Movie() {
		this.data = null;
	}
	
	public Movie(LinkedList<TypedAttribute> data) {
		this.data = data;
	}
	
	public int insert(Connection conn, Scanner s) throws SQLException {
		InventoryItem parentItem = new InventoryItem();
		int id = parentItem.insert(conn, s);
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

	public void edit(Connection conn, Scanner s) throws SQLException {
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

	public static Movie searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = Album.search(conn, s);
		if (rs.first()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "MOVIE");
			Utils.fillRowData(rs, rowData);
			return new Movie(rowData);
		} else {
			return null;
		}
	}
	
	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		System.out.println("Which field do you want to search by?");
		System.out.println("1: Name | 2: Length | 3: Year | 4: Content_Rating | 5: EXIT");
		String input = s.nextLine();
		String searchInputString = "";
		int searchInputInt;
		PreparedStatement searchMovieSQLstmt = null;
		switch (input) {
		case "1":
			System.out.println("Enter search name");
			searchInputString = s.nextLine();
			searchMovieSQLstmt = conn.prepareStatement("SELECT * FROM MOVIE WHERE name = ?;");
			searchMovieSQLstmt.setString(1, searchInputString);
			break;
		case "2":
			System.out.println("Enter search Length");
			searchInputInt = Integer.parseInt(s.nextLine());
			searchMovieSQLstmt = conn.prepareStatement("SELECT * FROM MOVIE WHERE length = ?;");
			searchMovieSQLstmt.setInt(1, searchInputInt);
			break;
		case "3":
			System.out.println("Enter search Year");
			searchInputInt = Integer.parseInt(s.nextLine());
			searchMovieSQLstmt = conn.prepareStatement("SELECT * FROM MOVIE WHERE year = ?;");
			searchMovieSQLstmt.setInt(1, searchInputInt);
			break;
		case "4":
			System.out.println("Enter search Content_Rating");
			searchInputString = s.nextLine();
			searchMovieSQLstmt = conn.prepareStatement("SELECT * FROM MOVIE WHERE content_rating = ?;");
			searchMovieSQLstmt.setString(1, searchInputString);
			break;
		case "5":
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}

		if (searchMovieSQLstmt != null) {
			ResultSet rs = searchMovieSQLstmt.executeQuery();
			return rs;
		} else {
			System.out.println("No search performed");
			return null;
		}
	}
}
