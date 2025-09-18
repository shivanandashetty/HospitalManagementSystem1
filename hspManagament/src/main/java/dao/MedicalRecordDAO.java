package dao;
//
//package com.hospital.management.dao;
//
//import com.hospital.management.model.MedicalRecord;
//import com.hospital.management.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.MedicalRecord;
import utils.DatabaseConnection;

public class MedicalRecordDAO {
    private static final String INSERT_SQL = "INSERT INTO medical_records (patient_id, diagnosis, treatment, record_date) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM medical_records";

    public boolean addMedicalRecord(MedicalRecord record) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setInt(1, record.getPatientId());
            stmt.setString(2, record.getDiagnosis());
            stmt.setString(3, record.getTreatment());
            stmt.setDate(4, new java.sql.Date(record.getRecordDate().getTime()));

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        List<MedicalRecord> records = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {

            while (rs.next()) {
                MedicalRecord record = new MedicalRecord();
                record.setRecordId(rs.getInt("record_id"));
                record.setPatientId(rs.getInt("patient_id"));
                record.setDiagnosis(rs.getString("diagnosis"));
                record.setTreatment(rs.getString("treatment"));
                record.setRecordDate(rs.getDate("record_date"));
                records.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return records;
    }
}
