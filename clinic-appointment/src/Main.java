//import for tables creation
import databaseManager.initializeTable;

//import for patients entities and DAO
import entities.Patient;
import dao.PatientDAO;

//import for Gender enum
import enums.Gender;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {

        //TEST for initializeTable()
        //initializeTable.createTables();
        //System.out.println("Done");


        //PatientDAO
        //Test for addPatient()
        PatientDAO patientDAO=new PatientDAO();
        Patient patient=new Patient("Giannhs","Papadopoulos","691234567","Kwnstantinos","12345678901","2310000000", Gender.MALE, LocalDate.of(1990,5,15),"Anthokipwn 36","Allergeia sto ntepon");
        patientDAO.addPatient(patient);
        System.out.println("Done");


    }
}
