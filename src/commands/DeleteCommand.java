package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.Album;
import entities.Audiobook;

import entities.Movie;
import entities.TVShow;
import util.Utils;

public class DeleteCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.print("Enter type of item to delete (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();
		try {
			switch(type) {
				case "album":
					Album a = new Album();
					a.searchAndDelete(conn, s);
					break;
				case "movie":
					Movie m = new Movie();
					m.searchAndDelete(conn, s);
					break;
				case "tvshow":
					TVShow tv = new TVShow();
					tv.searchAndDelete(conn, s);
					break;
				case "audiobook":
					Audiobook ab = new Audiobook();
					ab.searchAndDelete(conn, s);
					break;
				default:
					System.out.println("Invalid selection");
					
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
}
