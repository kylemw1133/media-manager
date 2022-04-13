package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Seller implements Entity {

	private final static String insertSellerSQL = "INSERT INTO SELLER VALUES (?, ?);";
	private final static String editSellerSQL = " UPDATE SELLER SET Name=? WHERE Seller_ID=?";
	private static final String maxSellerSQL = "SELECT MAX(Seller_ID) AS Max_ID FROM SELLER;";

	public int id;
	public LinkedList<TypedAttribute> data;

	public Seller() {
		this.data = null;
	}

	public Seller(LinkedList<TypedAttribute> data) {
		this.data = data;

		for (TypedAttribute ta : this.data) {
			if (ta.name.equals("Seller_ID")) {
				this.id = (int) ta.value;
			}
		}
	}

	@Override
	public Object insert(Connection conn, Scanner s) throws SQLException {
		int id = getNextSellerID(conn);
		return Utils.executeInsertion(conn, s, id, insertSellerSQL, "SELLER", "Seller_ID");
	}

	@Override
	public void edit(Connection conn, Scanner s) throws SQLException {
		Utils.executeEdit(conn, s, this.data, editSellerSQL, "Seller_ID");
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		int key = 0;

		if (insert) {
			key = (int) this.insert(conn, s);
		} else {
			key = Seller.searchForOne(conn, s).id;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Seller searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "SELLER");
			Utils.fillRowData(rs, rowData);
			return new Seller(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "SELLER");
	}

	public static ResultSet list(Connection conn) throws SQLException {
		return Utils.executeList(conn, "SELLER");
	}

	public static int getNextSellerID(Connection conn) throws SQLException {
		return Utils.getNextOrdinal(conn, maxSellerSQL, "Max_ID");
	}
}
