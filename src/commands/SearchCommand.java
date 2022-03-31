package commands;

import java.util.Scanner;


public class SearchCommand {

	public static String exec(Scanner s) {
		System.out.println("Enter the type: ");
		String type = s.nextLine();
		String sql;
		switch(type) {
		case "album":
			sql =  "SELECT * FROM ALBUM;";
			break;
		default:
			return null;
		}
		return sql;
		
		
		
		
	}
}
