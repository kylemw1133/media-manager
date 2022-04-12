package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Utils {

	public static int getNextOrdinal(Connection conn, String sql, String name) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		int maxID = rs.getInt(name);
		stmt.close();
		return maxID + 1;
	}

	/**
	 * Gets all attributes of an inventory item type. If the type is not found, only
	 * the basic inventory item attributes are returned.
	 *
	 * @param conn a connection object
	 * @param name the table name
	 */
	public static LinkedList<TypedAttribute> getInventoryItemAttributes(Connection conn, String name) {
		LinkedList<TypedAttribute> colNameSet = getColumns(conn, "INVENTORY_ITEM");
		colNameSet.addAll(getColumns(conn, name));
		return colNameSet;
	}

	public static void fillRowData(ResultSet rs, LinkedList<TypedAttribute> rowData) throws SQLException {
		for (TypedAttribute ta : rowData) {
			ta.value = rs.getObject(ta.name);
		}
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
