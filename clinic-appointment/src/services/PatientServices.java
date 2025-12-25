package services;

import enums.LoginStatus;
import enums.RegisterStatus;
import Utils.Validations;
import dao.PatientDAO;
import entities.Patient;

public class PatientServices {

    private static PatientDAO pdao = new PatientDAO();

    public static RegisterStatus registerPatient(Patient patient){
        String patientAMKA = patient.getAmka();
        String patientPhone = patient.getPhoneNumber();
        boolean checkAMKA = Validations.validAMKA(patientAMKA);
        boolean checkPhone = Validations.validPhone(patientPhone);
        if(!checkAMKA){
            return RegisterStatus.WRONG_AMKA;
        }
        if(!checkPhone){
            return RegisterStatus.WRONG_PHONE;
        }
        pdao.addPatient(patient);
        return RegisterStatus.SUCCESSFULL;
    }

    public static LoginStatus loginPatient(String AMKA, String phone){
        Patient patient = pdao.findByAMKA(AMKA);
        if(patient==null){
            return LoginStatus.AMKA_NOT_FOUND;
        }
        if(!patient.getPhoneNumber().equals(phone)){
            return LoginStatus.PHONE_NOT_FOUND;
        }else{
            return LoginStatus.SUCCESSFULL;
        }
    }

    //updateinfos w validation
    //notification service
    //appointment confirmations




}
