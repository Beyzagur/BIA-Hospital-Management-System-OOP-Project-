package Entities;

import java.util.*;

public class Hospital {
    private final String name;
    private String phone;
    private Hashtable<String,Patient> patientList;
    private Hashtable<String,Doctor> doctorList;
    private ArrayList<String> medicineList;

    public Hospital(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public Hashtable<String, Patient> getPatientList() {
        return patientList;
    }

    public Hashtable<String, Doctor> getDoctorList() {
        return doctorList;
    }

    public void setMedicineList(ArrayList<String> medicineList) {
        this.medicineList = medicineList;
    }

    public ArrayList<String> getMedicineList() {
        return medicineList;
    }

    public void setDoctorList(Hashtable<String, Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public void setPatientList(Hashtable<String, Patient> patientList) {
        this.patientList = patientList;
    }

    public void registerPatient(Patient newPatient){
        patientList.put(newPatient.getId(), newPatient);
    }


}
