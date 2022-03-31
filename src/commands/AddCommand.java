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
		InventoryItem i;

		switch (type) {
		case "album":
			Album.insert(conn, s);
			break;
		case "movie":
			try {
				int id = Movie.insert(conn, s);
				System.out.println(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "tvshow":
			TVShow.insert(conn, s);
			break;
		case "audiobook":
			Audiobook.insert(conn, s);
			break;
		default:
			System.out.println("Invalid item type");
		}
	}

}
