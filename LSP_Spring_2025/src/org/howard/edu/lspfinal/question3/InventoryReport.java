package org.howard.edu.lspfinal.question3;
//Reference used sources:
//https://makoservernet/article/HTML-LSP/
//https://www.w3schools.com/

/**
 * InventoryReport: concrete implementation of Report.
 */
public class InventoryReport extends Report {
    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.");
    }
}
