package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.*;

public class EditCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to edit (album, movie, tvshow, audiobook, inventory_item): ");
		String type = s.nextLine();

		try {
			switch (type) {
			case "album":
				Album.edit(conn, s);
				break;
			case "movie":
				Movie.edit(conn, s);
				break;
			case "tvshow":
				//TVShow.edit(conn, s);
				break;
			case "audiobook":
				Audiobook.edit(conn, s);
				break;
			case "inventory_item":
				InventoryItem.edit(conn, s);
				break;
			default:
				System.out.println("Invalid item type");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
