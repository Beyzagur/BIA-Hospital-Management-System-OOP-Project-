package Entities;

import java.util.ArrayList;

public class Prescription {
    private String doctor;
    private String department;
    private Patient patient;
    private String day;
    private String month;
    private String hour;
    private ArrayList<String> medicineList;

    public Prescription(String doctor, String department, Patient patient, String day, String month, String hour, ArrayList<String> prescription) {
        this.doctor = doctor;
        this.department = department;
        this.patient = patient;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.medicineList = prescription;
    }

    public String toString(){
        String medicines = "";
        for (int i = 0; i < medicineList.size(); i++) {
            medicines += medicineList.get(i);
            if (i + 1 == medicineList.size())
                medicines +=",";
        }

        return String.format("%s=%s=%s=%s=%s.%s.2021=%s", medicines, patient.getId(),
                doctor, department, day, month, hour);
    }

    public String getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDay() {
        return day;
    }

    public String getDepartment() {
        return department;
    }

    public String getMonth() {
        return month;
    }

    public String getHour() {
        return hour;
    }

    public ArrayList<String> getMedicineList() {
        return medicineList;
    }
}
