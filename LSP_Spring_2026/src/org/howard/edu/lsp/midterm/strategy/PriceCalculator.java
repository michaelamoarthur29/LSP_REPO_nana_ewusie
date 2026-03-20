package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a discount strategy.
 */
public class PriceCalculator {
    private DiscountStrategy strategy;

    /**
     * Sets the discount strategy.
     * 
     * @param strategy the discount strategy
     */
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates final price using selected strategy.
     * 
     * @param price original price
     * @return final price
     */
    public double calculatePrice(double price) {
        return strategy.calculate(price);
    }
}
