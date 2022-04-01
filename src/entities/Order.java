package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Order {

	private final static String insertOrderSQL = "INSERT INTO [ORDER] VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	public static void insert(Connection conn, Scanner s) throws SQLException {
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "ORDER");
		PreparedStatement insertOrderStmt = conn.prepareStatement(insertOrderSQL);

		for (TypedAttribute a : colSet) {
			a.promptForValue(s);
			a.fillInStmt(insertOrderStmt, i++);
		}

		insertOrderStmt.executeUpdate();
	}
	
	public static void activate(Connection conn, Scanner s) throws SQLException {
		// Get an order
		// Get the associated inventory item
		// increase the items quantity by the order's quantity
		// change the order status
	}
}
