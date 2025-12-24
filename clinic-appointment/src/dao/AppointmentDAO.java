package dao;

import databaseManager.DataBaseConnect;
import entities.Appointment;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class AppointmentDAO {
    public void addAppointment(Appointment appointment){
        String sql="INSERT INTO appointments (patient_id, doctor_id, appointment_date_start, appointment_date_end, is_done) VALUES (?,?,?,?,?)";

        try(Connection conn = DataBaseConnect.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            pstmt.setInt(1, appointment.getPatient().getId());
            pstmt.setInt(2, appointment.getDoctor().getId());
            pstmt.setString(3,appointment.getStart_date().format(formatter));
            pstmt.setString(4,appointment.getEnd_date().format(formatter));
            pstmt.setInt(5, appointment.getIs_done());

            pstmt.executeUpdate();

            try(ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    appointment.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletebyId(int id){
        String sql="DELETE FROM appointments WHERE id=?";
        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public Appointment findById(int id){
//        String sql="SELECT * FROM appointments WHERE id=?";
//        Appointment appointment=null;
//
//        try(Connection conn=DataBaseConnect.getConnection();
//           PreparedStatement pstmt= conn.prepareStatement(sql)){
//
//            pstmt.setInt(1,id);
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    appointment = mapRowToAppointment(rs);
//                }
//            }
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//    }


















}
