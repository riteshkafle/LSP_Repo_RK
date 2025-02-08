//Ritesh Kafle
package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class ETL {

    public static void main(String[] args) {
        //defining a inputfilepath and outputfilepath
        String inputFilePath =  "data/products.csv";
        String outputFilePath = "data/transformed_outputs.csv";
        
        BufferedReader reader = null;
        BufferedWriter writer = null;
        
        try {
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists() || !inputFile.isFile()) {
                System.err.println("Error: Input file not found. Please ensure that \"" + inputFilePath + "\" exists and is accessible.");
                return;
            }
            
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputFilePath));
            String headerLine = reader.readLine();
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();
            
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
        
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.err.println("Warning: Skipping malformed line: " + line);
                    continue;
                }
                
                String productId = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();
                
                double price;
                try {
                    price = Double.parseDouble(priceStr);
                } catch (NumberFormatException e) {
                    System.err.println("Warning: Skipping line with invalid price (" + priceStr + "): " + line);
                    continue;
                }
            
                name = name.toUpperCase();
                
                //product is in the "Electronics", use discount first.
                if (category.equalsIgnoreCase("Electronics")) {
                    // appying a 10% discount
                    price = price * 0.9;
                    //rounding decimal
                    price = Math.round(price * 100.0) / 100.0;
                    
                    //price > 500 
                    if (price > 500) {
                        category = "Premium Electronics";
                    }
                }
                
                String priceRange;
                if (price >= 0 && price <= 10.0) {
                    priceRange = "Low";
                } else if (price > 10.0 && price <= 100.0) {
                    priceRange = "Medium";
                } else if (price > 100.0 && price <= 500.0) {
                    priceRange = "High";
                } else if (price > 500.0) {
                    priceRange = "Premium";
                } else {
                    priceRange = "Unknown";
                }
                
                String formattedPrice = String.format("%.2f", price);
                
                String transformedLine = productId + "," + name + "," + formattedPrice + "," + category + "," + priceRange;
                
            
                writer.write(transformedLine);
                writer.newLine();
            }
            
            System.out.println("Transformation complete. Transformed data written to \"" + outputFilePath + "\".");
            
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        } finally {
            
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                System.err.println("Error closing file streams: " + ex.getMessage());
            }
        }
    }
}
