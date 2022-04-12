package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.*;

public class AddCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to add (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();
		Entity e;

		try {
			switch (type) {
			case "album":
				e = new Album();
				break;
			case "movie":
				e = new Movie();
				break;
			case "tvshow":
				e = new TVShow();
				break;
			case "audiobook":
				e = new Audiobook();
				break;
			default:
				e = new InventoryItem();
				System.out.println("Invalid item type");
			}
			
			e.insert(conn, s);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
