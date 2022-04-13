package commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Actor;
import entities.Album;
import entities.Artist;
import entities.Audiobook;
import entities.Author;
import entities.Director;
import entities.InventoryItem;
import entities.Movie;
import entities.Patron;
import entities.Person;
import entities.Staff;
import entities.TVShow;
import entities.Track;
import util.Utils;

public class SearchCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter the type (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();
		ResultSet rs = null;

		try {
			switch (type) {
			// Bullet 1:
			case "artist":
				rs = Artist.search(conn, s);
				break;
			case "album":
				rs = Album.search(conn, s);
				break;
			case "track":
				rs = Track.search(conn, s);
				break;

			// Bullet 2:
			case "movie":
				rs = Movie.search(conn, s);
				break;
			case "actor":
				rs = Actor.search(conn, s);
				break;
			case "director":
				rs = Director.search(conn, s);

				// Bullet 3:
			case "author":
				rs = Author.search(conn, s);
				break;
			case "audiobook":
				rs = Audiobook.search(conn, s);
				break;
			// No chapter because its a weak entity.

			// Extra:
			case "tvshow":
				rs = TVShow.search(conn, s);
				break;

			case "inventory_item":
				rs = InventoryItem.search(conn, s);
				break;

			// People
			case "person":
				rs = Person.search(conn, s);
				break;
			case "patron":
				rs = Patron.search(conn, s);
				break;
			case "staff":
				rs = Staff.search(conn, s);
				break;

			default:
				System.out.println("Invalid item type");
			}

			if (rs != null) {
				System.out.println("Printing the matching records in: " + type);
				Utils.printRecords(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
