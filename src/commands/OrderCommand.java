package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.*;

public class OrderCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of action (place, activate): ");
		String type = s.nextLine();

		try {
			switch (type) {
			case "place":
				Order.insert(conn, s);
				break;
			case "activate":
				Order.activate(conn, s);
				break;
			default:
				System.out.println("Invalid action type");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
