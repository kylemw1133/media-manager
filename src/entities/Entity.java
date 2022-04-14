package entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public interface Entity {
	public Object insert(Connection conn, Scanner s) throws SQLException;

	public void edit(Connection conn, Scanner s) throws SQLException;

	public Object insertOrSearch(Connection conn, Scanner s, boolean insert) throws SQLException;


}
