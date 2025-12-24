import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import dao.DoctorDAO;
import dao.PatientDAO;
import databaseManager.initializeTable;
import entities.Doctor;
import entities.Patient;
import enums.Gender;
import gui.doctordashboard.DoctorDashBoard;
import gui.loginWindow;
import gui.patientdashboard.PatientDashBoard;
import services.PatientServices;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Δημιουργία πινάκων στη βάση
        initializeTable.createTables();

        PatientDAO pdao = new PatientDAO();
        DoctorDAO ddao = new DoctorDAO();

        // --------------------------
        // Test addPatient
        // --------------------------
        // Παράδειγμα δημιουργίας ασθενών με null ID
        // Patient patient = new Patient("Xarhs","Makridhs","6912345678","Anesths","123456789011","6912345677","Anthokipwn 36","Problhma sthn kardia");

        // Παράδειγμα δημιουργίας και προσθήκης ασθενών

//        Patient patient1 = new Patient("Nikos", "Kalantas", "6912343678", "Kwstas", "123456689011", "6982345677", "Anthokipwn 36", "Problhma sthn kardia");
//        pdao.addPatient(patient1);
//
//        Patient patient2 = new Patient("Xrhstos", "Papadopoulos", "6912343674", "Kwstas", "123453689011", "6902345677", "Anthokipwn 36", "Problhma sthn kardia");
//        pdao.addPatient(patient2);
//
//        Patient patient3 = new Patient("Makhs", "Papadopoulos", "6212323664", "Xrhstos", "19245678990", "9902345672", "Anthokipwn 36", "Problhma sthn kardia");
//        pdao.addPatient(patient3);
//
//        Patient patient4 = new Patient("Nikos", "Xrhstou", "6212323684", "Xrhstos", "29245678390", "9902325372", "Anthokipwn 36", "Problhma sthn kardia");
//        pdao.addPatient(patient4);


        // --------------------------
        // Test deleteById
        // --------------------------
        // pdao.deleteById(4);
        // System.out.println("Done");

        // --------------------------
        // Test deleteByAMKA
        // --------------------------
        // pdao.deleteByAMKA("29245678390");

        // --------------------------
        // Test findById
        // --------------------------
        // System.out.println(pdao.findById(4));

        // --------------------------
        // Test findByAMKA
        // --------------------------
        // System.out.println(pdao.findByAMKA("29245678390"));

        // --------------------------
        // Test findAll
        // --------------------------
        /*
        List<Patient> patientList = pdao.findAll();
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
        */

        // --------------------------
        // Test deleteAll
        // --------------------------
        // pdao.deleteAll();

        // --------------------------
        // Test addDoctor
        // --------------------------
        // Doctor doctor = new Doctor("Nikos", "Xrhstou", "123456789", "Kardiologos");
        // ddao.addDoctor(doctor);

        // --------------------------
        // Test deleteById
        // --------------------------

//        Patient patient = new Patient(
//                "Syno",
//                "og",
//                "6912345608",
//                "giorgos",
//                "12121212122",
//                "6912345678",
//                Gender.MALE,
//                LocalDate.now(),
//                "olimpiados",
//                "asdasd");
//
//        pdao.addPatient(patient);

//        System.out.println(PatientServices.loginPatient("6212323684","29245678390"));

        FlatDarkPurpleIJTheme.setup();

        SwingUtilities.invokeLater(() -> {
            new DoctorDashBoard();
        });
    }
}
