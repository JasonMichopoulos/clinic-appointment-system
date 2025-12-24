package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private int id;
    private LocalDateTime start_date; // Εναρξη ραντεβου
    private LocalDateTime end_date;   // Ληξη ραντεβου
    private Doctor doctor;            // Ο γιατρος
    private Patient patient;          // Ο ασθενης
    private int is_done;

    public Appointment(){};


    // Constructor
    public Appointment(
            LocalDateTime start_date,
            LocalDateTime end_date,
            Doctor doctor,
            Patient patient,
            int is_done
    ) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.doctor = doctor;
        this.patient = patient;
        this.is_done=0;
    }

    // Getters - Setters


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getIs_done() {return is_done;}

    public void setIs_done(int is_done) {this.is_done = is_done;}

    @Override
    public String toString() {
        String patientName = (patient != null) ? patient.getFirstName() + " " + patient.getLastName() : "N/A";
        String doctorName = (doctor != null) ? doctor.getFirstName() + " " + doctor.getLastName() : "N/A";

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String start = (start_date != null) ? start_date.format(formatter) : "N/A";
        String end = (end_date != null) ? end_date.format(formatter) : "N/A";

        return "Appointment{" + "\n" +
                "ID: " + id + "\n" +
                "Patient: " + patientName + "\n" +
                "Doctor: " + doctorName + "\n" +
                "Start Date: " + start + "\n" +
                "End Date: " + end + "\n" +
                "Done: " + (is_done == 1 ? "Yes" : "No") + "\n" +
                "}" + "\n" +
                "----------------------------------------------" + "\n";
    }

}
