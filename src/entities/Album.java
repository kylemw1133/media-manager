package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Album {

	private final static String insertAlbumSQL = "INSERT INTO ALBUM VALUES (?, ?, ?, ?);";

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
}
