package Entities;

import java.util.ArrayList;

public class Patient extends Person {
    private ArrayList<Prescription> prescriptions;
    private ArrayList<Appointment> appointmentList;

    public Patient(String name, String surname, String id, String phone, String address, Boolean gender, String bloodType, String password, String email) {
        super(name, surname, id, phone, address, gender, bloodType, password, email);

        prescriptions = new ArrayList<>();
        appointmentList = new ArrayList<>();
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void addAppointment(Appointment appointment){
        this.appointmentList.add(appointment);
    }

    public String toString(){
        return String.format("%s %s %s %s %s %s %s %s %s", getName(), getSurname(), getId(),
                getPhone(), getAddress(), getGender() ? "F" : "M", getBloodType(), getPassword(), getEmail());
    }

    public void addPrescription(Prescription prescription){
        prescriptions.add(prescription);
    }

}
