package dao;
//
//package com.hospital.management.dao;
//
//import com.hospital.management.model.Billing;
//import com.hospital.management.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Billing;
import utils.DatabaseConnection;

public class BillingDAO {
    private static final String INSERT_SQL = "INSERT INTO billing (patient_id, amount, billing_date, status) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM billing";

    public boolean addBillingRecord(Billing billing) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setInt(1, billing.getPatientId());
            stmt.setDouble(2, billing.getAmount());
            stmt.setDate(3, new java.sql.Date(billing.getBillingDate().getTime()));
            stmt.setString(4, billing.getStatus());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Billing> getAllBillingRecords() {
        List<Billing> billingRecords = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {

            while (rs.next()) {
                Billing billing = new Billing();
                billing.setBillId(rs.getInt("bill_id"));
                billing.setPatientId(rs.getInt("patient_id"));
                billing.setAmount(rs.getDouble("amount"));
                billing.setBillingDate(rs.getDate("billing_date"));
                billing.setStatus(rs.getString("status"));
                billingRecords.add(billing);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return billingRecords;
    }
}

