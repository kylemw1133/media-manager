package commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Order;
import util.Utils;

public class OrderCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of action (place, list, search, activate): ");
		String type = s.nextLine();
		ResultSet rs;
		Order e;

		try {
			switch (type) {
			case "place":
				e = new Order();
				e.insert(conn, s);
				break;
			case "list":
				rs = Order.list(conn);
				Utils.printRecords(rs);
				break;
			case "search":
				rs = Order.search(conn, s);
				Utils.printRecords(rs);
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
