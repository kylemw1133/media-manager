package commands;

import java.sql.Connection;
import java.util.Scanner;

import entities.*;

public class SearchCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter the type (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();
		
		switch (type) {
		case "album":
			Album.search(conn, s);
			break;
		case "movie":
			Movie.search(conn, s);
			break;
		case "audiobook":
			Audiobook.search(conn, s);
			break;
		case "inventory_item":
			//InventoryItem.search(conn, s);
			break;
		case "tvshow":
			TVShow.retrieve(conn, s);
			break;
		default:
			System.out.println("Invalid item type");
		}
	}
}
