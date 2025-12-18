package entities;

import java.time.LocalDateTime;

public class Appointment {


    private LocalDateTime start_date; // Εναρξη ραντεβου
    private LocalDateTime end_date; // Ληξη ραντεβου
    private Doctor doctor; // Ο γιατρος
    private Patient patient; // Ο ασθενης
    //Constructor
    public Appointment(LocalDateTime start_date, LocalDateTime end_date, Doctor doctor, Patient patient){
        this.start_date = start_date;
        this.end_date = end_date;
        this.doctor = doctor;
        this.patient = patient;
    }

    //Getters - Setters
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
}
