package dao;

import databaseManager.DataBaseConnect;
import entities.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public void addPatient(Patient p) throws SQLException {
        String sql="INSERT INTO patients (first_name,last_name,father_name,amka,phone_number,emergency_call,address,notes) VALUES (?,?,?,?,?,?,?,?)";
        //query string για την εισαγωγη ασθενων στο arraylist

        try(Connection conn= DataBaseConnect.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){// δημιουργουμε connection με την βαση και ενα preparestmt για να εκτελεσουμε το sql query και να παρουμε το πρωτο id

            //μετατρεπω τις java μεταβλητες σε sql
            pstmt.setString(1,p.getFirstName());
            pstmt.setString(2,p.getLastName());
            pstmt.setString(3,p.getFathersName());
            pstmt.setString(4,p.getAmka());
            pstmt.setString(5,p.getPhoneNumber());
            pstmt.setString(6,p.getEmergencyCall());
            pstmt.setString(7,p.getAddress());
            pstmt.setString(8,p.getNotes());

            pstmt.executeUpdate();//εκτελει το insert

            ResultSet rs = pstmt.getGeneratedKeys();//κανει generate το πρωτο index ετσι ωστε να αυξανεται +1
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                p.setId(generatedId);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id){// Διαγραφη ασθενη με βαση το id
        String sql="DELETE FROM patients WHERE id=?";
        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){

            pstmt.setInt(1,id);
            pstmt.executeUpdate();

        }catch(SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    public void deleteByAMKA(String amka){//Διαγραφη του ασθενη με βαση το ΑΜΚΑ
        String sql="DELETE FROM patients WHERE amka=?";

        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){

            pstmt.setString(1,amka);
            pstmt.executeUpdate();

        }catch(SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    public Patient findById(int id){// Αναζητηση ασθενη με βαση id
        String sql="SELECT * FROM patients WHERE id=?";
        Patient patient=null;

        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){

            pstmt.setInt(1,id);

            ResultSet rs= pstmt.executeQuery();
            if(rs.next()){

                //βρισκουμε το αντικειμενο με το συγκεκριμενο id ετσι ωστε να το επιστρεψουμε
                patient=new Patient();

                patient.setId(rs.getInt("id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setFathersName(rs.getString("father_name"));
                patient.setAmka(rs.getString("amka"));
                patient.setEmergencyCall(rs.getString("emergency_call"));
                patient.setAddress(rs.getString("address"));
                patient.setNotes(rs.getString("notes"));
            }

        } catch (SQLException e) {
            System.err.println("Error: "+e.getMessage());
        }
        return patient;
    }

    public Patient findByAMKA(String amka){// βρισκει τον ασθενη με βαση το amka του
        String sql="SELECT * FROM patients WHERE amka=?";
        Patient patient=null;

        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)){

            pstmt.setString(1,amka);

            ResultSet rs= pstmt.executeQuery();
            if(rs.next()){

                //βρισκουμε το αντικειμενο με το συγκεκριμενο  αμκα ετσι ωστε να το επιστρεψουμε
                patient=new Patient();

                patient.setId(rs.getInt("id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setFathersName(rs.getString("father_name"));
                patient.setAmka(rs.getString("amka"));
                patient.setEmergencyCall(rs.getString("emergency_call"));
                patient.setAddress(rs.getString("address"));
                patient.setNotes(rs.getString("notes"));
            }

        } catch (SQLException e) {
            System.err.println("Error: "+e.getMessage());
        }
        return patient;
    }

    public List<Patient> findAll(){// εμφανιζει ολους τους ασθενης
        List<Patient> patients=new ArrayList<>();
        Patient patient=null;

        String sql="SELECT * FROM patients";
        try(Connection conn=DataBaseConnect.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery()){

            while(rs.next()){

                patient=new Patient();

                patient.setId(rs.getInt("id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setFathersName(rs.getString("father_name"));
                patient.setAmka(rs.getString("amka"));
                patient.setEmergencyCall(rs.getString("emergency_call"));
                patient.setAddress(rs.getString("address"));
                patient.setNotes(rs.getString("notes"));

                patients.add(patient);
            }
        }catch (SQLException e){
            System.err.println("Error: "+e.getMessage());
        }
        return patients;
    }






}
