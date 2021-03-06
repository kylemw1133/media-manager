package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Card implements Entity {

	private final static String insertCardSQL = "INSERT INTO CARD VALUES (?, ?);";
	private final static String editCardSQL = " UPDATE CARD SET Card_Creation_Date=? WHERE Card_ID=?";
	private static final String maxCardSQL = "SELECT MAX(Card_ID) AS Max_ID FROM CARD;";

	public int id;
	public LinkedList<TypedAttribute> data;

	public Card() {
		this.data = null;
	}

	public Card(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Card_ID")) {
				this.id = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextCardID(conn);
		return Utils.executeInsertion(conn, s, id, insertCardSQL, "CARD", "Card_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editCardSQL, "Card_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = Card.searchForOne(conn, s).id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static int insertSingle(Connection conn, Scanner s) throws SQLException {
		System.out.println("| 1: Create Card | 2: Search for Card |");
		int input = Integer.parseInt(s.nextLine());

		Card c = new Card();
		int cardID = (int) c.insertOrSearch(conn, s, input == 1);
		return cardID;
	}

	public static Card searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "CARD");
			Utils.fillRowData(rs, rowData);
			return new Card(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "CARD");
	}

	public static ResultSet list(Connection conn) throws SQLException {
		return Utils.executeList(conn, "CARD");
	}

	public static int getNextCardID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxCardSQL, "Max_ID");
	}
}
