package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Audiobook implements Entity {

	private final static String insertAudiobookSQL = "INSERT INTO AUDIOBOOK VALUES (?, ?, ?, ?, ?, ?);";
	private final static String editAudiobookSQL = " UPDATE AUDIOBOOK SET Author_ID=?, Length=?, Year=?, Name=?, Reader=? WHERE Inventory_ID=?";

	public int id;
	public LinkedList<TypedAttribute> data;

	public Audiobook() {
		this.data = null;
	}

	public Audiobook(LinkedList<TypedAttribute> data) {
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
		Utils.executeInsertion(conn, s, id, insertAudiobookSQL, "AUDIOBOOK", "Inventory_ID");

		Chapter.insertMultiple(conn, s, id);

		return id;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editAudiobookSQL, "Inventory_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;
		Audiobook a = new Audiobook();

		if (insert) {
			key = (int) a.insert(conn, s);
		} else {
			a = Audiobook.searchForOne(conn, s);
			key = a.id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Audiobook searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "AUDIOBOOK");
			Utils.fillRowData(rs, rowData);
			return new Audiobook(rowData);
		} else {
			return null;
		}
	}

        public static ResultSet list(Connection conn) throws SQLException {
        return Utils.executeList(conn, "AUDIOBOOK");
    }

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "AUDIOBOOK");
	}
}
