package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for member customers (10% discount).
 */
public class MemberStrategy implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.90;
    }
}
