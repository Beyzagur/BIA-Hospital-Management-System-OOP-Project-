package Management;

import Entities.*;

import java.io.*;
import java.util.*;

public class FileOperations {

    private static String doctor, patient, appointment;

    private static Scanner readFile(String filePath){
        File inputFile = new File(filePath);

        try {
            return new Scanner(inputFile);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public static Hashtable<String, Doctor> readDoctorsList(String filePath){
        Scanner scanner = readFile(filePath);

        Hashtable<String, Doctor> doctors = new Hashtable<>(30);

        if (scanner != null)
            doctor = scanner.nextLine();

        while (scanner != null && scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(" ");

            if (data.length <= 1)
                break;

            Doctor d = new Doctor(data[1], data[2], data[3], data[4], data[5], data[6].equals("F"), data[7], data[8], data[9], data[0], data[10]);
            doctors.put(data[3], d);
        }

        return doctors;
    }

    public static Hashtable<String, Patient> readPatientList(String filePath){
        Scanner scanner = readFile(filePath);

        Hashtable<String, Patient> patients = new Hashtable<>(30);

        if (scanner != null)
            patient = scanner.nextLine();

        while (scanner != null && scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(" ");

            if (data.length <= 1)
                break;

            Patient p = new Patient(data[0], data[1], data[2], data[3], data[4], data[5].equals("F"), data[6], data[7], data[8]);
            patients.put(data[2], p);
        }

        return patients;
    }

    public static ArrayList<String> readMedicineList(String filePath){
        Scanner scanner = readFile(filePath);

        ArrayList<String> medicines = new ArrayList<>();

        while (scanner != null && scanner.hasNextLine()){
            String data = scanner.nextLine();
            medicines.add(data);
        }

        return medicines;
    }

    public static void writePatients(Hashtable<String, Patient> patients, String filePath) throws IOException {
        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(patient + "\n");

        for (Patient patient : patients.values())
            writer.write(patient.toString() + "\n");

        writer.flush();
        writer.close();
    }

    public static void writeDoctors(Hashtable<String, Doctor> doctors, String filePath) throws IOException {
        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(doctor + "\n");

        for (Doctor doctor : doctors.values())
            writer.write(doctor.toString() + "\n");

        writer.flush();
        writer.close();
    }

    public static void readAppointments(Hashtable<String, Patient> patients, Hashtable<String, Doctor> doctors, String filePath){
        Scanner scanner = readFile(filePath);

        if (scanner == null)
            return;

        appointment = scanner.nextLine();

        while (scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(" ");

            if (data.length <= 1)
                break;

            Patient patient = patients.get(data[1]);
            Doctor doctor = doctors.get(data[2]);

            Appointment appointment = new Appointment(patient.getName() + " "  + patient.getSurname(),
                    data[0].equals("normal"), data[1], doctor, data[3], data[4], doctor.getDepartment().name());
            patient.addAppointment(appointment);
            doctor.addAppointment(appointment);
        }
    }

    public static void writeAppointments(ArrayList<Appointment> appointments, String filePath) throws IOException {
        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(appointment + "\n");

        for (Appointment a : appointments) {
            writer.write(a.toString() + "\n");
        }

        writer.flush();
        writer.close();
    }


    public static void writePrescriptions(Hashtable<String, Patient> patients, String filePath) throws IOException{

        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for (Patient p : patients.values()) {
            for (Prescription o : p.getPrescriptions())
                writer.write(o.toString() + "\n");
        }

        writer.flush();
        writer.close();
    }

    public static void readPrescriptions(Hashtable<String, Patient> patients, String filePath) throws IOException{
        Scanner scanner = readFile(filePath);

        while (scanner.hasNextLine()){
            String[] data = scanner.nextLine().split("=");

            if (data.length <= 1)
                break;

            ArrayList<String> medicines = new ArrayList<>();
            String[] m = data[0].split(",");

            for (int i = 0; i < m.length; i++)
                medicines.add(m[i]);

            Prescription p = new Prescription(data[2], data[3], patients.get(data[1]),
                    data[4].substring(0,2), data[4].substring(3, 5), data[5], medicines);

            patients.get(data[1]).addPrescription(p);
        }
    }

    //a 10mg,b 5mg=hastaid=doctorid=department="16.06.2021=13.00"

}
