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
import entities.Card;
import entities.Chapter;
import entities.Checkout;
import entities.Director;
import entities.Episode;
import entities.InventoryItem;
import entities.Movie;
import entities.Order;
import entities.Patron;
import entities.Person;
import entities.Season;
import entities.Staff;
import entities.Seller;
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
				break;

			// Bullet 3:
			case "author":
				rs = Author.search(conn, s);
				break;
			case "audiobook":
				rs = Audiobook.search(conn, s);
				break;
			case "chapter":
				rs = Chapter.search(conn, s);
				break;

			// Extra:
			case "tvshow":
				rs = TVShow.search(conn, s);
				break;
			case "season":
				rs = Season.search(conn, s);
				break;
			case "episode":
				rs = Episode.search(conn, s);
				break;

			case "inventory_item":
				rs = InventoryItem.search(conn, s);
				break;

			// Order and Checkout
			case "order":
				rs = Order.search(conn, s);
				break;
			case "checkout":
				rs = Checkout.search(conn, s);
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
			case "card":
				rs = Card.search(conn, s);
				break;

			// Seller
			case "seller":
				rs = Seller.search(conn, s);
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
