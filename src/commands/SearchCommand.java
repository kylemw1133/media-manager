package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.*;

public class SearchCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter the type (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();

		try {
			switch (type) {
			case "album":
				Album.search(conn, s);
				break;
			case "movie":
				Movie.search(conn, s);
				break;
			case "audiobook":
				Audiobook.search(conn, s);
				break;
			case "tvshow":
				TVShow.search(conn, s);
				break;
			default:
				System.out.println("Invalid item type");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
