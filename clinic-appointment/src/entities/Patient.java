package entities;

public class Patient extends Person{
    private int id;//βαζω id για getter setter ετσι ωστε να δημιουργηθει μονο του στην addPatient
    private String fathersName;
    private String amka;
    private String emergencyCall;
    private String address;
    private String notes;

    public Patient(){} // κενος constructor για να μπορεσω να αναζητησω ασθενη με βαση το id, στο dao

    public Patient(String firstName,String lastName,String phoneNumber,String fathersName,String amka,String emergencyCall,String address,String notes){//εβαλα παραμετρους στον constructor
        super(firstName, lastName, phoneNumber);
        this.fathersName = fathersName;
        this.amka = amka;
        this.emergencyCall = emergencyCall;
        this.address = address;
        this.notes = notes;
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

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

    //toString() ετσι ωστε να εμφανιζει ομοιομορφα τα αποτελεσματα
    @Override
    public String toString(){
        return "Patient{" +"\n"+
                "First Name: " + getFirstName()+"\n"+
                "Last Name: " +getLastName()+"\n"+
                "Father's Name: " +getFathersName()+"\n"+
                "Phone Number: " +getPhoneNumber()+"\n"+
                "AMKA: " +getAmka()+"\n"+
                "Emergency Call: " +getEmergencyCall()+"\n"+
                "Address: " +getAddress()+"\n"+
                "Notes: "+getNotes()+"\n"+
                "}"+"\n"+
                "----------------------------------------------"+"\n";
    }

}
