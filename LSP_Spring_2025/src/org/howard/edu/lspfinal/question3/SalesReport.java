package org.howard.edu.lspfinal.question3;
//Reference used sources:
//https://makoservernet/article/HTML-LSP/
//https://www.w3schools.com/

/**
 * SalesReport: concrete implementation of Report.
 */
public class SalesReport extends Report {
    @Override
    protected void loadData() {
        System.out.println("Loading sales data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing sales report.");
    }
}
