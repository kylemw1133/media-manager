package def;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import commands.AddCommand;
import commands.EditCommand;
import commands.OrderCommand;
import commands.ReportCommand;
import commands.SearchCommand;

public class Main {

	private static String DATABASE = "checkpoint4-filled.sqlite";

	public static Connection initializeDB(String databaseFileName) {
		/**
		 * The "Connection String" or "Connection URL".
		 *
		 * "jdbc:sqlite:" is the "subprotocol". (If this were a SQL Server database it
		 * would be "jdbc:sqlserver:".)
		 */
		String url = "jdbc:sqlite:" + databaseFileName;
		Connection conn = null; // If you create this variable inside the Try block it will be out of scope
		try {
			conn = DriverManager.getConnection(url);
			if (conn != null) {
				// Provides some positive assurance the connection and/or creation was
				// successful.
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("The connection to the database was successful.");
			} else {
				// Provides some feedback in case the connection failed but did not throw an
				// exception.
				System.out.println("Null Connection");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("There was a problem connecting to the database.");
		}
		return conn;
	}

	/**
	 * Queries the database and prints the results.
	 *
	 * @param conn a connection object
	 * @param sql  a SQL statement that returns rows This query is written with the
	 *             Statement class, tipically used for static SQL SELECT statements
	 */
	public static void sqlQuery(Connection conn, String sql) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String value = rsmd.getColumnName(i);
				System.out.print(value);
				if (i < columnCount)
					System.out.print(",  ");
			}
			System.out.print("\n");
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String columnValue = rs.getString(i);
					System.out.print(columnValue);
					if (i < columnCount)
						System.out.print(",  ");
				}
				System.out.print("\n");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Queries the database and prints the results.
	 *
	 * @param conn a connection object
	 * @param sql  a SQL statement that returns rows This query is written with the
	 *             Statement class, tipically used for static SQL SELECT statements
	 */
	public static void sqlInsert(Connection conn, String sql) {
		try {
			String s = "INSERT INTO ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			// stmt.setInt(1, year);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String value = rsmd.getColumnName(i);
				System.out.print(value);
				if (i < columnCount)
					System.out.print(",  ");
			}
			System.out.print("\n");
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String columnValue = rs.getString(i);
					System.out.print(columnValue);
					if (i < columnCount)
						System.out.print(",  ");
				}
				System.out.print("\n");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println("This is a new run");
		Connection conn = initializeDB(DATABASE);
		boolean promptUser = true;

		Scanner s = new Scanner(System.in);

		while (promptUser) {
			System.out.print("Enter db command (add, edit, search, order, report, print, exit): ");
			String command = s.nextLine();
			switch (command) {
			case "add":
				AddCommand.exec(conn, s);
				break;
			case "edit":
				EditCommand.exec(conn, s);
				break;
			case "search":
				SearchCommand.exec(conn, s);
				break;
			case "order":
				OrderCommand.exec(conn, s);
				break;
			case "report":
				ReportCommand.exec(conn, s);
				break;
			case "exit":
				promptUser = false;
				break;
			default:
				System.out.println("Invalid subcommand: " + command);

			}
		}
		s.close();

		/*
		 * finally best approach finally{
		 *
		 * /* From JSE7 onwards the try-with-resources statement is introduced. The
		 * resources in the try block will be closed automatically after the use, at the
		 * end of the try block close JDBC objects If not, use the following block: try
		 * { if(rs!=null) rs.close(); } catch (SQLException se) { se.printStackTrace();
		 * } try { if(stmt !=null) st.close(); } catch (SQLException se) {
		 * se.printStackTrace(); } try { if(conn !=null) con.close(); } catch
		 * (SQLException se) { se.printStackTrace(); } }
		 */
	}

}