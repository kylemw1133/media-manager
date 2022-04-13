package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Actor implements Entity {

	private final static String insertActorSQL = "INSERT INTO Actor VALUES (?, ?);";
	private static final String maxActorSQL = "SELECT MAX(Actor_ID) AS Max_ID FROM Actor;";

	public static int getNextActorID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxActorSQL, "Max_ID");
	}

	@Override
	public int insert(Connection conn, Scanner s) throws SQLException {
		int id = 0;
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "Actor");
		PreparedStatement insertActorStmt = conn.prepareStatement(insertActorSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("Actor_ID")) {
				id = getNextActorID(conn);
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertActorStmt, i);
			i++;
		}

		insertActorStmt.execute();

		return id;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		// TODO Auto-generated method stub

	}
}
