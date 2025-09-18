package view;
//
//package com.hospital.management.view;
//
//import com.hospital.management.model.Appointment;

import java.util.List;
import java.util.Scanner;

import model.Appointment;

public class AppointmentView {
    private Scanner scanner = new Scanner(System.in);

    public Appointment getAppointmentDetails() throws Exception {
        System.out.println("Enter Patient ID:");
        int patientId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Staff ID:");
        int staffId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Appointment Date and Time (yyyy-MM-dd HH:mm:ss):");
        String dateTimeStr = scanner.nextLine();

        System.out.println("Enter Status (Scheduled/Completed/Cancelled):");
        String status = scanner.nextLine();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date appointmentDate = sdf.parse(dateTimeStr);

        return new Appointment(patientId, staffId, appointmentDate, status);
    }

    public void displayAppointments(List<Appointment> appointments) {
        System.out.println("\n--- Appointment List ---");
        for (Appointment a : appointments) {
            System.out.printf("ID: %d, Patient ID: %d, Staff ID: %d, Date: %s, Status: %s\n",
                    a.getAppointmentId(), a.getPatientId(), a.getStaffId(), a.getAppointmentDate(), a.getStatus());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
