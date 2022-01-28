package Management;

import Entities.*;
import Swing.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class HospitalManagementSystem {

    public final String appointmentPath = "C:\\Users\\ikrhn\\IdeaProjects\\OOAD\\src\\appointments.txt";
    public final String doctorsPath = "C:\\Users\\ikrhn\\IdeaProjects\\OOAD\\src\\doctors.txt";
    public final String patientsPath = "C:\\Users\\ikrhn\\IdeaProjects\\OOAD\\src\\patientList.txt";
    public final String medicinesPath = "C:\\Users\\ikrhn\\IdeaProjects\\OOAD\\src\\medicines.txt";
    public final String prescriptionsPath = "C:\\Users\\ikrhn\\IdeaProjects\\OOAD\\src\\prescription.txt";

    private Hospital hospital;

    private Admin admin;

    private ArrayList<Doctor> jobApplicants;

    public static int currentDay, currentMonth;

    public EnterScreen enterScreen;
    public AdminScreen adminScreen;
    public DoctorScreen doctorScreen;
    public EditProfile editProfileScreen;
    public LogIn loginScreen;
    public MakeAnAppointment appointmentScreen;
    public NewAccount signUpScreen;
    public PatientScreen patientScreen;

    public HospitalManagementSystem() throws IOException {
        LocalDate d = java.time.LocalDate.now();
        currentDay = d.getDayOfMonth();
        currentMonth = d.getMonth().getValue();

        hospital = new Hospital("BIA Hospital", "1234567890");
        Hashtable<String, Doctor> doctors = FileOperations.readDoctorsList(doctorsPath);
        Hashtable<String, Patient> patients = FileOperations.readPatientList(patientsPath);
        hospital.setDoctorList(doctors);
        hospital.setPatientList(patients);
        FileOperations.readAppointments(hospital.getPatientList(), hospital.getDoctorList(), appointmentPath);
        hospital.setMedicineList(FileOperations.readMedicineList(medicinesPath));
        FileOperations.readPrescriptions(hospital.getPatientList(), prescriptionsPath);

        admin = new Admin("BIA", "Hospital", "00000000000", "0000000000", "BIA Street", false, "A+", "bia", "bia@BIAMail.com");

        jobApplicants = new ArrayList<>();

        enterScreen = new EnterScreen(this);
        enterScreen.setVisible(true);

    }

    public ArrayList<String> getMedicines(){
        return hospital.getMedicineList();
    }

    public Hashtable<String, Patient> getPatients(){
        return hospital.getPatientList();
    }

    public Hashtable<String, Doctor> getDoctors(){
        return hospital.getDoctorList();
    }

    public Admin getAdmin() {
        return admin;
    }

    public void register(Patient newPatient){
        hospital.registerPatient(newPatient);
    }

    public void addJobApplicant(Doctor d){
        jobApplicants.add(d);
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public ArrayList<Doctor> getJobApplicants() {
        return jobApplicants;
    }

    public static void main(String[] args) throws Exception {
        new HospitalManagementSystem();
    }
}
