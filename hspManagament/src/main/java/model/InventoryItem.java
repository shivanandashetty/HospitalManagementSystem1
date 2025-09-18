package model;

public class InventoryItem {
    private int supplyId;
    private String supplyName;
    private int quantity;
    private int reorderLevel;

    public InventoryItem() {}

    public InventoryItem(String supplyName, int quantity, int reorderLevel) {
        this.supplyName = supplyName;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }

    // Getters and setters

    public int getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(int supplyId) {
        this.supplyId = supplyId;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
}
