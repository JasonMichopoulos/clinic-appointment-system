import dao.PatientDAO;
import databaseManager.initializeTable;
import entities.Patient;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //System.out.println(DataBaseConnect.getConnection());
        initializeTable.createTables();

        //Test addPatient
        PatientDAO pdao=new PatientDAO();
        List<Patient> patientList=pdao.findAll();


        //Patient patient=new Patient("Xarhs","Makridhs","6912345678","Anesths","123456789011","6912345677","Anthokipwn 36","Problhma sthn kardia"); NULL ID


//        Patient patient=new Patient("Nikos","Kalantas","6912343678","Kwstas","123456689011","6982345677","Anthokipwn 36","Problhma sthn kardia");
//        pdao.addPatient(patient);
//        Patient patient2=new Patient("Xrhstos","Papadopoulos","6912343674","Kwstas","123453689011","6902345677","Anthokipwn 36","Problhma sthn kardia");
//        pdao.addPatient(patient2);
//        Patient patient3=new Patient("Makhs","Papadopoulos","6212323664","Xrhstos","19245678990","9902345672","Anthokipwn 36","Problhma sthn kardia");
//        pdao.addPatient(patient3);
//        Patient patient4 =new Patient("Nikos","Xrhstou","6212323684","Xrhstos","29245678390","9902325372","Anthokipwn 36","Problhma sthn kardia");
//        pdao.addPatient(patient4);

        //Test deleteById
        //pdao.deleteById(4);
        //System.out.println("Done");

        //Test deleteByAMKA
        //pdao.deleteByAMKA("29245678390");

        //Test findById
        //System.out.println(pdao.findById(4));

        //Test find by amka
        //System.out.println(pdao.findByAMKA("29245678390"));

        //Test findAll
        for(Patient patient: patientList){
            System.out.println(patient);
        }




    }
}