package dao;

import databaseManager.DataBaseConnect;
import entities.Appointment;
import entities.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) {
        String sql =
                "INSERT INTO doctors (first_name, last_name, phone_number, sector) " +
                        "VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt =
                     conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getPhoneNumber());
            pstmt.setString(4, doctor.getSector());

            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    doctor.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM doctors WHERE id = ?";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBySector(String sector) {
        String sql = "DELETE FROM doctors WHERE sector = ?";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sector);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Doctor findById(int id) {
        String sql = "SELECT * FROM doctors WHERE id = ?";
        Doctor doctor = null;

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    doctor = mapRowToDoctor(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return doctor;
    }


    public List<Doctor> findBySector(String sector) {
        String sql = "SELECT * FROM doctors WHERE sector = ?";
        List<Doctor> doctors = new ArrayList<>();

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sector);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Doctor doctor = mapRowToDoctor(rs);
                    doctors.add(doctor);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return doctors;
    }


    public List<Doctor> findAll(){
        List<Doctor> doctors=new ArrayList<>();
        String sql="SELECT * FROM doctors";
        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();){

            while(rs.next()){
                doctors.add(mapRowToDoctor(rs));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return doctors;
    }


    public int deleteAll() {
        String sql = "DELETE FROM doctors";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateDoctorById(Doctor doctor,int id) {
        String sql = "UPDATE doctors SET first_name=?,last_name=?,phone_number=?,sector=? WHERE id=?";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getPhoneNumber());
            pstmt.setString(4, doctor.getSector());
            pstmt.setInt(5, doctor.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Doctor mapRowToDoctor(ResultSet rs) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setId(rs.getInt("id"));
        doctor.setFirstName(rs.getString("first_name"));
        doctor.setLastName(rs.getString("last_name"));
        doctor.setPhoneNumber(rs.getString("phone_number"));
        doctor.setSector(rs.getString("sector"));
        return doctor;
    }





}
