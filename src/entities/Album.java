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

public class Album {

	private final static String insertAlbumSQL = "INSERT INTO ALBUM VALUES (?, ?, ?, ?);";
<<<<<<< HEAD
	private final static String editAlbumSQL = " UPDATE ALBUM SET Name=?, Length=?, Year=? WHERE Inventory_ID=?";
=======
	private final static String editAlbumSQL = " UPDATE MOVIE SET Name=?, Length=?, Year=? WHERE Inventory_ID=?;";
>>>>>>> branch 'master' of https://github.com/kylemw1133/media-manager.git

	public static int insert(Connection conn, Scanner s) throws SQLException {
		int id = InventoryItem.insert(conn, s);
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

		insertAlbumStmt.executeUpdate();

		return id;
	}

	public static void edit(Connection conn, Scanner s) throws SQLException {
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "ALBUM");
		PreparedStatement editAlbumStmt = conn.prepareStatement(editAlbumSQL);
		int i = 1;
		int id = 0;

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				System.out.print("Provide the ID of the item you want to edit: ");
				id = Integer.parseInt(s.nextLine());
			} else {
				a.promptForValue(s);
				a.fillInStmt(editAlbumStmt, i++);
			}
		}

		editAlbumStmt.setInt(i, id);

		editAlbumStmt.executeUpdate();
	}

	public static void search(Connection conn, Scanner s) {
		try {
			Statement stmt = conn.createStatement();
			System.out.println("Which field do you want to search by?");
			System.out.println("1: Name | 2: Length | 3: Year | 4: EXIT: ");
			String input = s.nextLine();
			String searchInputString = "";
			int searchInputInt;
			String searchCol = "";
			String searchAlbumSQL = "";
			switch (input) {
				case "1":
					System.out.println("Enter search Name");
					searchCol = "name";
					searchInputString = s.nextLine();
					searchAlbumSQL = "SELECT * FROM ALBUM WHERE "+searchCol+"="+"\"" + searchInputString + "\"; ";
					break;
				case "2":
					System.out.println("Enter search Length");
					searchCol = "length";
					searchInputInt = s.nextInt();
					searchAlbumSQL = "SELECT * FROM ALBUM WHERE "+searchCol+"="+ searchInputInt+";";
					break;
				case "3":
					System.out.println("Enter search Year");
					searchCol = "year";
					searchInputInt = s.nextInt();
					searchAlbumSQL = "SELECT * FROM ALBUM WHERE "+searchCol+"="+searchInputInt+";";
					break;
				
				case "4":
					System.out.println("Exit");
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
			if(searchCol!="") {
				ResultSet rs = stmt.executeQuery(searchAlbumSQL);
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
			}
			else {
				System.out.println("No search performed");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
<<<<<<< HEAD
	}
=======
		
	}
	
	
>>>>>>> branch 'master' of https://github.com/kylemw1133/media-manager.git
}
