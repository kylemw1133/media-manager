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

public class TVShow {

	private final static String insertTVShowSQL = "INSERT INTO TV_SHOW VALUES (?, ?, ?, ?);";
	private final static String retrieveTVShowSQL = "SELECT * FROM TV_SHOW;";
	private final static String editTVShowSQL = " UPDATE TV_SHOW SET Name=?, Year=?, Rating=? WHERE Inventory_ID=?;";
	
	public static int insert(Connection conn, Scanner s) throws SQLException {
		int id = InventoryItem.insert(conn, s);
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
	
	public static void edit(Connection conn, Scanner s) throws SQLException {
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
	
	public static void retrieve(Connection conn, Scanner s) {
		try {
			System.out.print("Enter the column to search (Name, Year, Rating): ");
			String columnname = s.nextLine();
			System.out.print("Enter the search term: ");
			String keyword = s.nextLine();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(retrieveTVShowSQL);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			int column = -1;
			for (int i = 1; column < 0 || i <= columnCount; i++) {
				if(rsmd.getColumnName(i).equals(columnname)) {
					column = i;
				}
			}
			
			int foundcount = 0;
			while(rs.next()) {
				if(rs.getString(column).toLowerCase().contains(keyword.toLowerCase())) {
					for (int i = 1; i <= columnCount; i++) {
						String columnValue = rs.getString(i);
						System.out.print(columnValue);
						if (i < columnCount)
							System.out.print(",  ");
					}
					System.out.print("\n");
					foundcount++;
				}
			}
			if(foundcount == 0)
				System.out.println("No results found for \'" + keyword + "\' under \'" + columnname + "\'");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
