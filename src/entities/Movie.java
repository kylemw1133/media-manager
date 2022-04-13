package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Movie implements Entity {

	private final static String insertMovieSQL = "INSERT INTO MOVIE VALUES (?, ?, ?, ?, ?);";
	private final static String editMovieSQL = " UPDATE MOVIE SET Name=?, Length=?, Year=?, Content_Rating=? WHERE Inventory_ID=?;";
	private final static String insertStarsInSQL = "INSERT INTO STARS VALUES(?, ?, ?);";
	private final static String insertDirectsSQL = "INSERT INTO DIRECTS VALUES(?, ?);";
	
	public int id;
	public LinkedList<TypedAttribute> data;

	public Movie() {
		this.data = null;
	}

	public Movie(LinkedList<TypedAttribute> data) {
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
		Utils.executeInsertion(conn, s, id, insertMovieSQL, "MOVIE", "Inventory_ID");
		
		Actor.insertMultiple(conn, s, id);
		Director.insertMultiple(conn, s, id);
		
		return id;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editMovieSQL, "Inventory_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;
		Movie a = new Movie();

		if (insert) {
			key = (int) a.insert(conn, s);
		} else {
			a = Movie.searchForOne(conn, s);
			key = a.id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Movie searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "MOVIE");
			Utils.fillRowData(rs, rowData);
			return new Movie(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "MOVIE");
	}
}
