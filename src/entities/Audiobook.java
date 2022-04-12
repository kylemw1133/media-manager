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

	private final static String insertAudiobookSQL = "INSERT INTO AUDIOBOOK VALUES (? ? ? ? ? ?);";
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
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "AUDIOBOOK");
		PreparedStatement insertAudiobookStmt = conn.prepareStatement(insertAudiobookSQL);

		for (TypedAttribute a : colSet) {
			if (a.name == "Inventory_ID") {
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertAudiobookStmt, i);
			i++;
		}

		return id;
	}

	public void edit(Connection conn, Scanner s) throws SQLException {
		PreparedStatement selectAudiobookStmt = conn.prepareStatement(selectAudiobookSQL);
		// PreparedStatement editAudiobookStmt =
		// conn.prepareStatement(editAudiobookSQL);

		System.out.println("Enter the inventory ID of the audiobook ");

		String id = "";
		// repeat promp for inventory id until user inputs a valid integer
		while (id.equals("") || !id.matches("\\-?\\d+")) {
			id = s.nextLine();
		}

		selectAudiobookStmt.setString(1, id);
		// editAudiobookStmt.setString(2, id);

		ResultSet selectedRecord = selectAudiobookStmt.executeQuery();

		if (selectedRecord.next()) {
			Utils.printRecords(selectedRecord);
			System.out.println("Which field do you want to edit?");
			System.out.println("1: Author_ID | 2: Length | 3: Year | 4: Name | 5: Reader | 6: EXIT");
			String input = s.nextLine();
			String newInput = "";

			switch (input) {
			case "1":
				System.out.println("Enter new Author_ID");
				newInput = "Author_ID=" + s.nextLine();
				break;
			case "2":
				System.out.println("Enter new Length");
				newInput = "Length=" + s.nextLine();
				break;
			case "3":
				System.out.println("Enter new Year");
				newInput = "Year=" + s.nextLine();
				break;
			case "4":
				System.out.println("Enter new Name");
				newInput = "Name=" + s.nextLine();
				break;
			case "5":
				System.out.println("Enter new Reader");
				newInput = "Reader=" + s.nextLine();
				break;
			case "6":
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid input");
				break;
			}

			if (newInput != "") {
				// editAudiobookStmt.setString(1, newInput);
				// editAudiobookStmt.executeUpdate();
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("UPDATE AUDIOBOOK SET " + newInput + " WHERE Inventory_ID=" + id);
				stmt.close();
				System.out.println("Record Updated");
			}

		} else {
			System.out.println("Record not found...");
		}
		// editAudiobookStmt.close();
		selectAudiobookStmt.close();
	}

	public static Audiobook searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = Album.search(conn, s);
		if (rs.first()) {
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
