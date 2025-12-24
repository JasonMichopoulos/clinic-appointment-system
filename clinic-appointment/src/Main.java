import dao.AppointmentDAO;
import dao.DoctorDAO;
import dao.PatientDAO;
import databaseManager.initializeTable;
import entities.Appointment;
import entities.Doctor;
import entities.Patient;
import enums.Gender;


import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Δημιουργία πινάκων στη βάση
        //initializeTable.createTables();

        PatientDAO pdao = new PatientDAO();
        DoctorDAO ddao = new DoctorDAO();
        AppointmentDAO adao=new AppointmentDAO();

        // --------------------------
        // Test addPatient
        // --------------------------
        // Παράδειγμα δημιουργίας ασθενών με null ID
//        Patient patient=new Patient("Giannhs","Papadopoulos","6912325278","Kwstas","12145678901","2909875543",Gender.MALE,LocalDate.of(1990,5,15),"Athens","provlhma sthn kardia");
//        pdao.addPatient(patient);


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
         //pdao.deleteAll();

        // --------------------------
        // Test addDoctor
        // --------------------------
//        Doctor doctor = new Doctor("Nikos", "Xrhstou", "133456789", "Kardiologos");
//        ddao.addDoctor(doctor);

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

        //pdao.addPatient(patient);

        //System.out.println(PatientServices.loginPatient("6212323684","29245678390"));

        //TEST addDoctor
        //Doctor doctor1= new Doctor("Kwstas", "Petroy", "123456189", "Pathologos");
        //ddao.addDoctor(doctor1);

//        List<Doctor> doctorList=ddao.findBySector("Kardiologos");
//        for(Doctor d:doctorList){
//            System.out.println(d);
//
//        }

        //Test findbyId
        //System.out.println(ddao.findById(1));
        //TEST findAll()
//        List<Doctor> doctorList=ddao.findAll();
//        for(Doctor d:doctorList){
//            System.out.println(d);
//        }

        //ddao.deleteAll();

//        //TEST addAppointment
//        Appointment appointment=new Appointment();
//        appointment.setPatient(patient);
//        appointment.setDoctor(doctor);
//        appointment.setStart_date(LocalDateTime.of(2025,1,20,10,0));
//        appointment.setEnd_date(LocalDateTime.of(2025, 1, 20, 10, 30));

//        appointment.setIs_done(0);
//        AppointmentDAO adao= new AppointmentDAO();
//        adao.addAppointment(appointment);

//        Patient patient = new Patient("Giannhs", "Papadopoulos", "6912325278", "Kwstas", "12145678901", "2909875543", Gender.MALE, LocalDate.of(1990,5,15), "Athens", "provlhma sthn kardia");
//        pdao.addPatient(patient);
//
//        Doctor doctor = new Doctor("Nikos", "Xrhstou", "123456789", "Kardiologos");
//        ddao.addDoctor(doctor);
//
//        Appointment appointment = new Appointment();
//        appointment.setPatient(patient);
//        appointment.setDoctor(doctor);
//        appointment.setStart_date(LocalDateTime.of(2025,1,20,10,0));
//        appointment.setEnd_date(LocalDateTime.of(2025,1,20,10,30));
//        appointment.setIs_done(0);
//        adao.addAppointment(appointment);

        Patient patient = new Patient(
                "Giannhs",              // firstName
                "Papadopoulos",         // lastName
                "6912325278",           // phoneNumber (UNIQUE!)
                "Kwstas",               // fathersName
                "12145678901",          // amka (UNIQUE!)
                "2909875543",           // emergencyCall
                Gender.MALE,            // gender
                LocalDate.of(1990,5,15), // dateofbirth
                "Athens",               // address
                "provlhma sthn kardia"  // notes
        );
        pdao.addPatient(patient);  // Σιγουρέψου ότι παίρνει το ID μετά το insert

        // --------------------------
        // Δημιουργία Doctor
        // --------------------------
        Doctor doctor = new Doctor(
                "Nikos",                // firstName
                "Xrhstou",              // lastName
                "123456789",            // phoneNumber (UNIQUE!)
                "Kardiologos"           // sector
        );
        ddao.addDoctor(doctor);      // Σιγουρέψου ότι παίρνει το ID μετά το insert

        // --------------------------
        // Δημιουργία Appointment
        // --------------------------
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStart_date(LocalDateTime.of(2025,1,20,10,0));
        appointment.setEnd_date(LocalDateTime.of(2025,1,20,10,30));
        appointment.setIs_done(0);

        // Προσθήκη Appointment στη βάση
        adao.addAppointment(appointment);

//        ddao.deleteAll();
//        pdao.deleteAll();








    }
}
