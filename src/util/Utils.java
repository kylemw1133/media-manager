package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Utils {

	/**
	 * Gets all attributes of an inventory item type. If the type is not found, 
	 * only the basic inventory item attributes are returned.
	 *
	 * @param conn a connection object
	 * @param name the table name
	 */
	public static LinkedList<String> getInventoryItemAttributes(Connection conn, String name) {
		LinkedList<String> colNameList = getColumns(conn, "INVENTORY_ITEM");
		colNameList.addAll(getColumns(conn, name));
		return colNameList;
	}
	
	/**
	 * Gets the columns of a table in the database.
	 *
	 * @param conn a connection object
	 * @param name the table name
	 */
	public static LinkedList<String> getColumns(Connection conn, String name) {
		LinkedList<String> colNameList = new LinkedList<>();

		try {
			ResultSet rs = conn.getMetaData().getColumns(null, null, name, null);
			int columnNameColIndex = rs.findColumn("COLUMN_NAME");

			while (rs.next()) {
				String colName = rs.getString(columnNameColIndex);
				colNameList.add(colName);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return colNameList;
	}
}
