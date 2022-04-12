package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.*;

public class OrderCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of action (place, activate): ");
		String type = s.nextLine();
		Order e;

		try {
			switch (type) {
			case "place":
				e = new Order();
				e.insert(conn, s);
				break;
			case "activate":
				e = Order.searchForOne(conn, s);
				e.activate(conn, s);
				break;
			default:
				System.out.println("Invalid action type");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
