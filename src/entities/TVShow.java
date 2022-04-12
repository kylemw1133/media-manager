package entities;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class TVShow implements Entity {

	private final static String insertTVShowSQL = "INSERT INTO TV_SHOW VALUES (?, ?, ?, ?);";
	private final static String retrieveTVShowSQL = "SELECT * FROM TV_SHOW;";
	private final static String editTVShowSQL = " UPDATE TV_SHOW SET Name=?, Year=?, Rating=? WHERE Inventory_ID=?;";

	private LinkedList<TypedAttribute> data;
	
	public TVShow() {
		this.data = null;
	}
	
	public TVShow(LinkedList<TypedAttribute> data) {
		this.data = data;
	}
	
	public int insert(Connection conn, Scanner s) throws SQLException {
		InventoryItem parentItem = new InventoryItem();
		int id = parentItem.insert(conn, s);
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "TV_SHOW");
		PreparedStatement insertTVShowStmt = conn.prepareStatement(insertTVShowSQL);

		for (TypedAttribute a : colSet) {
			if (a.name == "Inventory_ID") {
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertTVShowStmt, i);
			i++;
		}

		insertTVShowStmt.executeUpdate();

		return id;
	}

	public void edit(Connection conn, Scanner s) throws SQLException {
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "TV_SHOW");
		PreparedStatement editTVShowStmt = conn.prepareStatement(editTVShowSQL);
		int i = 1;
		int id = 0;

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				System.out.print("Provide the ID of the item you want to edit: ");
				id = Integer.parseInt(s.nextLine());
			} else {
				a.promptForValue(s);
				a.fillInStmt(editTVShowStmt, i++);
			}
		}

		editTVShowStmt.setInt(i, id);

		editTVShowStmt.executeUpdate();
	}

	public static TVShow searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = Album.search(conn, s);
		if (rs.first()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "TV_SHOW");
			Utils.fillRowData(rs, rowData);
			return new TVShow(rowData);
		} else {
			return null;
		}
	}
	
	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		System.out.println("Which field do you want to search by?");
		System.out.println("1: Name | 2: Year | 3: Rating | 4: EXIT: ");
		String input = s.nextLine();
		String searchInputString = "";
		PreparedStatement searchTVShowSQLstmt = null;
		switch (input) {
		case "1":
			System.out.println("Enter search name");
			searchInputString = s.nextLine();
			searchTVShowSQLstmt = conn.prepareStatement("SELECT * FROM TV_SHOW WHERE name = ?;");
			searchTVShowSQLstmt.setString(1, searchInputString);

			break;

		case "2":
			System.out.println("Enter search year");
			searchInputString = s.nextLine();
			searchTVShowSQLstmt = conn.prepareStatement("SELECT * FROM TV_SHOW WHERE year = ?;");
			searchTVShowSQLstmt.setString(1, searchInputString);
			break;

		case "3":
			System.out.println("Enter search rating");
			searchInputString = s.nextLine();
			searchTVShowSQLstmt = conn.prepareStatement("SELECT * FROM TV_SHOW WHERE rating = ?;");
			searchTVShowSQLstmt.setString(1, searchInputString);
			break;
		case "4":
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}

		if (searchTVShowSQLstmt != null) {
			ResultSet rs = searchTVShowSQLstmt.executeQuery();
			return rs;
		} else {
			System.out.println("No search performed");
			return null;
		}
	}
}
