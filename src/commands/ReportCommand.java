package commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import util.Utils;

public class ReportCommand {

	public static final String report1Desc = "Report the total number of albums, movies and audiobooks checked out by a single patron.";
	public static final String report1SQL = "SELECT COUNT(Album.Inventory_ID)\n" + "FROM PATRON, CHECKOUT, ALBUM\n"
			+ "WHERE PATRON.P_Email = ?\n" + "AND PATRON.Card_ID = CHECKOUT.Card_ID\n"
			+ "AND CHECKOUT.Inventory_ID = ALBUM.Inventory_ID;";

	public static final String report2Desc = "Report the most popular actor in the database.";
	public static final String report2SQL = "SELECT ACTOR.Name, count(distinct CHECKOUT.Checkout_ID) as Checkout_Count\n"
			+ "FROM ACTOR, STARS, CHECKOUT\n" + "WHERE ACTOR.Actor_ID = STARS.Actor_ID\n"
			+ "AND STARS.Inventory_ID = CHECKOUT.Inventory_ID\n" + "GROUP BY ACTOR.Name\n"
			+ "ORDER BY Checkout_Count DESC\n" + "LIMIT 1;";

	public static final String report3Desc = "Report the most listened to artist in the database.";
	public static final String report3SQL = "SELECT ARTIST.Name, sum(Album_Checked_Out_Length) as Total_Checked_Out_Length\n"
			+ "FROM ARTIST, ALBUM_ARTIST, ( SELECT ALBUM.Inventory_ID AS ID, ALBUM.Length * count(distinct CHECKOUT.Checkout_ID) AS Album_Checked_Out_Length\n"
			+ "                             FROM ALBUM, CHECKOUT\n"
			+ "                             WHERE ALBUM.Inventory_ID = CHECKOUT.Inventory_ID\n"
			+ "                             GROUP BY ALBUM.Inventory_ID ) AS A\n"
			+ "WHERE ARTIST.Artist_ID = ALBUM_ARTIST.Artist_ID\n" + "AND ALBUM_ARTIST.Inventory_ID = A.ID\n"
			+ "GROUP BY ARTIST.Name\n" + "ORDER BY Total_Checked_Out_Length DESC\n" + "LIMIT 1;";

	public static final String report4Desc = "Report the most listened to author in the database.";
	public static final String report4SQL = "SELECT AUTHOR.Name, sum(Book_Checked_Out_Length) as Total_Checked_Out_Length\n"
			+ "FROM AUTHOR, AUDIOBOOK, ( SELECT AUDIOBOOK.Inventory_ID AS ID, AUDIOBOOK.Length * count(distinct CHECKOUT.Checkout_ID) AS Book_Checked_Out_Length\n"
			+ "                             FROM AUDIOBOOK, CHECKOUT\n"
			+ "                             WHERE AUDIOBOOK.Inventory_ID = CHECKOUT.Inventory_ID\n"
			+ "                             GROUP BY AUDIOBOOK.Inventory_ID ) AS A\n"
			+ "WHERE AUTHOR.Author_ID = A.ID\n" + "GROUP BY AUTHOR.Name\n" + "ORDER BY Total_Checked_Out_Length DESC\n"
			+ "LIMIT 1;";

	public static final String report5Desc = "Report the patron who has checked out the most videos and the total number of videos they have checked out.";
	public static final String report5SQL = "SELECT PERSON.P_Name, COUNT(MOVIE.Inventory_ID) AS Num_Movies_Checked_Out\n"
			+ "FROM PERSON, PATRON, CHECKOUT, MOVIE\n" + "WHERE PERSON.P_Email = PATRON.P_Email\n"
			+ "AND PATRON.Card_ID = CHECKOUT.Card_ID\n" + "AND CHECKOUT.Inventory_ID = MOVIE.Inventory_ID\n"
			+ "GROUP BY PERSON.P_Name\n" + "ORDER BY Num_Movies_Checked_Out DESC\n" + "LIMIT 1;";

	public static final String report6Desc = "Report the titles of all tracks by ARTIST released before YEAR.";
	public static final String report6SQL = "SELECT Track.Name\n" + "FROM TRACK, ARTIST\n"
			+ "WHERE TRACK.Artist_ID = ARTIST.Artist_ID\n" + "AND ARTIST.Name = ?\n" + "AND TRACK.Year < ?;";

	public static final String[] reportDescs = { report1Desc, report2Desc, report3Desc, report4Desc, report5Desc, report6Desc };
	public static final String[] reportSQLs = { report1SQL, report2SQL, report3SQL, report4SQL, report5SQL, report6SQL };

	public static void exec(Connection conn, Scanner s) {
		
		System.out.println("The available reports are as follows:");
		
		for (int i = 0; i < reportDescs.length; i++) {
			System.out.println("Report " + (i + 1) + ": " + reportDescs[i]);
		}
		
		System.out.print("Select one (1 - 6): ");
		int selection = Integer.parseInt(s.nextLine()) - 1;

		try {
			PreparedStatement stmt = conn.prepareStatement(reportSQLs[selection]);
			
			switch (selection) {
			case 0:
				System.out.print("Provide the patron's email: ");
				String email = s.nextLine();
				stmt.setString(1, email);
				break;
			case 5:
				System.out.print("Provide the artist's ID: ");
				int id = Integer.parseInt(s.nextLine());
				System.out.print("Provide the year: ");
				int year = Integer.parseInt(s.nextLine());

				stmt.setInt(1, id);
				stmt.setInt(2, year);
				break;
			}
			
			Utils.printRecords(stmt.executeQuery());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
                
		
	}

}
