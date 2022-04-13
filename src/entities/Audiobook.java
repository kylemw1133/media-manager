package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.TypedAttribute;
import util.Utils;

public class Audiobook implements Entity {

	private final static String insertAudiobookSQL = "INSERT INTO AUDIOBOOK VALUES (?, ?, ?, ?, ?, ?);";
	private final static String editAudiobookSQL = " UPDATE ALBUM SET Audio_ID=?, Length=?, Year=?, Name=?, Reader=? WHERE Inventory_ID=?";
	private final static String selectAudiobookSQL = "SELECT * FROM AUDIOBOOK WHERE Inventory_ID=?;";
	// private final static String editAudiobookSQL = "UPDATE AUDIOBOOK SET ? WHERE
	// Inventory_ID = ?;";

	private LinkedList<TypedAttribute> data;
	
	public Audiobook() {
		this.data = null;
	}
	
	public Audiobook(LinkedList<TypedAttribute> data) {
		this.data = data;
	}
	
	public int insert(Connection conn, Scanner s) throws SQLException {
		InventoryItem parentItem = new InventoryItem();
		int id = parentItem.insert(conn, s);
		return Utils.executeInsertion(conn, s, id, insertAudiobookSQL, "AUDIOBOOK", "Inventory_ID");
	}

	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editAudiobookSQL, "Inventory_ID");
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}
	
	public static Audiobook searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = Album.search(conn, s);
		if (rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "AUDIOBOOK");
			Utils.fillRowData(rs, rowData);
			return new Audiobook(rowData);
		} else {
			return null;
		}
	}
	
	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		System.out.println("Which field do you want to search by?");
		System.out.println("1: Author_ID | 2: Length | 3: Year | 4: Name | 5: Reader | 6: EXIT: ");
		String input = s.nextLine();
		String searchInputString = "";
		int searchInputInt;
		PreparedStatement searchAudiobookSQLstmt = null;
		switch (input) {
		case "1":

			System.out.println("Enter search author id");
			searchInputInt = Integer.parseInt(s.nextLine());
			searchAudiobookSQLstmt = conn.prepareStatement("SELECT * FROM AUDIOBOOK WHERE Author_ID = ?;");
			searchAudiobookSQLstmt.setInt(1, searchInputInt);
			break;
		case "2":
			System.out.println("Enter search Length");
			searchInputInt = Integer.parseInt(s.nextLine());
			searchAudiobookSQLstmt = conn.prepareStatement("SELECT * FROM AUDIOBOOK WHERE length = ?;");
			searchAudiobookSQLstmt.setInt(1, searchInputInt);
			break;
		case "3":
			System.out.println("Enter search Year");
			searchInputInt = Integer.parseInt(s.nextLine());
			searchAudiobookSQLstmt = conn.prepareStatement("SELECT * FROM AUDIOBOOK WHERE year = ?;");
			searchAudiobookSQLstmt.setInt(1, searchInputInt);
			break;
		case "4":
			System.out.println("Enter search name");
			searchInputString = s.nextLine();
			searchAudiobookSQLstmt = conn.prepareStatement("SELECT * FROM AUDIOBOOK WHERE name = ?;");
			searchAudiobookSQLstmt.setString(1, searchInputString);
			break;
		case "5":
			System.out.println("Enter search Reader");
			searchInputString = s.nextLine();
			searchAudiobookSQLstmt = conn.prepareStatement("SELECT * FROM AUDIOBOOK WHERE reader = ?;");
			searchAudiobookSQLstmt.setString(1, searchInputString);
			break;
		case "6":
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
		
		if (searchAudiobookSQLstmt != null) {
			ResultSet rs = searchAudiobookSQLstmt.executeQuery();
			return rs;
		} else {
			System.out.println("No search performed");
			return null;
		}
	}
}
