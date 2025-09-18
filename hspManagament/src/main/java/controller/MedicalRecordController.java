package controller;
//
//package com.hospital.management.controller;
//
//import com.hospital.management.dao.MedicalRecordDAO;
//import com.hospital.management.model.MedicalRecord;
//import com.hospital.management.view.MedicalRecordView;

import java.util.List;

import dao.MedicalRecordDAO;
import model.MedicalRecord;
import view.MedicalRecordView;

public class MedicalRecordController {
    private MedicalRecordDAO model;
    private MedicalRecordView view;

    public MedicalRecordController(MedicalRecordDAO model, MedicalRecordView view) {
        this.model = model;
        this.view = view;
    }

    public void addNewMedicalRecord() {
        try {
            MedicalRecord record = view.getMedicalRecordDetails();
            boolean success = model.addMedicalRecord(record);
            if (success) {
                view.displayMessage("Medical record added successfully.");
            } else {
                view.displayMessage("Failed to add medical record.");
            }
        } catch (Exception e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    public void showAllMedicalRecords() {
        List<MedicalRecord> records = model.getAllMedicalRecords();
        view.displayMedicalRecords(records);
    }
}

