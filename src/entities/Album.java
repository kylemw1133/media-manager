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

public class Album implements Entity {

	private final static String insertAlbumSQL = "INSERT INTO ALBUM VALUES (?, ?, ?, ?);";
	private final static String editAlbumSQL = " UPDATE ALBUM SET Name=?, Length=?, Year=? WHERE Inventory_ID=?";

	private LinkedList<TypedAttribute> data;
	
	public Album() {
		this.data = null;
	}
	
	public Album(LinkedList<TypedAttribute> data) {
		this.data = data;
	}
	
	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		InventoryItem parentItem = new InventoryItem();
		int id = parentItem.insert(conn, s);
		return Utils.executeInsertion(conn, s, id, insertAlbumSQL, "ALBUM", "Inventory_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editAlbumSQL, "Inventory_ID");
	}
	
	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Album searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = Album.search(conn, s);
		if (rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ALBUM");
			Utils.fillRowData(rs, rowData);
			return new Album(rowData);
		} else {
			return null;
		}
	}
	
	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		System.out.println("Which field do you want to search by?");
		System.out.println("1: Name | 2: Length | 3: Year | 4: EXIT: ");
		String input = s.nextLine();
		String searchInputString = "";
		int searchInputInt;
		PreparedStatement searchAlbumSQLstmt = null;
		
		switch (input) {
		case "1":
			System.out.println("Enter search name");
			searchInputString = s.nextLine();
			searchAlbumSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE name = ?;");
			searchAlbumSQLstmt.setString(1, searchInputString);
			break;
		case "2":
			System.out.println("Enter search Length");
			searchInputInt = Integer.parseInt(s.nextLine());
			searchAlbumSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE length = ?;");
			searchAlbumSQLstmt.setInt(1, searchInputInt);
			break;
		case "3":
			System.out.println("Enter search year");
			searchInputString = s.nextLine();
			searchAlbumSQLstmt = conn.prepareStatement("SELECT * FROM ALBUM WHERE year = ?;");
			searchAlbumSQLstmt.setString(1, searchInputString);
			break;
		case "4":
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		
		if (searchAlbumSQLstmt != null) {
			ResultSet rs = searchAlbumSQLstmt.executeQuery();
			return rs;
		} else {
			System.out.println("No search performed");
			return null;
		}
	}
}