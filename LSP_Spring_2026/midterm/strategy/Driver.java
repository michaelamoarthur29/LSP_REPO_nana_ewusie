package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to test Strategy Pattern implementation.
 */
public class Driver {
    public static void main(String[] args) {

        PriceCalculator calculator = new PriceCalculator();
        double price = 100.0;

        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        calculator.setStrategy(new VIPStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}
