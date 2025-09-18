package model;


import java.util.Date;

public class Billing {
    private int billId;
    private int patientId;
    private double amount;
    private Date billingDate;
    private String status;  // e.g., Paid, Unpaid

    public Billing() {}

    public Billing(int patientId, double amount, Date billingDate, String status) {
        this.patientId = patientId;
        this.amount = amount;
        this.billingDate = billingDate;
        this.status = status;
    }

    // Getters and setters

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

