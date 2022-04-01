package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;
import java.sql.ResultSet;

import util.TypedAttribute;
import util.Utils;

public class Audiobook {

    private final static String insertAudiobookSQL = "INSERT INTO AUDIOBOOK VALUES (? ? ? ? ? ?);";
    private final static String selectAudiobookSQL = "SELECT * FROM AUDIOBOOK WHERE Inventory_ID = ?;";
    private final static String editAudiobookSQL = "UPDATE AUDIOBOOK SET ? WHERE Inventory_ID = ?;";

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
        PreparedStatement editAudiobookStmt = conn.prepareStatement(editAudiobookSQL);

        System.out.println("Enter the inventory ID of the audiobook ");

        String id = "";
        // repeat promp for inventory id until user inputs a valid integer
        while (id.equals("") || !id.matches("\\-?\\d+")) {
            id = s.nextLine();
        }

        selectAudiobookStmt.setString(1, id);
        editAudiobookStmt.setString(2, id);

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
                case "2":
                    System.out.println("Enter new Length");
                    newInput = "Length=" + s.nextLine();
                case "3":
                    System.out.println("Enter new Year");
                    newInput = "Year=" + s.nextLine();
                case "4":
                    System.out.println("Enter new Name");
                    newInput = "Name=" + s.nextLine();
                case "5":
                    System.out.println("Enter new Reader");
                    newInput = "Reader=" + s.nextLine();
                case "6":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

            if (newInput != "") {
                editAudiobookStmt.setString(1, newInput);
                editAudiobookStmt.executeUpdate();
            }

        } else {
            System.out.println("Record not found...");
        }
        editAudiobookStmt.close();
        selectAudiobookStmt.close();
    }
}
