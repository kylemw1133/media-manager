package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Actor implements Entity {

	private final static String insertActorSQL = "INSERT INTO Actor VALUES (?, ?);";
	private final static String editActorSQL = " UPDATE ACTOR SET Name=? WHERE Actor_ID=?";
	private static final String maxActorSQL = "SELECT MAX(Actor_ID) AS Max_ID FROM Actor;";

	private final static String insertStarsSQL = "INSERT INTO STARS VALUES (?, ?, ?);";
	
	public int id;
	public LinkedList<TypedAttribute> data;

	public Actor() {
		this.data = null;
	}

	public Actor(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Actor_ID")) {
				this.id = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextActorID(conn);
		return Utils.executeInsertion(conn, s, id, insertActorSQL, "ACTOR", "Actor_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editActorSQL, "Actor_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = Actor.searchForOne(conn, s).id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static void insertMultiple(Connection conn, Scanner s, int inventoryID) throws SQLException {
		int input;
		do {
			System.out.println("| 1: Create Actor | 2: Choose Actor | 3: Finish with Actors |");
			input = Integer.parseInt(s.nextLine());

			if (input == 3) {
				break;
			}

			Actor a = new Actor();
			int aID = (int) a.insertOrSearch(conn, s, input == 1);
			
			System.out.println("Provide the Role: ");
			String role = s.nextLine();
			
			PreparedStatement insertJoinTupleStmt = conn.prepareStatement(insertStarsSQL);
			insertJoinTupleStmt.setInt(1, inventoryID);
			insertJoinTupleStmt.setInt(2, aID);
			insertJoinTupleStmt.setString(3, role);
			insertJoinTupleStmt.execute();
		} while (input != 3);
		
		System.out.println("Finished with Actors.");
	}
	
	public static Actor searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "ACTOR");
			Utils.fillRowData(rs, rowData);
			return new Actor(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "ACTOR");
	}

	public static int getNextActorID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxActorSQL, "Max_ID");
	}
}
