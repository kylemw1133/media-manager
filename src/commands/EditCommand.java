package commands;

import java.sql.Connection;
import java.util.Scanner;

public class EditCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.println("Enter the name of the item you want to edit:");
		String name = s.nextLine();
	}

}
