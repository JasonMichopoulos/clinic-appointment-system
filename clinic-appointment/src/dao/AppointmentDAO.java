package dao;

import databaseManager.DataBaseConnect;
import entities.Appointment;
import entities.Doctor;
import entities.Patient;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    public Appointment findById(int id) {
        String sql = "SELECT a.id, " +
                "a.appointment_date_start, " +
                "a.appointment_date_end, " +
                "a.is_done, " +
                "p.id AS patient_id, " +
                "p.first_name AS patient_first_name, " +
                "p.last_name AS patient_last_name, " +
                "d.id AS doctor_id, " +
                "d.first_name AS doctor_first_name, " +
                "d.last_name AS doctor_last_name " +
                "FROM appointments a " +
                "JOIN patients p ON p.id = a.patient_id " +
                "JOIN doctors d ON d.id = a.doctor_id " +
                "WHERE a.id = ?";


        Appointment appointment = null;

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    appointment = mapRowToAppointment(rs);
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return appointment;
    }

    public List<Appointment> findAll() {
        List<Appointment> appointmentList = new ArrayList<>();

        String sql = "SELECT " +
                "a.id, " +
                "a.appointment_date_start, " +
                "a.appointment_date_end, " +
                "a.is_done, " +
                "p.id AS patient_id, " +
                "p.first_name AS patient_first_name, " +
                "p.last_name AS patient_last_name, " +
                "d.id AS doctor_id, " +
                "d.first_name AS doctor_first_name, " +
                "d.last_name AS doctor_last_name " +
                "FROM appointments a " +
                "JOIN patients p ON p.id = a.patient_id " +
                "JOIN doctors d ON d.id = a.doctor_id";

        try (Connection conn = DataBaseConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                appointmentList.add(mapRowToAppointment(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return appointmentList;
    }

    public void deleteAll(){
        String sql="DELETE FROM appointments";
        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Appointment> findbyStartDate(LocalDateTime startDate){
        List<Appointment> appointments=new ArrayList<>();
        String sql = "SELECT " +
                "a.id, " +
                "a.appointment_date_start, " +
                "a.appointment_date_end, " +
                "a.is_done, " +
                "p.id AS patient_id, " +
                "p.first_name AS patient_first_name, " +
                "p.last_name AS patient_last_name, " +
                "d.id AS doctor_id, " +
                "d.first_name AS doctor_first_name, " +
                "d.last_name AS doctor_last_name " +
                "FROM appointments a " +
                "JOIN patients p ON p.id = a.patient_id " +
                "JOIN doctors d ON d.id = a.doctor_id " +
                "WHERE a.appointment_date_start = ?";


                try(Connection conn=DataBaseConnect.getConnection();
                   PreparedStatement pstmt= conn.prepareStatement(sql)){

                    pstmt.setObject(1,startDate);
                    try(ResultSet rs= pstmt.executeQuery()){
                        while (rs.next()){
                            appointments.add(mapRowToAppointment(rs));
                        }
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                return appointments;
    }

    public void deleteByStartDate(LocalDateTime startDate){
        String sql="DELETE FROM appointments WHERE appointment_date_start=?";
        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){

            pstmt.setObject(1,startDate);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Appointment mapRowToAppointment(ResultSet rs) throws SQLException {

        Appointment appointment = new Appointment();
        Patient patient = new Patient();
        Doctor doctor = new Doctor();

        appointment.setId(rs.getInt("id"));
        appointment.setStart_date(rs.getObject("appointment_date_start", LocalDateTime.class));
        appointment.setEnd_date(rs.getObject("appointment_date_end", LocalDateTime.class));
        appointment.setIs_done(rs.getInt("is_done"));

        // Patient
        patient.setId(rs.getInt("patient_id"));
        patient.setFirstName(rs.getString("patient_first_name"));
        patient.setLastName(rs.getString("patient_last_name"));

        // Doctor
        doctor.setId(rs.getInt("doctor_id"));
        doctor.setFirstName(rs.getString("doctor_first_name"));
        doctor.setLastName(rs.getString("doctor_last_name"));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointment;
    }




















}
