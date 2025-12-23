package entities;

import enums.Gender;

import java.time.LocalDate;

public class Patient extends Person {

    private int id; // Βάζω id για getter/setter ώστε να δημιουργηθεί μόνο του στην addPatient
    private String fathersName;
    private String amka;
    private String emergencyCall;
    private Gender gender;
    private LocalDate dateofbirth;
    private String address;
    private String notes;

    // Κενός constructor για να μπορέσω να αναζητήσω ασθενή με βάση το id στο DAO
    public Patient() {}

    // Constructor με παραμέτρους
    public Patient(String firstName, String lastName, String phoneNumber,
                   String fathersName, String amka, String emergencyCall, Gender gender, LocalDate dateofbirth,
                   String address, String notes) {
        super(firstName, lastName, phoneNumber);
        this.fathersName = fathersName;
        this.amka = amka;
        this.emergencyCall = emergencyCall;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.notes = notes;
    }

    // Getters και Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
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

    // toString για ομοιομορφη εμφάνιση αποτελεσμάτων
    @Override
    public String toString() {
        return "Patient{" + "\n" +
                "First Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() + "\n" +
                "Father's Name: " + getFathersName() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "AMKA: " + getAmka() + "\n" +
                "Emergency Call: " + getEmergencyCall() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Notes: " + getNotes() + "\n" +
                "}" + "\n" +
                "----------------------------------------------" + "\n";
    }


}
