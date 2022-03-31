package commands;


import java.util.ArrayList;
import java.util.Scanner;

public class AddCommand {

	public static ArrayList<Object> exec(Scanner s) {
		System.out.print("Enter type of item to add (album, movie, tvshow, audiobook): ");
		String type = s.nextLine();
		ArrayList<Object> data = new ArrayList<>();
		
		switch (type) {
		case "album":
			System.out.print("name: ");
			data.add(s.next());
			System.out.print("length: ");
			data.add(s.nextInt());
			System.out.print("year: ");
			data.add(s.nextInt());
			
			//sql = "INSERT INTO album ";
			break;
		case "movie":
			
			break;
		case "tvshow":
			
			break;
		case "audiobook":
			
			break;
		default:
			System.out.println("Invalid item type");
			return null;
		}
		return data;

	}

}
