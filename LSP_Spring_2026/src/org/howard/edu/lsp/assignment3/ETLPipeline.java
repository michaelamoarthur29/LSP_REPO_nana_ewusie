package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the Extract-Transform-Load process for product data.
 * This class decomposes the ETL logic into distinct, manageable steps.
 */
public class ETLPipeline {
    private int rowsRead = 0;
    private int rowsSkipped = 0;
    private List<Product> products = new ArrayList<>();

    /**
     * Reads data from the input CSV and converts valid rows into Product objects.
     * @param inputPath Path to the source CSV file.
     */
    public void extract(String inputPath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                rowsRead++;
                if (line.trim().isEmpty()) { rowsSkipped++; continue; }
                
                String[] parts = line.split(",");
                if (parts.length != 4) { rowsSkipped++; continue; }

                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    BigDecimal price = new BigDecimal(parts[2].trim());
                    String category = parts[3].trim();
                    
                    products.add(new Product(id, name, price, category));
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }
        }
    }

    /**
     * Applies business transformation rules to the list of products.
     */
    public void transform() {
        for (Product p : products) {
            // 1. Uppercase Name
            p.setName(p.getName().toUpperCase());

            // 2. Electronics Discount
            boolean wasElectronics = p.getCategory().equalsIgnoreCase("Electronics");
            if (wasElectronics) {
                p.setPrice(p.getPrice().multiply(new BigDecimal("0.90")));
            }

            // Rounding
            p.setPrice(p.getPrice().setScale(2, RoundingMode.HALF_UP));

            // 3. Premium Electronics Check
            if (wasElectronics && p.getPrice().compareTo(new BigDecimal("500.00")) > 0) {
                p.setCategory("Premium Electronics");
            }

            // 4. Price Range Assignment
            BigDecimal price = p.getPrice();
            if (price.compareTo(new BigDecimal("10.00")) <= 0) p.setPriceRange("Low");
            else if (price.compareTo(new BigDecimal("100.00")) <= 0) p.setPriceRange("Medium");
            else if (price.compareTo(new BigDecimal("500.00")) <= 0) p.setPriceRange("High");
            else p.setPriceRange("Premium");
        }
    }

    /**
     * Writes the transformed product data to the output CSV.
     * @param outputPath Path to the destination CSV file.
     */
    public void load(String outputPath) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {
            pw.println("ProductID,Name,Price,Category,PriceRange");
            for (Product p : products) {
                pw.printf("%d,%s,%.2f,%s,%s%n", 
                    p.getProductId(), p.getName(), p.getPrice(), p.getCategory(), p.getPriceRange());
            }
        }
    }

    // Getters for the Run Summary
    public int getRowsRead() { return rowsRead; }
    public int getRowsTransformed() { return products.size(); }
    public int getRowsSkipped() { return rowsSkipped; }
}