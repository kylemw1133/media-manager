package commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entities.*;
import util.Utils;

public class ListCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to add (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();
		ResultSet rs = null;

		try {
			switch (type) {
			// Bullet 1:
			case "artist":
				rs = Artist.list(conn);
				break;
			case "album":
				rs = Album.list(conn);
				break;
			case "track":
				rs = Track.list(conn);
				break;

			// Bullet 2:
			case "movie":
				rs = Movie.list(conn);
				break;
			case "actor":
				rs = Actor.list(conn);
				break;
			case "director":
				rs = Director.list(conn);

				// Bullet 3:
			case "author":
				rs = Author.list(conn);
				break;
			case "audiobook":
				rs = Audiobook.list(conn);
				break;
			// No chapter because its a weak entity.

			// Extra:
			case "tvshow":
				rs = TVShow.list(conn);
				break;
				
			case "inventory_item":
				rs = InventoryItem.list(conn);
				break;

			// People
			case "person":
				rs = Person.list(conn);
				break;
			case "patron":
				rs = Patron.list(conn);
				break;
			case "staff":
				rs = Staff.list(conn);
				break;

			default:
				System.out.println("Invalid item type");
			}

			if (rs != null) {
				System.out.println("Printing records in relation: " + type);
				Utils.printRecords(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
