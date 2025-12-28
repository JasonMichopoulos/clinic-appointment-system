package services;

import Utils.Validations;
import dao.DoctorDAO;
import entities.Doctor;
import enums.ServiceEnum;

import java.security.Provider;

public class DoctorServices {
    private static DoctorDAO ddao=new DoctorDAO();

    public static String registerDoctor(Doctor doctor){
        String doctorLastName=doctor.getLastName();
        String doctorSector=doctor.getSector();
        boolean checklastName=Validations.validLastName(doctorLastName);
        boolean checksector=Validations.validSector(doctorSector);

        if(!checklastName){
            return ServiceEnum.FAILED.getDesc();
        }

        if(!checksector){
            return ServiceEnum.FAILED.getDesc();
        }
        ddao.addDoctor(doctor);
        return ServiceEnum.SUCCESSFULL.getDesc();
    }

    public static String logInDoctor(String lastName,String sector){
        Doctor doctor= (Doctor) ddao.findBySector(sector);
        if(doctor==null){
            return ServiceEnum.FAILED.getDesc();
        }

        if(!doctor.getLastName().equalsIgnoreCase(lastName) && !doctor.getSector().equalsIgnoreCase(sector)){
            return ServiceEnum.FAILED.getDesc();
        }else{
            return ServiceEnum.SUCCESSFULL.getDesc()+" "+"Welcome: "+lastName+", "+sector;
        }
    }

    public ServiceEnum updateDoctor(Doctor doctor,int id){
        boolean foundDoctor=ddao.updateDoctorById(doctor,doctor.getId());
        

    }



}
