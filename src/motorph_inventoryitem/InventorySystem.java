/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorph_inventoryitem;
import java.util.*;

class InventoryItem {
    Date dateEntered;
    String status;
    String brand;
    String engineNumber;
    String purchaseStatus;

    // Constructor
    public InventoryItem(Date dateEntered, String status, String brand, String engineNumber, String purchaseStatus) {
        this.dateEntered = dateEntered;
        this.status = status;
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.purchaseStatus = purchaseStatus;
    }

    // Getters and Setters
    public Date getDateEntered() { return dateEntered; }
    public String getStatus() { return status; }
    public String getBrand() { return brand; }
    public String getEngineNumber() { return engineNumber; }
    public String getPurchaseStatus() { return purchaseStatus; }
    
    // Example comparator for sorting by date
    public static Comparator<InventoryItem> DateEnteredComparator = new Comparator<InventoryItem>() {
        public int compare(InventoryItem item1, InventoryItem item2) {
            return item1.getDateEntered().compareTo(item2.getDateEntered());
        }
    };
}

public class InventorySystem {
    private LinkedList<InventoryItem> inventory = new LinkedList<>();

    // Add a new item
    public void addItem(InventoryItem item) {
        inventory.add(item);
    }

    // Remove an item by engine number
    public void removeItem(String engineNumber) {
        inventory.removeIf(item -> item.getEngineNumber().equals(engineNumber));
    }

    // Sort inventory by date
    public void sortInventoryByDate() {
        Collections.sort(inventory, InventoryItem.DateEnteredComparator);
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        
        // Add items
        system.addItem(new InventoryItem(new Date(), "New", "BrandA", "1234", "Purchased"));
        system.addItem(new InventoryItem(new Date(System.currentTimeMillis() - 1000000000), "Used", "BrandB", "5678", "Pending"));
        
        // Sort items by date
        system.sortInventoryByDate();
        
        // Remove an item
        system.removeItem("1234");
    }
}
