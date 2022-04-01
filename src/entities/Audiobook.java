package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.TypedAttribute;
import util.Utils;

public class Audiobook {

    private final static String insertAudiobookSQL = "INSERT INTO AUDIOBOOK VALUES (? ? ? ? ? ?);";
    private final static String selectAudiobookSQL = "SELECT * FROM AUDIOBOOK WHERE Inventory_ID=?;";
    // private final static String editAudiobookSQL = "UPDATE AUDIOBOOK SET ? WHERE
    // Inventory_ID = ?;";

    public static int insert(Connection conn, Scanner s) throws SQLException {
        int id = InventoryItem.insert(conn, s);

        int i = 1;
        LinkedList<TypedAttribute> colSet = Utils.getColumns(conn, "AUDIOBOOK");
        PreparedStatement insertAudiobookStmt = conn.prepareStatement(insertAudiobookSQL);

        for (TypedAttribute a : colSet) {
            if (a.name == "Inventory_ID") {
                a.value = id;
            } else {
                a.promptForValue(s);
            }

            a.fillInStmt(insertAudiobookStmt, i);
            i++;
        }

        return id;
    }

    public static void edit(Connection conn, Scanner s) throws SQLException {
        PreparedStatement selectAudiobookStmt = conn.prepareStatement(selectAudiobookSQL);
        // PreparedStatement editAudiobookStmt =
        // conn.prepareStatement(editAudiobookSQL);

        System.out.println("Enter the inventory ID of the audiobook ");

        String id = "";
        // repeat promp for inventory id until user inputs a valid integer
        while (id.equals("") || !id.matches("\\-?\\d+")) {
            id = s.nextLine();
        }

        selectAudiobookStmt.setString(1, id);
        // editAudiobookStmt.setString(2, id);

        ResultSet selectedRecord = selectAudiobookStmt.executeQuery();

        if (selectedRecord.next()) {
            Utils.printRecords(selectedRecord);
            System.out.println("Which field do you want to edit?");
            System.out.println("1: Author_ID | 2: Length | 3: Year | 4: Name | 5: Reader | 6: EXIT");
            String input = s.nextLine();
            String newInput = "";

            switch (input) {
                case "1":
                    System.out.println("Enter new Author_ID");
                    newInput = "Author_ID=" + s.nextLine();
                    break;
                case "2":
                    System.out.println("Enter new Length");
                    newInput = "Length=" + s.nextLine();
                    break;
                case "3":
                    System.out.println("Enter new Year");
                    newInput = "Year=" + s.nextLine();
                    break;
                case "4":
                    System.out.println("Enter new Name");
                    newInput = "Name=" + s.nextLine();
                    break;
                case "5":
                    System.out.println("Enter new Reader");
                    newInput = "Reader=" + s.nextLine();
                    break;
                case "6":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

            if (newInput != "") {
                // editAudiobookStmt.setString(1, newInput);
                // editAudiobookStmt.executeUpdate();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE AUDIOBOOK SET " + newInput + " WHERE Inventory_ID=" + id);
                stmt.close();
                System.out.println("Record Updated");
            }

        } else {
            System.out.println("Record not found...");
        }
        // editAudiobookStmt.close();
        selectAudiobookStmt.close();
    }

    public static void search(Connection conn, Scanner s) {
        try {
            Statement stmt = conn.createStatement();
            System.out.println("Which field do you want to search by?");
            System.out.println("1: Author_ID | 2: Length | 3: Year | 4: Name | 5: Reader | 6: EXIT: ");
            String input = s.nextLine();
            String searchInputString = "";
            int searchInputInt;
            String searchCol = "";
            String searchAudiobookSQL = "";
            switch (input) {
                case "1":
                    System.out.println("Enter search authorID");
                    searchCol = "author_id";
                    searchInputInt = Integer.parseInt(s.nextLine());
                    searchAudiobookSQL = "SELECT * FROM AUDIOBOOK WHERE " + searchCol + "=" + searchInputInt + ";";
                    break;
                case "2":
                    System.out.println("Enter search Length");
                    searchCol = "length";
                    searchInputInt = Integer.parseInt(s.nextLine());
                    searchAudiobookSQL = "SELECT * FROM AUDIOBOOK WHERE " + searchCol + "=" + searchInputInt + ";";
                    break;
                case "3":
                    System.out.println("Enter search Year");
                    searchCol = "year";
                    searchInputInt = Integer.parseInt(s.nextLine());
                    searchAudiobookSQL = "SELECT * FROM AUDIOBOOK WHERE " + searchCol + "=" + searchInputInt + ";";
                    break;
                case "4":
                    System.out.println("Enter search Name");
                    searchCol = "name";
                    searchInputString = s.nextLine();
                    searchAudiobookSQL = "SELECT * FROM AUDIOBOOK WHERE " + searchCol + "=" + "\"" + searchInputString
                            + "\"; ";
                    break;
                case "5":
                    System.out.println("Enter search Reader");
                    searchCol = "reader";
                    searchInputString = s.nextLine();
                    searchAudiobookSQL = "SELECT * FROM AUDIOBOOK WHERE " + searchCol + "=" + "\"" + searchInputString
                            + "\"; ";
                    break;
                case "6":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            if (searchCol != "") {
                ResultSet rs = stmt.executeQuery(searchAudiobookSQL);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String value = rsmd.getColumnName(i);
                    System.out.print(value);
                    if (i < columnCount)
                        System.out.print(",  ");
                }
                System.out.print("\n");
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnValue = rs.getString(i);
                        System.out.print(columnValue);
                        if (i < columnCount)
                            System.out.print(",  ");
                    }
                    System.out.print("\n");
                }
            } else {
                System.out.println("...");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
