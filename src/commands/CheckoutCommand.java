package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Album;
import entities.Audiobook;
import entities.Checkout;
import entities.Entity;
import entities.InventoryItem;
import entities.Movie;
import entities.Order;
import entities.TVShow;

public class CheckoutCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of action (create, return): ");
		String type = s.nextLine();

		try {
			switch (type) {
			case "create":
				Checkout c = new Checkout();
				c.insert(conn, s);
				break;
			case "return":
				c = Checkout.searchForOne(conn, s);
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
