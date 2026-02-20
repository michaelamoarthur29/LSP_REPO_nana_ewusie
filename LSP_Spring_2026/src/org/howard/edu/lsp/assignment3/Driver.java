package org.howard.edu.lsp.assignment3;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        ETLPipeline pipeline = new ETLPipeline();
        
        // Define exact relative paths [cite: 11]
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        try {
            // Coordinator logic [cite: 11, 20]
            pipeline.extract(inputPath);
            pipeline.transform();
            pipeline.load(outputPath);
            
            // Required Run Summary [cite: 11]
            System.out.println("Execution Summary:");
            System.out.println("Rows Read: " + pipeline.getRowsRead());
            System.out.println("Rows Transformed: " + pipeline.getRowsTransformed());
            System.out.println("Rows Skipped: " + pipeline.getRowsSkipped());
            System.out.println("Output File: " + outputPath);
            
        } catch (IOException e) {
            // Graceful error handling [cite: 11]
            System.err.println("Error: " + e.getMessage());
        }
    }
}
    