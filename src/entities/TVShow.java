package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class TVShow implements Entity {

	private final static String insertTVShowSQL = "INSERT INTO TV_SHOW VALUES (?, ?, ?, ?);";
	private final static String editTVShowSQL = " UPDATE TV_SHOW SET Name=?, Year=?, Rating=? WHERE Inventory_ID=?;";

	public int id;
	public LinkedList<TypedAttribute> data;

	public TVShow() {
		this.data = null;
	}

	public TVShow(LinkedList<TypedAttribute> data) {
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
		return Utils.executeInsertion(conn, s, id, insertTVShowSQL, "TV_SHOW", "Inventory_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editTVShowSQL, "Inventory_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;
		TVShow a = new TVShow();

		if (insert) {
			key = (int) a.insert(conn, s);
		} else {
			a = TVShow.searchForOne(conn, s);
			key = a.id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static TVShow searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "TV_SHOW");
			Utils.fillRowData(rs, rowData);
			return new TVShow(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "TV_SHOW");
	}
}
