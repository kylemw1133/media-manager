package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

<<<<<<< HEAD
import entities.*;
=======
import entities.Album;
import entities.Audiobook;
import entities.InventoryItem;
import entities.Movie;
>>>>>>> branch 'master' of https://github.com/kylemw1133/media-manager.git

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
<<<<<<< HEAD
		case "audiobook":
			Audiobook.search(conn, s);
			break;
		case "inventory_item":
			//InventoryItem.search(conn, s);
			break;
		case "tvshow":
			TVShow.retrieve(conn, s);
=======
		case "tvshow":
			//TVShow.search(conn, s);
			break;
		case "audiobook":
			Audiobook.search(conn, s);
			break;
		case "inventory_item":
			//InventoryItem.search(conn, s);
>>>>>>> branch 'master' of https://github.com/kylemw1133/media-manager.git
			break;
		default:
			System.out.println("Invalid item type");
		}
	}
}
