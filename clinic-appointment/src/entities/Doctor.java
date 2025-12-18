package entities;

import java.util.ArrayList;

public class Doctor extends Person{
    private String sector; // Τομεας
    private ArrayList<Patient> patient; // Ασθενεις ( ενας γιατρος μπορει να εχει πανω απο 1 ασθενη )

    public Doctor(String firstName, String lastName, String phoneNumber, String sector, Patient patient){
        super(firstName, lastName, phoneNumber);
        this.sector = sector;
        this.patient = new ArrayList<Patient>();
    }


    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public ArrayList<Patient> getPatient() {
        return patient;
    }

    public void setPatient(ArrayList<Patient> patient) {
        this.patient = patient;
    }
}
