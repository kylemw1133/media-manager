package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Album;
import entities.InventoryItem;
import entities.Movie;

public class AddCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to add (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();

		try {
			switch (type) {
			case "album":
				Album.insert(conn, s);
				break;
			case "movie":
				Movie.insert(conn, s);
				break;
			case "tvshow":
				//TVShow.insert(conn, s);
				break;
			case "audiobook":
				//Audiobook.insert(conn, s);
				break;
			default:
				System.out.println("Invalid item type");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
