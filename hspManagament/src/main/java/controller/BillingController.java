package controller;


import java.util.List;

import dao.BillingDAO;
import model.Billing;
import view.BillingView;

public class BillingController {
    private BillingDAO model;
    private BillingView view;

    public BillingController(BillingDAO model, BillingView view) {
        this.model = model;
        this.view = view;
    }

    public void addNewBillingRecord() {
        try {
            Billing billing = view.getBillingDetails();
            boolean success = model.addBillingRecord(billing);
            if (success) {
                view.displayMessage("Billing record added successfully.");
            } else {
                view.displayMessage("Failed to add billing record.");
            }
        } catch (Exception e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    public void showAllBillingRecords() {
        List<Billing> records = model.getAllBillingRecords();
        view.displayBillingRecords(records);
    }
}

