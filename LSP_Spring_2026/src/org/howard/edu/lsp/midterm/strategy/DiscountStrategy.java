package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for calculating discounted price.
 */
public interface DiscountStrategy {
    /**
     * Calculates the final price.
     * 
     * @param price original price
     * @return final price after discount
     */
    double calculate(double price);
}
