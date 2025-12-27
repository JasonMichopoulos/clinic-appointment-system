package services;

import enums.LoginStatus;
import enums.RegisterStatus;
import Utils.Validations;
import dao.PatientDAO;
import entities.Patient;
import enums.ServiceEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
<<<<<<< Updated upstream
=======

    public ServiceEnum updatePatient(Patient patient){
        Patient existingPatient=pdao.findById(patient.getId());

        if(!Validations.validAMKA(patient.getAmka())){
            return ServiceEnum.WRONG_AMKA;
        }

        if(!Validations.validPhone(patient.getPhoneNumber())){
            return ServiceEnum.WRONG_PHONE;
        }

        if(patient.getDateofbirth().isAfter(LocalDate.now())){
            return ServiceEnum.INVALID_DATE_OF_BIRTH;
        }

        boolean success=pdao.updatePatientById(patient,patient.getId());

        if(success){
            return ServiceEnum.SUCCESSFULL;
        }else{
            return ServiceEnum.FAILED;
        }
    }

    public ServiceEnum deletePatientbyId(int id){
        Patient patient=pdao.findById(id);
        if(patient==null){
            return ServiceEnum.FAILED;
        }

        boolean success=pdao.deleteById(patient.getId());

        if(success){
            return ServiceEnum.SUCCESSFULL;
        }else{
            return ServiceEnum.FAILED;
        }
    }

    public ServiceEnum deletePatientByAMKA(String amka){
        Patient patient=pdao.findByAMKA(amka);
        if(patient==null){
            return ServiceEnum.FAILED;
        }

        boolean success=pdao.deleteByAMKA(patient.getAmka());
        if(success){
            return ServiceEnum.SUCCESSFULL;
        }else{
            return ServiceEnum.FAILED;
        }
    }

    public Patient getPatientById(int id){
        Patient patient=pdao.findById(id);

        if(patient==null){
            return null;
        }
        Patient foundPatient=pdao.findById(patient.getId());

        if(foundPatient!=null){
            return patient;
        }else{
            return null;
        }
    }

    public Patient getPatientByAMKA(String amka){
        Patient patient=pdao.findByAMKA(amka);
        if(patient==null){
            return null;
        }

        Patient foundPatient=pdao.findByAMKA(patient.getAmka());
        if(foundPatient!=null){
            return foundPatient;
        }else{
            return null;
        }
    }

    public List<Patient> patientList(){
        return pdao.findAll();
    }

    public List<Patient> searchPatients(String keyword){//αναζητηση ασθενη με βαση μια λεξη κλειδι
        List<Patient> allPatients=new ArrayList<>();
        if(keyword.isEmpty() || keyword==null){
            return allPatients;//επιστρεφει κενη λιστα αν δεν υπαρχει λεξη κλειδι
        }
        List<Patient> result=new ArrayList<>();

        allPatients.addAll(pdao.findAll());
        for(Patient p:allPatients)
            if (p.getFirstName().contains(keyword) || p.getLastName().contains(keyword) || p.getFathersName().contains(keyword) || p.getAddress().contains(keyword) || p.getNotes().contains(keyword))//αναζηταει αναμεσα σε ονομα επιθετο ονομα πατρος διευθυνση και σημειωσεις
                result.add(p);
        return result;






    }




    
}
