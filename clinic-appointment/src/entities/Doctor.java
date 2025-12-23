package entities;

import java.util.ArrayList;

public class Doctor extends Person {

    private int id; // Προσθετω id
    private String sector; // Τομεας
    private ArrayList<Patient> patients; // Ασθενεις (ένας γιατρός μπορεί να έχει πάνω από 1 ασθενή)

    public Doctor() {};

    public Doctor(String firstName, String lastName, String phoneNumber, String sector) {
        super(firstName, lastName, phoneNumber);
        this.sector = sector;
        this.patients = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public String toString(){
        return "Doctor{" +"\n"+
                "First Name: " +getFirstName()+"\n"+
                "Last Name: " +getLastName()+"\n"+
                "Phone Number: " +getPhoneNumber()+"\n"+
                "Sector: " +getSector()+"\n"+
                "}"+"\n"+
                "----------------------------------------------" + "\n";
    }



}
