package databaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class initializeTable {
    public static void createTables() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS patients(
                id INT AUTO_INCREMENT PRIMARY KEY,
                first_name VARCHAR(255) NOT NULL,
                last_name VARCHAR(255) NOT NULL,
                father_name VARCHAR(255),
                amka VARCHAR(11) NOT NULL UNIQUE,
                phone_number VARCHAR(10) NOT NULL UNIQUE,
                emergency_call VARCHAR(10),
                address VARCHAR(255) NOT NULL,
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
                CREATE TABLE IF NOT EXISTS appointments(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    patient_id INT,
                    doctor_id INT,
                    appointment_date_start DATETIME NOT NULL,
                    appointment_date_end DATETIME NOT NULL,
                    is_done BOOLEAN DEFAULT FALSE,
                    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE,
                    FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE
                );
                """;

        try (Connection conn = DataBaseConnect.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        String sql2= """
                CREATE TABLE IF NOT EXISTS doctors(
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    patient_id INT,
                    first_name VARCHAR(255) NOT NULL,
                    last_name VARCHAR(255) NOT NULL,
                    phone_number VARCHAR(10) NOT NULL UNIQUE,
                    sector VARCHAR(255) NOT NULL,
                    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
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




