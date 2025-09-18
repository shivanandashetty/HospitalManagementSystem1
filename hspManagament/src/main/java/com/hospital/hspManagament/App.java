package com.hospital.hspManagament;

import controller.AppointmentController;
import controller.BillingController;
import controller.InventoryController;
import controller.MedicalRecordController;
import controller.PatientController;
import controller.StaffController;
import dao.AppointmentDAO;
import dao.BillingDAO;
import dao.InventoryDAO;
import dao.MedicalRecordDAO;
import dao.PatientDAO;
import dao.StaffDAO;
import view.AppointmentView;
import view.BillingView;
import view.InventoryView;
import view.MedicalRecordView;
import view.PatientView;
import view.StaffView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	PatientDAO patientDAO = new PatientDAO();
        PatientView patientView = new PatientView();
        PatientController patientController = new PatientController(patientDAO, patientView);
        
        patientController.addNewPatient();
        patientController.showAllPatients();
        
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        AppointmentView appointmentView = new AppointmentView();
        AppointmentController appointmentController = new AppointmentController(appointmentDAO, appointmentView);
        
        appointmentController.addNewAppointment();
        appointmentController.showAllAppointments();
        
        MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
        MedicalRecordView medicalRecordView = new MedicalRecordView();
        MedicalRecordController medicalRecordController = new MedicalRecordController(medicalRecordDAO, medicalRecordView);

        medicalRecordController.addNewMedicalRecord();
        medicalRecordController.showAllMedicalRecords();
        
        BillingDAO billingDAO = new BillingDAO();
        BillingView billingView = new BillingView();
        BillingController billingController = new BillingController(billingDAO, billingView);

        billingController.addNewBillingRecord();
        billingController.showAllBillingRecords();
        
        InventoryDAO inventoryDAO = new InventoryDAO();
        InventoryView inventoryView = new InventoryView();
        InventoryController inventoryController = new InventoryController(inventoryDAO, inventoryView);

        inventoryController.addNewInventoryItem();
        inventoryController.showAllInventoryItems();
        
        StaffDAO staffDAO = new StaffDAO();
        StaffView staffView = new StaffView();
        StaffController staffController = new StaffController(staffDAO, staffView);

        staffController.addNewStaff();
        staffController.showAllStaff();
        
    }
}
