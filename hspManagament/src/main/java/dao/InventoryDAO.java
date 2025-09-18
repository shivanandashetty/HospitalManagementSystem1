package dao;
//
//package com.hospital.management.dao;
//
//import com.hospital.management.model.InventoryItem;
//import com.hospital.management.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.InventoryItem;
import utils.DatabaseConnection;

public class InventoryDAO {
    private static final String INSERT_SQL = "INSERT INTO inventory (supply_name, quantity, reorder_level) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM inventory";

    public boolean addInventoryItem(InventoryItem item) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, item.getSupplyName());
            stmt.setInt(2, item.getQuantity());
            stmt.setInt(3, item.getReorderLevel());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<InventoryItem> getAllInventoryItems() {
        List<InventoryItem> items = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL)) {

            while (rs.next()) {
                InventoryItem item = new InventoryItem();
                item.setSupplyId(rs.getInt("supply_id"));
                item.setSupplyName(rs.getString("supply_name"));
                item.setQuantity(rs.getInt("quantity"));
                item.setReorderLevel(rs.getInt("reorder_level"));
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}

