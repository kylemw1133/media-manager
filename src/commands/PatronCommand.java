package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Checkout;

public class PatronCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of action (register): ");
		String type = s.nextLine();

		try {
			switch (type) {
			case "register":
//				Patron p = Patron
//				p.insert(conn, s);
				break;
			case "return":
				Checkout c = Checkout.searchForOne(conn, s);
				c.returnCheckout(conn, s);
				break;
			default:
				System.out.println("Invalid action type");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
