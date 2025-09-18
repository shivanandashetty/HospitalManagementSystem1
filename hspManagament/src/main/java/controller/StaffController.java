package controller;


import java.util.List;

import dao.StaffDAO;
import model.Staff;
import view.StaffView;

public class StaffController {
    private StaffDAO model;
    private StaffView view;

    public StaffController(StaffDAO model, StaffView view) {
        this.model = model;
        this.view = view;
    }

    public void addNewStaff() {
        Staff staff = view.getStaffDetails();
        boolean success = model.addStaff(staff);
        if (success) {
            view.displayMessage("Staff added successfully.");
        } else {
            view.displayMessage("Failed to add staff.");
        }
    }

    public void showAllStaff() {
        List<Staff> staffList = model.getAllStaff();
        view.displayStaffList(staffList);
    }
}

