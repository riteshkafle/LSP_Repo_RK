package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A simple shopping cart supporting add/remove items, 
 * discount codes, and total cost calculation.
 */
public class ShoppingCart {
    private final Map<String, Double> items = new HashMap<>();
    private double discountPercent = 0.0;

    /**
     * Adds an item with a positive price.
     * @param itemName must be non-null, non-empty
     * @param price must be > 0
     * @throws IllegalArgumentException for invalid name or price
     */
    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException(
                price < 0 ? "Price cannot be negative." : "Price cannot be zero."
            );
        }
        items.put(itemName, price);
    }

    /**
     * Removes an item by name.
     * @return true if present and removed, false otherwise
     */
    public boolean removeItem(String itemName) {
        return items.remove(itemName) != null;
    }

    /**
     * @return sum(prices) minus any discount
     */
    public double calculateTotal() {
        double sum = items.values().stream()
                          .mapToDouble(Double::doubleValue)
                          .sum();
        return sum * (1 - discountPercent/100.0);
    }

    /**
     * Supports only "SAVE10" or "SAVE20".
     * @throws IllegalArgumentException otherwise
     */
    public void applyDiscount(String code) {
        switch (Objects.requireNonNull(code, "Code cannot be null")) {
            case "SAVE10":
                discountPercent = 10;
                break;
            case "SAVE20":
                discountPercent = 20;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /** @return current discount as a percentage */
    public double getDiscount() {
        return discountPercent;
    }

    /** @return number of items in cart */
    public int getSize() {
        return items.size();
    }
}

