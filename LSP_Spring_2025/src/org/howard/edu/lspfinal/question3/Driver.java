package org.howard.edu.lspfinal.question3;

/**
 * Driver: demonstrates report generation.
 */
public class Driver {
    public static void main(String[] args) {
        // Generate a sales report
        Report sales = new SalesReport();
        sales.generateReport();

        // Generate an inventory report
        Report inventory = new InventoryReport();
        inventory.generateReport();
    }
}
