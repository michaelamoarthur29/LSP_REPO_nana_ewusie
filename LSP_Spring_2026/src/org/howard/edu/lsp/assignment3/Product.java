package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a single product in the ETL pipeline.
 * Demonstrates encapsulation by using private fields and public accessors.
 */
public class Product {
    private int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private String priceRange;

    /**
     * Constructs a new Product with the specified details.
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters (Encapsulation)
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPriceRange() { return priceRange; }
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }
}