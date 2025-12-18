import databaseManager.DataBaseConnect;
import databaseManager.initializeTable;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println(DataBaseConnect.getConnection());
        initializeTable.createTables();
    }
}