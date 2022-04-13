package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Patron implements Entity {

	private final static String insertPatronSQL = "INSERT INTO PATRON VALUES (?, ?);";
	private final static String editPatronSQL = " UPDATE PATRON SET P_Email=?, Card_ID=? WHERE P_Email=?";
	private final static String listCheckoutsSQL = " SELECT CHECKOUT.Checkout_ID, CHECKOUT.Checkout_Status, CHECKOUT.Inventory_ID "
			+ "FROM PATRON, CARD, CHECKOUT, INVENTORY_ITEM "
			+ "WHERE PATRON.P_Email=? "
			+ "AND CARD.Card_ID = Patron.Card_ID "
			+ "AND CHECKOUT.Card_ID = CARD.Card_ID "
			+ "AND INVENTORY_ITEM.Inventory_ID = CHECKOUT.Inventory_ID;";
	
	public String pEmail;
	public LinkedList<TypedAttribute> data;

	public Patron() {
		this.data = null;
	}

	public Patron(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("P_Email")) {
				this.pEmail = (String) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		String pEmail = "";
		int cardID = 0;
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "PATRON");
		PreparedStatement insertStmt = conn.prepareStatement(insertPatronSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("P_Email")) {
				pEmail = Person.insertSingle(conn, s);
				a.value = pEmail;
			} else if (a.name.equals("Card_ID")) {
				cardID = Card.insertSingle(conn, s);
				a.value = cardID;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertStmt, i++);
		}

		insertStmt.execute();
		insertStmt.close();

		return pEmail;
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editPatronSQL, "P_Email");
	}
	
	public ResultSet listCheckouts(Connection conn) throws SQLException {
		PreparedStatement listCheckoutsStmt = conn.prepareStatement(listCheckoutsSQL);
		listCheckoutsStmt.setString(1, this.pEmail);
		ResultSet rs = listCheckoutsStmt.executeQuery();
		return rs;
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		String key = "";

		if (insert) {
			key = (String) this.insert(conn, s);
		} else {
			key = Patron.searchForOne(conn, s).pEmail;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Patron searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "PATRON");
			Utils.fillRowData(rs, rowData);
			return new Patron(rowData);
		} else {
			return null;
		}
	}

    public static ResultSet list(Connection conn) throws SQLException {
        return Utils.executeList(conn, "PATRON");
    }

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "PATRON");
	}
}
