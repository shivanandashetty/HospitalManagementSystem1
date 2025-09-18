package controller;
//
//package com.hospital.management.controller;
//
//import com.hospital.management.dao.AppointmentDAO;
//import com.hospital.management.model.Appointment;
//import com.hospital.management.view.AppointmentView;

import java.util.List;

import dao.AppointmentDAO;
import model.Appointment;
import view.AppointmentView;

public class AppointmentController {
    private AppointmentDAO model;
    private AppointmentView view;

    public AppointmentController(AppointmentDAO model, AppointmentView view) {
        this.model = model;
        this.view = view;
    }

    public void addNewAppointment() {
        try {
            Appointment appointment = view.getAppointmentDetails();
            boolean success = model.addAppointment(appointment);
            if (success) {
                view.displayMessage("Appointment added successfully.");
            } else {
                view.displayMessage("Failed to add appointment.");
            }
        } catch (Exception e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    public void showAllAppointments() {
        List<Appointment> appointments = model.getAllAppointments();
        view.displayAppointments(appointments);
    }
}
