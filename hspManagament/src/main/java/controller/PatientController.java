package controller;
//
//package com.hospital.management.controller;
//
//import com.hospital.management.dao.PatientDAO;
//import com.hospital.management.model.Patient;
//import com.hospital.management.view.PatientView;

import java.util.List;

import dao.PatientDAO;
import model.Patient;
import view.PatientView;

public class PatientController {
    private PatientDAO model;
    private PatientView view;

    public PatientController(PatientDAO model, PatientView view) {
        this.model = model;
        this.view = view;
    }

    public void addNewPatient() {
        try {
            Patient patient = view.getPatientDetails();
            boolean success = model.addPatient(patient);
            if (success) {
                view.displayMessage("Patient inserted successfully.");
            } else {
                view.displayMessage("Failed to insert patient.");
            }
        } catch (Exception e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    public void showAllPatients() {
        List<Patient> patients = model.getAllPatients();
        view.displayPatients(patients);
    }
}
