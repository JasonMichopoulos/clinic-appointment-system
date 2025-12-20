package databaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnect {

    private static final String dbURL = "jdbc:sqlite:clinic-appointment/resources/clinic.db";


    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(dbURL);

            // ΕΝΕΡΓΟΠΟΙΗΣΗ FOREIGN KEYS
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("PRAGMA foreign_keys = ON");
            }

            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to database", e);
        }
    }

}
