package view;


import java.util.List;
import java.util.Scanner;

import model.Billing;

public class BillingView {
    private Scanner scanner = new Scanner(System.in);

    public Billing getBillingDetails() throws Exception {
        System.out.println("Enter Patient ID:");
        int patientId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Amount:");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter Billing Date (yyyy-MM-dd):");
        String dateStr = scanner.nextLine();

        System.out.println("Enter Status (Paid/Unpaid):");
        String status = scanner.nextLine();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date billingDate = sdf.parse(dateStr);

        return new Billing(patientId, amount, billingDate, status);
    }

    public void displayBillingRecords(List<Billing> records) {
        System.out.println("\n--- Billing Records ---");
        for (Billing b : records) {
            System.out.printf("Bill ID: %d, Patient ID: %d, Amount: %.2f, Date: %s, Status: %s\n",
                    b.getBillId(), b.getPatientId(), b.getAmount(), b.getBillingDate(), b.getStatus());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

