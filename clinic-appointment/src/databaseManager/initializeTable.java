package databaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class initializeTable {
    public static void createTables() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS patients(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                father_name TEXT,
                amka TEXT NOT NULL UNIQUE,
                phone_number TEXT NOT NULL UNIQUE,
                emergency_call TEXT,
                address TEXT NOT NULL,
                notes TEXT
                );
                """;
        try (Connection conn = DataBaseConnect.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }



        String sql1= """
                CREATE TABLE IF NOT EXISTS doctors(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    first_name TEXT NOT NULL,
                    last_name TEXT NOT NULL,
                    phone_number TEXT NOT NULL UNIQUE,
                    sector TEXT NOT NULL
                );
                """;

        try (Connection conn = DataBaseConnect.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        String sql2= """
                CREATE TABLE IF NOT EXISTS appointments(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    patient_id INTEGER NOT NULL,
                    doctor_id INTEGER NOT NULL,
                    appointment_date_start TEXT NOT NULL,
                    appointment_date_end TEXT NOT NULL,
                    is_done INTEGER DEFAULT 0,
                    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE,
                    FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE
                );
                """;

        try (Connection conn = DataBaseConnect.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql2);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}




