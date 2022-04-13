package commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entities.*;

public class EditCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to edit (album, movie, tvshow, audiobook, inventory_item): ");
		String type = s.nextLine();
		ResultSet rs;
		Entity e = null;

		try {
			switch (type) {
			// Bullet 1:
			case "artist":
				e = Artist.searchForOne(conn, s);
				break;
			case "album":
				e = Album.searchForOne(conn, s);
				break;
			case "track":
				e = Track.searchForOne(conn, s);
				break;

			// Bullet 2:
			case "movie":
				e = Movie.searchForOne(conn, s);
				break;
			case "actor":
				e = Actor.searchForOne(conn, s);
				break;
			case "director":
				e = Director.searchForOne(conn, s);

				// Bullet 3:
			case "author":
				e = Author.searchForOne(conn, s);
				break;
			case "audiobook":
				e = Audiobook.searchForOne(conn, s);
				break;
			case "chapter":
				e = Chapter.searchForOne(conn, s);
				break;

			// Extra:
			case "tvshow":
				e = TVShow.searchForOne(conn, s);
				break;
			case "season":
				e = Season.searchForOne(conn, s);
				break;
			case "episode":
				e = Episode.searchForOne(conn, s);
				break;
			default:
				System.out.println("Invalid item type");
			}

			if (e != null) {
				System.out.println("Preparing to edit the following item of type: " + type);
				System.out.println(e.toString());
				e.edit(conn, s);
				System.out.println("Edit Finished.");
			} else {
				System.out.println("No Entity Found.");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
