package services;

import enums.LoginStatus;
import enums.RegisterStatus;
import Utils.Validations;
import dao.PatientDAO;
import entities.Patient;

public class PatientServices {

    private static PatientDAO pdao = new PatientDAO();

    public static String registerPatient(Patient patient){
        String patientAMKA = patient.getAmka();
        String patientPhone = patient.getPhoneNumber();
        boolean checkAMKA = Validations.validAMKA(patientAMKA);
        boolean checkPhone = Validations.validPhone(patientPhone);
        if(!checkAMKA){
            return RegisterStatus.WRONG_AMKA.getDesc();
        }
        if(!checkPhone){
            return RegisterStatus.WRONG_PHONE.getDesc();
        }
        pdao.addPatient(patient);
        return RegisterStatus.SUCCESSFULL.getDesc();
    }

    public static String loginPatient(String phone, String AMKA){
        Patient patient = pdao.findByAMKA(AMKA);
        if(patient==null){
            return LoginStatus.AMKA_NOT_FOUND.getDesc();
        }
        if(!patient.getPhoneNumber().equals(phone)){
            return LoginStatus.PHONE_NOT_FOUND.getDesc();
        }else{
            return LoginStatus.SUCCESSFULL.getDesc() + " amka: " + AMKA;
        }
    }
}
