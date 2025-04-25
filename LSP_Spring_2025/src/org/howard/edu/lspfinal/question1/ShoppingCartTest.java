package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShoppingCart — comprehensive validation")
class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void init() {
        cart = new ShoppingCart();
    }

    

    @Test
    @DisplayName("should add a valid item and update size & total")
    void shouldAddValidItem() {
        cart.addItem("Laptop", 999.99);
        assertEquals(1, cart.getSize());
        assertEquals(999.99, cart.calculateTotal(), 1e-6);
    }

    @Test
    @DisplayName("adding null or empty name throws exception")
    void addingEmptyNameIsInvalid() {
        IllegalArgumentException ex1 = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem(null, 10.0)
        );
        assertEquals("Item name cannot be empty.", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("   ", 10.0)
        );
        assertEquals("Item name cannot be empty.", ex2.getMessage());
    }

    @Test
    @DisplayName("adding zero price throws zero-price exception")
    void addingZeroPriceIsInvalid() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("Freebie", 0.0)
        );
        assertEquals("Price cannot be zero.", ex.getMessage());
    }

    @Test
    @DisplayName("adding negative price throws negative-price exception")
    void addingNegativePriceIsInvalid() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("BadItem", -5.0)
        );
        assertEquals("Price cannot be negative.", ex.getMessage());
    }

    

    @Test
    @DisplayName("removing existing item returns true & decrements size")
    void removeExistingItem() {
        cart.addItem("Book", 20.0);
        assertTrue(cart.removeItem("Book"));
        assertEquals(0, cart.getSize());
    }

    @Test
    @DisplayName("removing non-existent item returns false & size unchanged")
    void removeNonexistentItem() {
        cart.addItem("Pen", 2.0);
        assertFalse(cart.removeItem("Pencil"));
        assertEquals(1, cart.getSize());
    }

    // Total cost (no discount)

    @Test
    @DisplayName("total is sum of prices without discount")
    void totalWithoutDiscount() {
        cart.addItem("Shirt", 25.0);
        cart.addItem("Tie", 15.0);
        assertEquals(40.0, cart.calculateTotal(), 1e-6);
    }

    @Test
    @DisplayName("empty cart total is zero")
    void emptyCartTotalIsZero() {
        assertEquals(0.0, cart.calculateTotal(), 1e-6);
    }

    //  Discounts 

    @Test
    @DisplayName("apply SAVE10 sets 10% and affects total")
    void applySAVE10() {
        cart.addItem("Shoes", 50.0);
        cart.applyDiscount("SAVE10");
        assertEquals(10.0, cart.getDiscount(), 1e-6);
        assertEquals(45.0, cart.calculateTotal(), 1e-6);
    }

    @Test
    @DisplayName("apply SAVE20 sets 20% and affects total")
    void applySAVE20() {
        cart.addItem("Bag", 80.0);
        cart.applyDiscount("SAVE20");
        assertEquals(20.0, cart.getDiscount(), 1e-6);
        assertEquals(64.0, cart.calculateTotal(), 1e-6);
    }

    @Test
    @DisplayName("invalid discount code throws exception")
    void invalidDiscountCode() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> cart.applyDiscount("SAVE50")
        );
        assertEquals("Invalid discount code.", ex.getMessage());
    }
}
