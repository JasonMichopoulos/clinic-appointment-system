package dao;

import databaseManager.DataBaseConnect;
import entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public void addPatient(Patient patient) {
        String sql =
                "INSERT INTO patients " +
                        "(first_name, last_name, father_name, amka, phone_number, emergency_call, address, notes) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt =
                     conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setString(3, patient.getFathersName());
            pstmt.setString(4, patient.getAmka());
            pstmt.setString(5, patient.getPhoneNumber());
            pstmt.setString(6, patient.getEmergencyCall());
            pstmt.setString(7, patient.getAddress());
            pstmt.setString(8, patient.getNotes());

            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    patient.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM patients WHERE id = ?";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByAMKA(String amka) {
        String sql = "DELETE FROM patients WHERE amka = ?";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, amka);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Patient findById(int id) {
        String sql = "SELECT * FROM patients WHERE id = ?";
        Patient patient = null;

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    patient = mapRowToPatient(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return patient;
    }

    public Patient findByAMKA(String amka) {
        String sql = "SELECT * FROM patients WHERE amka = ?";
        Patient patient = null;

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, amka);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    patient = mapRowToPatient(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return patient;
    }

    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                patients.add(mapRowToPatient(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return patients;
    }

    public int deleteAll() {
        String sql = "DELETE FROM patients";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePatientById(Patient patient, int id) {
        String sql =
                "UPDATE patients SET " +
                        "first_name = ?, " +
                        "last_name = ?, " +
                        "father_name = ?, " +
                        "amka = ?, " +
                        "phone_number = ?, " +
                        "emergency_call = ?, " +
                        "address = ?, " +
                        "notes = ? " +
                        "WHERE id = ?";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setString(3, patient.getFathersName());
            pstmt.setString(4, patient.getAmka());
            pstmt.setString(5, patient.getPhoneNumber());
            pstmt.setString(6, patient.getEmergencyCall());
            pstmt.setString(7, patient.getAddress());
            pstmt.setString(8, patient.getNotes());
            pstmt.setInt(9, id);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Patient mapRowToPatient(ResultSet rs) throws SQLException {
        Patient patient = new Patient();

        patient.setId(rs.getInt("id"));
        patient.setFirstName(rs.getString("first_name"));
        patient.setLastName(rs.getString("last_name"));
        patient.setFathersName(rs.getString("father_name"));
        patient.setAmka(rs.getString("amka"));
        patient.setPhoneNumber(rs.getString("phone_number"));
        patient.setEmergencyCall(rs.getString("emergency_call"));
        patient.setAddress(rs.getString("address"));
        patient.setNotes(rs.getString("notes"));

        return patient;
    }
}
