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
	
	public int insert(Connection conn, Scanner s) throws SQLException {
		InventoryItem parentItem = new InventoryItem();
		int id = parentItem.insert(conn, s);
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "ALBUM");
		PreparedStatement insertAlbumStmt = conn.prepareStatement(insertAlbumSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertAlbumStmt, i);
			i++;
		}

		insertAlbumStmt.execute();
		insertAlbumStmt.close();

		return id;
	}

	public void edit(Connection conn, Scanner s) throws SQLException {
		PreparedStatement editAlbumStmt = conn.prepareStatement(editAlbumSQL);
		int i = 1;

		for (TypedAttribute a : this.data) {
			if (!a.name.equals("Inventory_ID")) {
				a.promptForValue(s);
			}
			
			a.fillInStmt(editAlbumStmt, i++);
		}
		
		editAlbumStmt.execute();
	}
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer("|");
		
		for (TypedAttribute ta : this.data) {
			s.append(" ");
			s.append(ta.value.toString());
			s.append(" |");
		}
		
		return s.toString();
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