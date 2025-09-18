package view;


import java.util.List;
import java.util.Scanner;

import model.InventoryItem;

public class InventoryView {
    private Scanner scanner = new Scanner(System.in);

    public InventoryItem getInventoryItemDetails() {
        System.out.println("Enter Supply Name:");
        String supplyName = scanner.nextLine();

        System.out.println("Enter Quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Reorder Level:");
        int reorderLevel = Integer.parseInt(scanner.nextLine());

        return new InventoryItem(supplyName, quantity, reorderLevel);
    }

    public void displayInventoryItems(List<InventoryItem> items) {
        System.out.println("\n--- Inventory Items ---");
        for (InventoryItem item : items) {
            System.out.printf("Supply ID: %d, Name: %s, Quantity: %d, Reorder Level: %d\n",
                    item.getSupplyId(), item.getSupplyName(), item.getQuantity(), item.getReorderLevel());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

