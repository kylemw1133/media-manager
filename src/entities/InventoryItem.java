package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class InventoryItem {

	private final static String insertInventoryItemSQL = "INSERT INTO INVENTORY_ITEM VALUES (?, ?, ?, ?);";
	private final static String editInventoryItemSQL = " UPDATE INVENTORY_ITEM SET Quantity=?, Format=?, Location=? WHERE Inventory_ID=?";
	
	public static int insert(Connection conn, Scanner s) throws SQLException {
		int id = 0;
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "INVENTORY_ITEM");
		PreparedStatement insertInventoryItemStmt = conn.prepareStatement(insertInventoryItemSQL);

		for (TypedAttribute a : colSet) {
			a.promptForValue(s);
			a.fillInStmt(insertInventoryItemStmt, i);
			
			if (a.name.equals("Inventory_ID")) {
				id = (int) a.value;
			}

			i++;
		}
		
		insertInventoryItemStmt.executeUpdate();

		return id;
	}
	
	public static void edit(Connection conn, Scanner s) throws SQLException {
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "MOVIE");
		PreparedStatement editInventoryItemStmt = conn.prepareStatement(editInventoryItemSQL);
		int i = 1;
		int id = 0;

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Inventory_ID")) {
				System.out.print("Provide the ID of the item you want to edit: ");
				id = Integer.parseInt(s.nextLine());
			} else {
				a.promptForValue(s);
				a.fillInStmt(editInventoryItemStmt, i++);
			}
		}
		
		editInventoryItemStmt.setInt(i, id);
		
		editInventoryItemStmt.executeUpdate();
	}
}
