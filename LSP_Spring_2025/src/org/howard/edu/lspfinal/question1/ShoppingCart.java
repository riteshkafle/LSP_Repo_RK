package org.howard.edu.lspfinal.question1;
//Reference used sources:
//https://makoservernet/article/HTML-LSP/
//https://www.w3schools.com/

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     *
     * @param itemName the name of the item (must be non-null, non-empty)
     * @param price    the price of the item (must be > 0)
     * @throws ShoppingCartException if itemName is null/empty or price <= 0
     */
    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new ShoppingCartException("Item name cannot be null or empty.");
        }
        if (price <= 0) {
            throw new ShoppingCartException("Price must be greater than zero.");
        }
        items.put(itemName, price);
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discounts currently in effect.
     *
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double p : items.values()) {
            total += p;
        }
        return total - (total * discountPercentage / 100.0);
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10": 10% discount
     * - "SAVE20": 20% discount
     *
     * @param code the discount code
     * @throws ShoppingCartException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new ShoppingCartException("Invalid discount code.");
        }
    }

    /**
     * Returns the current discount percentage applied to the cart.
     * Useful for testing.
     *
     * @return the discount percentage (0.0 if no discount applied)
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}

