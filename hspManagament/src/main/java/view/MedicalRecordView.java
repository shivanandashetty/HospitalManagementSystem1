package view;


import java.util.List;
import java.util.Scanner;

import model.MedicalRecord;

public class MedicalRecordView {
    private Scanner scanner = new Scanner(System.in);

    public MedicalRecord getMedicalRecordDetails() throws Exception {
        System.out.println("Enter Patient ID:");
        int patientId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Diagnosis:");
        String diagnosis = scanner.nextLine();

        System.out.println("Enter Treatment:");
        String treatment = scanner.nextLine();

        System.out.println("Enter Record Date (yyyy-MM-dd):");
        String dateStr = scanner.nextLine();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date recordDate = sdf.parse(dateStr);

        return new MedicalRecord(patientId, diagnosis, treatment, recordDate);
    }

    public void displayMedicalRecords(List<MedicalRecord> records) {
        System.out.println("\n--- Medical Records ---");
        for (MedicalRecord r : records) {
            System.out.printf("ID: %d, Patient ID: %d, Diagnosis: %s, Treatment: %s, Date: %s\n",
                    r.getRecordId(), r.getPatientId(), r.getDiagnosis(), r.getTreatment(), r.getRecordDate());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

