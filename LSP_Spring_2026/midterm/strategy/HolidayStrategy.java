package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for holiday discount (15% discount).
 */
public class HolidayStrategy implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.85;
    }
}
