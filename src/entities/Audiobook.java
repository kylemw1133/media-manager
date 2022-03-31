package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import util.TypedAttribute;
import util.Utils;

public class Audiobook {

    private final static String insertAudiobookSQL = "INSERT INTO AUDIOBOOK VALUES (? ? ? ? ? ?);";

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
}
