package view;
//
//package com.hospital.management.view;
//
//import com.hospital.management.model.Patient;

import java.util.List;
import java.util.Scanner;

import model.Patient;

public class PatientView {
    private Scanner scanner = new Scanner(System.in);

    public Patient getPatientDetails() throws Exception {
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Date of Birth (yyyy-MM-dd):");
        String dobStr = scanner.nextLine();

        System.out.println("Enter Gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter Phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dob = sdf.parse(dobStr);
        java.util.Date regDate = new java.util.Date();

        return new Patient(firstName, lastName, dob, gender, phone, email, address, regDate);
    }

    public void displayPatients(List<Patient> patients) {
        System.out.println("\n--- Patient List ---");
        for (Patient p : patients) {
            System.out.printf("ID: %d, Name: %s %s, DOB: %s, Gender: %s, Phone: %s, Email: %s, Address: %s\n",
                    p.getPatientId(), p.getFirstName(), p.getLastName(), p.getDateOfBirth(), p.getGender(), p.getPhone(), p.getEmail(), p.getAddress());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

