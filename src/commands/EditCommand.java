package commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Album;
import entities.Audiobook;
import entities.Entity;
import entities.InventoryItem;
import entities.Movie;
import entities.TVShow;

public class EditCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to edit (album, movie, tvshow, audiobook, inventory_item): ");
		String type = s.nextLine();
		ResultSet rs;
		Entity e;

		try {
			switch (type) {
			case "album":
				e = Album.searchForOne(conn, s);
				break;
			case "movie":
				e = Movie.searchForOne(conn, s);
				break;
			case "tvshow":
				e = TVShow.searchForOne(conn, s);
				break;
			case "audiobook":
				e = Audiobook.searchForOne(conn, s);
				break;
			case "inventory_item":
				e = InventoryItem.searchForOne(conn, s);
				break;
			default:
				System.out.println("Invalid item type");
				return;
			}

			if (e != null) {
				System.out.println("Editing:");
				System.out.println(e.toString());
				e.edit(conn, s);
			} else {
				System.out.println("No Entity Found.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
