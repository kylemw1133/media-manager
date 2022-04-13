package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Album implements Entity {

	private final static String insertAlbumSQL = "INSERT INTO ALBUM VALUES (?, ?, ?, ?);";
	private final static String editAlbumSQL = "UPDATE ALBUM SET Name=?, Length=?, Year=? WHERE Inventory_ID=?";

	public int id;
	public LinkedList<TypedAttribute> data;

	public Album() {
		this.data = null;
	}

	public Album(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Inventory_ID")) {
				this.id = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		InventoryItem parentItem = new InventoryItem();
		int id = (int) parentItem.insert(conn, s);
		Utils.executeInsertion(conn, s, id, insertAlbumSQL, "ALBUM", "Inventory_ID");

		Artist.insertMultiple(conn, s, id);
		Track.insertMultiple(conn, s, id);

		return id;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editAlbumSQL, "Inventory_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;
		Album a = new Album();

		if (insert) {
			key = (int) a.insert(conn, s);
		} else {
			a = Album.searchForOne(conn, s);
			key = a.id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Album searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ALBUM");
			Utils.fillRowData(rs, rowData);
			return new Album(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "ALBUM");
	}
}