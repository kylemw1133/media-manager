package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Utils {

	private final static String insertAlbumSQL = "INSERT INTO ALBUM (?, ?, ?, ?) VALUES (?, ?, ?, ?);";
	private final static String insertMovieSQL = "INSERT INTO MOVIE (?, ?, ?, ?) VALUES (?, ?, ?, ?);";
	private final static String insertAudiobookSQL = "INSERT INTO AUDIOBOOK (?, ?, ?, ?) VALUES (?, ?, ?, ?);";
	private final static String insertTVShowSQL = "INSERT INTO TVSHOW (?, ?, ?, ?) VALUES (?, ?, ?, ?);";

//	public static void insertInventoryItem(Connection conn, String name, Scanner s) {
//		HashSet<TypedAttribute> colNameSet = getColumns(conn, name);
//
//		switch (name) {
//		case "ALBUM":
//			stmt = conn.prepareStatement(insertAlbumSQL);
//			fillStmtForType(conn, stmt, name, s);
//			break;
//		case "MOVIE":
//			stmt = conn.prepareStatement(insertMovieSQL);
//			fillStmtForType(conn, stmt, name, s);
//			break;
//		case "AUDIOBOOK":
//			stmt = conn.prepareStatement(insertAudiobookSQL);
//			fillStmtForType(conn, stmt, name, s);
//			break;
//		case "TV_SHOW":
//			stmt = conn.prepareStatement(insertTVShowSQL);
//			fillStmtForType(conn, stmt, name, s);
//			break;
//		}
//	}

//	public static void fillStmtForType(Connection conn, PreparedStatement stmt, String type, Scanner s) {
//		HashSet<TypedAttribute> colNameSet = getColumns(conn, type);
//		int numberOfColumns = colNameSet.size();
//		int i = 0;
//
//		try {
//			for (TypedAttribute a : colNameSet) {
//				stmt.setString(i, a.name);
//				a.promptForStmt(stmt, i + numberOfColumns, s);
//				i++;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

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
}
