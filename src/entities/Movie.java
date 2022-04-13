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

	private LinkedList<TypedAttribute> data;

	public Movie() {
		this.data = null;
	}

	public Movie(LinkedList<TypedAttribute> data) {
		this.data = data;
	}

	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		InventoryItem parentItem = new InventoryItem();
		int id = parentItem.insert(conn, s);
		Utils.executeInsertion(conn, s, id, insertMovieSQL, "MOVIE", "Inventory_ID");

		// adding Actor STARS in Movie relation (cheap solution)
		boolean addActor = true;
		while (addActor) {
			System.out.println("1: Add actor | 2: exit");
			if (Integer.parseInt(s.nextLine()) == 1) {
				Entity e = new Actor();
				int actor_id = e.insert(conn, s);
				System.out.println("What is the role of the actor? ");
				String role = s.nextLine();
				PreparedStatement insertActorMovieRelationStmt = conn.prepareStatement(insertStarsInSQL);
				insertActorMovieRelationStmt.setInt(1, id);
				insertActorMovieRelationStmt.setInt(2, actor_id);
				insertActorMovieRelationStmt.setString(2, role);
				insertActorMovieRelationStmt.executeUpdate();
			} else {
				addActor = false;
			}
		}
		// adding Director DIRECTS Movie relation (cheap solution)
		boolean addDirector = true;
		while (addDirector) {
			System.out.println("1: Add Director | 2: exit");
			if (Integer.parseInt(s.nextLine()) == 1) {
				Entity e = new Director();
				int director_id = e.insert(conn, s);
				PreparedStatement insertActorMovieRelationStmt = conn.prepareStatement(insertDirectsSQL);
				insertActorMovieRelationStmt.setInt(1, id);
				insertActorMovieRelationStmt.setInt(2, director_id);

				insertActorMovieRelationStmt.executeUpdate();
			} else {
				addDirector = false;
			}
		}

		return id;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editMovieSQL, "Inventory_ID");
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
