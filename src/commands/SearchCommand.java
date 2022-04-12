package commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entities.*;
import util.Utils;

public class SearchCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter the type (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();
		ResultSet rs;

		try {
			switch (type) {
			case "album":
				rs = Album.search(conn, s);
				break;
			case "movie":
				rs = Movie.search(conn, s);
				break;
			case "audiobook":
				rs = Audiobook.search(conn, s);
				break;
			case "tvshow":
				rs = TVShow.search(conn, s);
				break;
			default:
				System.out.println("Invalid item type");
				return;
			}

			Utils.printRecords(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
