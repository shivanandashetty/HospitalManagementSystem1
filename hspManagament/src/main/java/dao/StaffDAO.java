package dao;
//
//package com.hospital.management.dao;
//
//import com.hospital.management.model.Staff;
//import com.hospital.management.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Staff;
import utils.DatabaseConnection;

public class StaffDAO {
    private static final String INSERT_SQL = "INSERT INTO staff (first_name, last_name, role, phone, email) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM staff";

    public boolean addStaff(Staff staff) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, staff.getFirstName());
            stmt.setString(2, staff.getLastName());
            stmt.setString(3, staff.getRole());
            stmt.setString(4, staff.getPhone());
            stmt.setString(5, staff.getEmail());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {

            while (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getInt("staff_id"));
                staff.setFirstName(rs.getString("first_name"));
                staff.setLastName(rs.getString("last_name"));
                staff.setRole(rs.getString("role"));
                staff.setPhone(rs.getString("phone"));
                staff.setEmail(rs.getString("email"));
                staffList.add(staff);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;
    }
}

