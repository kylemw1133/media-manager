package def;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import commands.*;
import data.*;

public class Main {
	
	private static String DATABASE = "database_binary.db";
	
	public static Connection initializeDB(String databaseFileName) {
    	/**
    	 * The "Connection String" or "Connection URL".
    	 * 
    	 * "jdbc:sqlite:" is the "subprotocol".
    	 * (If this were a SQL Server database it would be "jdbc:sqlserver:".)
    	 */
        String url = "jdbc:sqlite:" + databaseFileName;
        Connection conn = null; // If you create this variable inside the Try block it will be out of scope
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
            	// Provides some positive assurance the connection and/or creation was successful.
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("The connection to the database was successful.");
            } else {
            	// Provides some feedback in case the connection failed but did not throw an exception.
            	System.out.println("Null Connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("There was a problem connecting to the database.");
        }
        return conn;
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
				AddCommand.exec(s, conn);
				break;
			case "edit":
				EditCommand.exec(s);
				break;
			case "search":
				SearchCommand.exec(s, conn);
				break;
			case "order":
				OrderCommand.exec(s);
				break;
			case "report":
				ReportCommand.exec();
				break;
			case "print":
				//FakeDatabase.getInstance().printItems();
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