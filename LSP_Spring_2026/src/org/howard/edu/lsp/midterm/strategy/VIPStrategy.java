package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for VIP customers (20% discount).
 */
public class VIPStrategy implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.80;
    }
}
