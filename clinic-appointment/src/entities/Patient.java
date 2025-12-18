package entities;

public class Patient extends Person{
    private String fathersName;
    private String amka;
    private String emergencyCall;
    private String address;
    private String notes;


    public Patient(String firstName, String lastName, String fathersName, String amka, String phoneNumber, String emergencyCall, String address, String notes){
        super(firstName, lastName, phoneNumber);
        this.fathersName = fathersName;
        this.amka = amka;
        this.emergencyCall = emergencyCall;
        this.address = address;
        this.notes = notes;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getEmergencyCall() {
        return emergencyCall;
    }

    public void setEmergencyCall(String emergencyCall) {
        this.emergencyCall = emergencyCall;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
