package commands;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entities.InventoryItem;

public class DeleteCommand {

	public static void exec(Connection conn, Scanner s) {
		try {
			InventoryItem.delete(conn, s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
