package controller;


import java.util.List;

import dao.InventoryDAO;
import model.InventoryItem;
import view.InventoryView;

public class InventoryController {
    private InventoryDAO model;
    private InventoryView view;

    public InventoryController(InventoryDAO model, InventoryView view) {
        this.model = model;
        this.view = view;
    }

    public void addNewInventoryItem() {
        InventoryItem item = view.getInventoryItemDetails();
        boolean success = model.addInventoryItem(item);
        if (success) {
            view.displayMessage("Inventory item added successfully.");
        } else {
            view.displayMessage("Failed to add inventory item.");
        }
    }

    public void showAllInventoryItems() {
        List<InventoryItem> items = model.getAllInventoryItems();
        view.displayInventoryItems(items);
    }
}

