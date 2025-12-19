package dao;

import databaseManager.DataBaseConnect;
import entities.Patient;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    private List<Patient> parients; //λιστα που θα μπαινουν οι πελατες,στην συνεχεια θα αρχικοποιηθει σε arraylist
    public PatientDAO(){
        this.parients=new ArrayList<>();//εγινε arraylist
    }

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
            System.err.println("Error: "+e.getMessage());
        }
    }



}
