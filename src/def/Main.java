package def;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import commands.AddCommand;
import commands.CheckoutCommand;
import commands.DeleteCommand;
import commands.EditCommand;
import commands.ListCommand;
import commands.OrderCommand;
import commands.PatronCommand;
import commands.ReportCommand;
import commands.SearchCommand;

public class Main {

	private static String DATABASE = "populated_project_database.db";

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
				Statement s = conn.createStatement();
				s.execute("PRAGMA foreign_keys=ON");
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

	public static void main(String[] args) {
		Connection conn = initializeDB(DATABASE);
		boolean promptUser = true;

		Scanner s = new Scanner(System.in);

		while (promptUser) {
			System.out.println("Commands: add, edit, delete, search, list, " + "patron, order, checkout, report, exit");
			System.out.print("PROMPT> ");
			String command = s.nextLine();

			switch (command) {
			case "add":
				AddCommand.exec(conn, s);
				break;
			case "edit":
				EditCommand.exec(conn, s);
				break;
			case "delete":
				DeleteCommand.exec(conn, s);
				break;
			case "search":
				SearchCommand.exec(conn, s);
				break;
			case "list":
				ListCommand.exec(conn, s);
				break;
			case "patron":
				PatronCommand.exec(conn, s);
				break;
			case "order":
				OrderCommand.exec(conn, s);
				break;
			case "checkout":
				CheckoutCommand.exec(conn, s);
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
	}
}
