/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorph_inventoryitem;
import java.util.LinkedList;

class Stock {
    String date;  // Date of stock entry
    String status;  // Stock status compared to last month
    String brand;  // Brand of the stock
    String engineNumber;  // Unique engine number
    boolean purchaseStatus;  // Purchased or not

    public Stock(String date, String status, String brand, String engineNumber, boolean purchaseStatus) {
        this.date = date;
        this.status = status;
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.purchaseStatus = purchaseStatus;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", brand='" + brand + '\'' +
                ", engineNumber='" + engineNumber + '\'' +
                ", purchaseStatus=" + purchaseStatus +
                '}';
    }
}

class Inventory {
    LinkedList<Stock> stockList;

    public Inventory() {
        this.stockList = new LinkedList<>();
    }

    // Insertion sort based on Date of stock entry
    public void addStock(Stock newStock) {
        if (stockList.isEmpty()) {
            stockList.add(newStock);
        } else {
            int i = 0;
            for (Stock stock : stockList) {
                if (newStock.date.compareTo(stock.date) < 0) {
                    stockList.add(i, newStock);
                    return;
                }
                i++;
            }
            stockList.addLast(newStock);  // Add to end if it's the latest stock
        }
    }

    // Linear search to find stock by engine number
    public Stock searchStock(String engineNumber) {
        for (Stock stock : stockList) {
            if (stock.engineNumber.equals(engineNumber)) {
                return stock;
            }
        }
        return null;  // Stock not found
    }

    // Remove stock by engine number
    public void removeStock(String engineNumber) {
        boolean removed = stockList.removeIf(stock -> stock.engineNumber.equals(engineNumber));
        if (removed) {
            System.out.println("Stock with engine number " + engineNumber + " has been removed.");
        } else {
            System.out.println("Stock with engine number " + engineNumber + " not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addStock(new Stock("2024-09-29", "In Stock", "BrandX", "1234", true));
        inventory.addStock(new Stock("2024-09-28", "In Stock", "BrandY", "5678", false));

        // Search for stock by engine number
        Stock foundStock = inventory.searchStock("1234");
        if (foundStock != null) {
            System.out.println("Stock found: " + foundStock);
        } else {
            System.out.println("Stock with engine number 1234 not found.");
        }

        // Remove stock by engine number
        inventory.removeStock("5678");
    }
}
