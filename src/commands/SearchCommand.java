package commands;

import java.sql.Connection;
import java.util.Scanner;

import entities.Movie;

public class SearchCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.println("Enter the type: ");
		String type = s.nextLine();
		String sql;

		switch (type) {
		case "album":
			sql = "SELECT * FROM ALBUM;";
			break;
		case "movie":
			Movie.retrieve(conn, s);
			break;
		}
	}
}
