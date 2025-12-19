import dao.PatientDAO;
import databaseManager.DataBaseConnect;
import databaseManager.initializeTable;
import entities.Patient;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println(DataBaseConnect.getConnection());
        //initializeTable.createTables();

        //Test addPatient
        PatientDAO pdao=new PatientDAO();
        //Patient patient=new Patient("Xarhs","Makridhs","6912345678","Anesths","123456789011","6912345677","Anthokipwn 36","Problhma sthn kardia"); NULL ID


        //Patient patient=new Patient("Nikos","Kalantas","6912343678","Kwstas","123456689011","6982345677","Anthokipwn 36","Problhma sthn kardia");
        //pdao.addPatient(patient);
        //Patient patient=new Patient("Xrhstos","Papadopoulos","6912343674","Kwstas","123453689011","6902345677","Anthokipwn 36","Problhma sthn kardia");
        //pdao.addPatient(patient);
        Patient patient=new Patient("Makhs","Papadopoulos","6212343634","Xrhstos","19245678900","9902345672","Anthokipwn 36","Problhma sthn kardia");
        pdao.addPatient(patient);
    }
}