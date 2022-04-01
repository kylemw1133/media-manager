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
	private final static String editAlbumSQL = " UPDATE MOVIE SET Name=?, Length=?, Year=? WHERE Inventory_ID=?;";

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
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "MOVIE");
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
}
