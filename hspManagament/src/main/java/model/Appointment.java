package model;


import java.util.Date;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int staffId;
    private Date appointmentDate;
    private String status;  // e.g., Scheduled, Completed, Cancelled

    public Appointment() {}

    public Appointment(int patientId, int staffId, Date appointmentDate, String status) {
        this.patientId = patientId;
        this.staffId = staffId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    // Getters and setters

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
