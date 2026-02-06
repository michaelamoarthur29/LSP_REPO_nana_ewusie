package org.howard.edu.lsp.assignment2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {
    	//System.out.println("Current Directory: " + System.getProperty("user.dir"));
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.err.println("Error: Input file 'data/products.csv' not found.");
            return;
        }

        // Ensure data directory exists for output
        new File("data").mkdirs();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            String header = br.readLine();
            if (header != null) {
                // Write output header with new column
                bw.write("ProductID,Name,Price,Category,PriceRange");
                bw.newLine();
            } else {
                return; // Empty file
            }

            String line;
            while ((line = br.readLine()) != null) {
                rowsRead++;
                
                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");

                // Requirement: Must contain exactly four fields
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    // Extract & Trim
                    String rawId = parts[0].trim();
                    String name = parts[1].trim();
                    String rawPrice = parts[2].trim();
                    String category = parts[3].trim();

                    // Parse & Validate Numeric fields
                    int productId = Integer.parseInt(rawId);
                    BigDecimal price = new BigDecimal(rawPrice);

                    // --- TRANSFORMATIONS ---
                    
                    // 1. Name to UPPERCASE
                    name = name.toUpperCase();

                    // 2. Electronics Discount (10%)
                    boolean wasElectronics = category.equalsIgnoreCase("Electronics");
                    if (wasElectronics) {
                        price = price.multiply(new BigDecimal("0.90"));
                    }

                    // Round to 2 decimal places (Half Up)
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // 3. Premium Electronics Logic
                    if (wasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                        category = "Premium Electronics";
                    }

                    // 4. Determine Price Range
                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    // --- LOAD ---
                    String outputLine = String.format("%d,%s,%.2f,%s,%s", 
                                        productId, name, price, category, priceRange);
                    bw.write(outputLine);
                    bw.newLine();
                    
                    rowsTransformed++;

                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }

            // Run Summary
            System.out.println("Execution Summary:");
            System.out.println("Rows Read: " + rowsRead);
            System.out.println("Rows Transformed: " + rowsTransformed);
            System.out.println("Rows Skipped: " + rowsSkipped);
            System.out.println("Output File: " + outputPath);
           // System.out.println("Current Directory: " + System.getProperty("user.dir"));//

        } catch (IOException e) {
            System.err.println("An error occurred during file processing: " + e.getMessage());
        }
    }
}