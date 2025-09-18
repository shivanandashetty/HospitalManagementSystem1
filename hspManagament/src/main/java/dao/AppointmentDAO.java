package dao;
//
//package com.hospital.management.dao;
//
//import com.hospital.management.model.Appointment;
//import com.hospital.management.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Appointment;
import utils.DatabaseConnection;

public class AppointmentDAO {
    private static final String INSERT_SQL = "INSERT INTO appointments (patient_id, staff_id, appointment_date, status) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM appointments";

    public boolean addAppointment(Appointment appointment) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getStaffId());
            stmt.setTimestamp(3, new Timestamp(appointment.getAppointmentDate().getTime()));
            stmt.setString(4, appointment.getStatus());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointment_id"));
                appointment.setPatientId(rs.getInt("patient_id"));
                appointment.setStaffId(rs.getInt("staff_id"));
                appointment.setAppointmentDate(rs.getTimestamp("appointment_date"));
                appointment.setStatus(rs.getString("status"));
                appointments.add(appointment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }
}
