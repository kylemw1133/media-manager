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

		return id;
	}
}
