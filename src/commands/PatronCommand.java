package commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Checkout;
import entities.Patron;
import util.Utils;

public class PatronCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of action (list-checkouts): ");
		String type = s.nextLine();

		try {
			switch (type) {
			case "list-checkouts":
				Patron p = Patron.searchForOne(conn, s);
				System.out.println("Printing checkouts for the folloing patron:");
				System.out.println(p.toString());
				ResultSet rs = p.listCheckouts(conn);
				Utils.printRecords(rs);
				break;
			default:
				System.out.println("Invalid action type");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
