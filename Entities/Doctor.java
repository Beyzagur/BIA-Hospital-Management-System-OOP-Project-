package Entities;

import java.util.ArrayList;

public class Doctor extends Person {
    private final String title;
    private final Departments department;
    private final ArrayList<Appointment> appointments;

    public Doctor(String name, String surname, String id, String phone, String address, Boolean gender, String bloodType, String password, String email, String title, String department) {
        super(name, surname, id, phone, address, gender, bloodType, password, email);
        this.title = title;
        this.department = Departments.valueOf(department);
        this.appointments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public Departments getDepartment() {
        return department;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment a){
        appointments.add(a);
    }

    public String toString(){
        return String.format("%s %s %s %s %s %s %s %s %s %s %s", getTitle(), getName(), getSurname(), getId(),
                getPhone(), getAddress(), getGender() ? "F" : "M", getBloodType(), getPassword(), getEmail(), getDepartment());
    }

}
