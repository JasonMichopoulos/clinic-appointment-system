package databaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBaseConnect {

    private static final String DB_URL =
            "jdbc:sqlite:clinic-appointment/resources/clinic.db";


    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL);
            enableForeignKeys(connection);
            return connection;

        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to database", e);
        }
    }

    private static void enableForeignKeys(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON");
        }
    }
}
