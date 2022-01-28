package Entities;

public class Appointment {
    private String nameSurname;
    private boolean appointmentType; // true: normal, false: vaccine
    private String patientID;
    private Doctor doctor;
    private String appointmentDate;
    private String appointmentTime;
    private final Departments department;

    public Appointment(String nameSurname, boolean appointmentType, String patientID, Doctor doctor, String appointmentDate,
                       String appointmentTime, String department) {
        this.nameSurname = nameSurname;
        this.appointmentType = appointmentType;
        this.patientID = patientID;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.department = Departments.valueOf(department);
    }

    public String toString(){
        return String.format("%s %s %s %s %s", appointmentType ? "normal" : "vaccine",
                patientID, doctor.getId(), appointmentDate, appointmentTime);
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public boolean isAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(boolean appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Departments getDepartment() {
        return department;
    }

    public void displayAppointment(){

    }
}