package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

public class Utils {

	public static int getNextOrdinal(Connection conn, String sql, String name) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		int maxID = rs.getInt(name);
		stmt.close();
		return maxID + 1;
	}

	public static int executeInsertion(Connection conn,
			Scanner s,
			int id,
			String insertSQL,
			String tableName,
			String idCol) throws SQLException {
		int i = 1;
		LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, tableName);
		PreparedStatement insertAlbumStmt = conn.prepareStatement(insertSQL);

		for (TypedAttribute a : colSet) {
			if (a.name.equals(idCol)) {
				a.value = id;
			} else {
				a.promptForValue(s);
			}

			a.fillInStmt(insertAlbumStmt, i);
			i++;
		}

		insertAlbumStmt.execute();
		insertAlbumStmt.close();

		return id;
	}

	public static void executeEdit(Connection conn,
			Scanner s,
			LinkedList<TypedAttribute> rowData,
			String editSQL,
			String idCol) throws SQLException {
		PreparedStatement editStmt = conn.prepareStatement(editSQL);
		int i = 1;
		int id = 0;

		for (TypedAttribute a : rowData) {
			if (a.name.contains(idCol)) {
				id = (int) a.value;
			} else {
				a.promptForValue(s);
				a.fillInStmt(editStmt, i++);
			}
		}

		editStmt.setInt(i, id);
		editStmt.execute();
		editStmt.close();
	}
	
	public static ResultSet executeSearch(Connection conn,
			Scanner s,
			String tableName) throws SQLException {
		LinkedList<TypedAttribute> colSet = getColumns(conn, tableName);
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < colSet.size(); i++) {
			sb.append("| " + (i+1) + ": " + colSet.get(i).name + " ");
		}
		sb.append("| " + (i+1) + ": EXIT |");

		System.out.println(sb.toString());
		System.out.print("Provide the field number you want to search by: ");
		int input = Integer.parseInt(s.nextLine());
		
		if (input < 1 || input > colSet.size()) {
			return null;
		}
		
		TypedAttribute chosenAttribute = colSet.get(input - 1);
		String selectCheckoutSQL = "SELECT * FROM " + tableName + " WHERE " + chosenAttribute.name + "=?;";
		PreparedStatement selectCheckoutStmt = conn.prepareStatement(selectCheckoutSQL);
		chosenAttribute.promptForValue(s);
		chosenAttribute.fillInStmt(selectCheckoutStmt, 1);
		ResultSet rs = selectCheckoutStmt.executeQuery();
		return rs;
	}

	public static void fillRowData(ResultSet rs, LinkedList<TypedAttribute> rowData) throws SQLException {
		for (TypedAttribute ta : rowData) {
			ta.value = rs.getObject(ta.name);
		}
	}

	public static String rowDataToString(LinkedList<TypedAttribute> rowData) {
		StringBuffer s = new StringBuffer("|");

		for (TypedAttribute ta : rowData) {
			s.append(" ");
			s.append(ta.value);
			s.append(" |");
		}

		return s.toString();
	}

	/**
	 * Gets the columns of a table in the database.
	 *
	 * @param conn a connection object
	 * @param name the table name
	 */
	public static LinkedList<TypedAttribute> getColumns(Connection conn, String name) {
		LinkedList<TypedAttribute> colNameSet = new LinkedList<>();

		try {
			ResultSet rs = conn.getMetaData().getColumns(null, null, name, null);
			int columnNameColIndex = rs.findColumn("COLUMN_NAME");
			int dataTypeColIndex = rs.findColumn("DATA_TYPE");

			while (rs.next()) {
				String colName = rs.getString(columnNameColIndex);
				int dataType = rs.getInt(dataTypeColIndex);

				colNameSet.add(new TypedAttribute(colName, dataType));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return colNameSet;
	}

	/**
	 *
	 * @param rs the result set containing records to print to console
	 */
	public static void printRecords(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCnt = rsmd.getColumnCount();
		for (int i = 1; i <= columnCnt; i++) {
			String value = rsmd.getColumnName(i);
			System.out.print(value);
			if (i < columnCnt)
				System.out.print(", ");
		}
		System.out.print("\n");

		while (rs.next()) {
			for (int i = 1; i <= columnCnt; i++) {
				String columnVal = rs.getString(i);
				System.out.print(columnVal);
				if (i < columnCnt)
					System.out.print(", ");
			}
			System.out.print("\n");
		}
	}
}
