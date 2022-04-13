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
	private final static String editStaffSQL = " UPDATE STAFF SET Staff_Salted_Password=?, Staff_Username=? WHERE P_Email=?";
	
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
		Utils.executeEdit(conn, s, this.data, editStaffSQL, "P_Email");
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
}
