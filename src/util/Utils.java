package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;

public class Utils {
	
	/**
	 * Gets all attributes of an inventory item type. If the type is not found, 
	 * only the basic inventory item attributes are returned.
	 *
	 * @param conn a connection object
	 * @param name the table name
	 */
	public static HashSet<TypedAttribute> getInventoryItemAttributes(Connection conn, String name) {
		HashSet<TypedAttribute> colNameSet = getColumns(conn, "INVENTORY_ITEM");
		colNameSet.addAll(getColumns(conn, name));
		return colNameSet;
	}
	
	/**
	 * Gets the columns of a table in the database.
	 *
	 * @param conn a connection object
	 * @param name the table name
	 */
	public static HashSet<TypedAttribute> getColumns(Connection conn, String name) {
		HashSet<TypedAttribute> colNameSet = new HashSet<TypedAttribute>();

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
}
