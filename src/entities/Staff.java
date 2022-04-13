package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Staff implements Entity {

	private final static String insertStaffSQL = "INSERT INTO STAFF VALUES (?, ?, ?);";
	private final static String editStaffSQL = " UPDATE STAFF SET P_Email=?, Staff_Salted_Password=?, Staff_Username=? WHERE P_Email=?";

	public String pEmail;
	public LinkedList<TypedAttribute> data;

	public Staff() {
		this.data = null;
	}

	public Staff(LinkedList<TypedAttribute> data) {
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
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "STAFF");
		PreparedStatement insertStmt = conn.prepareStatement(insertStaffSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals("P_Email")) {
				pEmail = Person.insertSingle(conn, s);
				a.value = pEmail;
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
		PreparedStatement editStmt = conn.prepareStatement(editStaffSQL);
		int i = 1;
		String pEmail = "";

		for (TypedAttribute a : this.data) {
			if (a.name.contains("P_Email")) {
				pEmail = (String) a.value;
			}

			a.promptForValue(s);
			a.fillInStmt(editStmt, i++);
		}

		editStmt.setString(i, pEmail);
		editStmt.execute();
		editStmt.close();
	}

	@Override
	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException {
		String key = "";

		if (insert) {
			key = (String) this.insert(conn, s);
		} else {
			key = Staff.searchForOne(conn, s).pEmail;
		}

		return key;
	}

	@Override
	public String toString() {
		return Utils.rowDataToString(this.data);
	}

	public static Staff searchForOne(Connection conn, Scanner s) throws SQLException {
		ResultSet rs = search(conn, s);
		if (rs != null && rs.next()) {
			LinkedList<TypedAttribute> rowData = Utils.getColumns(conn, "STAFF");
			Utils.fillRowData(rs, rowData);
			return new Staff(rowData);
		} else {
			return null;
		}
	}

	public static ResultSet search(Connection conn, Scanner s) throws SQLException {
		return Utils.executeSearch(conn, s, "STAFF");
	}

	public static ResultSet list(Connection conn) throws SQLException {
		return Utils.executeList(conn, "STAFF");
	}
}
