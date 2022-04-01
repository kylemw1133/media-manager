package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Album;
import entities.Audiobook;
import entities.InventoryItem;
import entities.Movie;

public class SearchCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.println("Enter the type: ");
		String type = s.nextLine();
		
		switch (type) {
		case "album":
			Album.search(conn, s);
			break;
		case "movie":
			Movie.search(conn, s);
			break;
		case "tvshow":
			//TVShow.search(conn, s);
			break;
		case "audiobook":
			Audiobook.search(conn, s);
			break;
		case "inventory_item":
			//InventoryItem.search(conn, s);
			break;
		default:
			System.out.println("Invalid item type");
		}
	}
}
