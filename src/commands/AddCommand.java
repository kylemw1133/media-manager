package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Actor;
import entities.Album;
import entities.Artist;
import entities.Audiobook;
import entities.Author;
import entities.Card;
import entities.Director;
import entities.Entity;
import entities.Movie;
import entities.Patron;
import entities.Person;
import entities.Staff;
import entities.Seller;
import entities.TVShow;
import entities.Track;

public class AddCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to add (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();
		Entity e = null;

		try {
			switch (type) {
			// Bullet 1:
			case "artist":
				e = new Artist();
				break;
			case "album":
				e = new Album();
				break;
			case "track":
				e = new Track();
				break;

			// Bullet 2:
			case "movie":
				e = new Movie();
				break;
			case "actor":
				e = new Actor();
				break;
			case "director":
				e = new Director();
				break;

			// Bullet 3:
			case "author":
				e = new Author();
				break;
			case "audiobook":
				e = new Audiobook();
				break;
			// No chapter because its a weak entity.

			// Extra:
			case "tvshow":
				e = new TVShow();
				break;

			// People
			case "person":
				e = new Person();
				break;
			case "patron":
				e = new Patron();
				break;
			case "staff":
				e = new Staff();
				break;

			// Card
			case "card":
				e = new Card();
				break;

			// Seller
			case "seller":
				e = new Seller();
				break;

			default:
				System.out.println("Invalid item type");
			}

			if (e != null) {
				System.out.println("Preparing to insert item of type: " + type);
				e.insert(conn, s);
				System.out.println("Inserted.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
