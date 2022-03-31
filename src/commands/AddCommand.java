package commands;

import java.sql.Connection;
import java.util.Scanner;

public class AddCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to add (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();

		switch (type) {
		case "album":
			System.out.print("name: ");
			System.out.print("length: ");
			System.out.print("year: ");

			// sql = "INSERT INTO album ";
			break;
		case "movie":

			break;
		case "tvshow":

			break;
		case "audiobook":

			break;
		default:
			System.out.println("Invalid item type");
		}
	}

}
