package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for regular customers (no discount).
 */
public class RegularStrategy implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price;
    }
}
