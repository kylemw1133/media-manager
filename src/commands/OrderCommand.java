package commands;

import java.sql.Connection;
import java.util.Scanner;

public class OrderCommand {

	public static void exec(Connection conn, Scanner s) {
		System.out.println("Enter the name of the item you want to order:");
		String name = s.nextLine();
		System.out.println("Enter how many of that item you want to order:");
		int quantity = Integer.parseInt(s.next());
	}

}
