package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    /**
     * Test for adding valid item.
     */
    @Test
    @DisplayName("Test for adding valid item")
    void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 15.0);
        assertEquals(15.0, cart.getTotalCost());
    }

    /**
     * Test for adding item with 0 price (expect exception).
     */
    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    void testAddItemWithZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(ShoppingCartException.class,
                     () -> cart.addItem("Freebie", 0.0));
    }

    /**
     * Test for adding item with negative price (expect exception).
     */
    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    void testAddItemWithNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(ShoppingCartException.class,
                     () -> cart.addItem("Faulty", -5.0));
    }

    /**
     * Test for applying "SAVE10".
     */
    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    /**
     * Test for applying "SAVE20".
     */
    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    /**
     * Test for applying invalid code (expect exception).
     */
    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    void testApplyInvalidCode() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(ShoppingCartException.class,
                     () -> cart.applyDiscountCode("SAVE50"));
    }

    /**
     * Test total cost without discount.
     */
    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 2.0);
        cart.addItem("Pencil", 1.0);
        assertEquals(3.0, cart.getTotalCost());
    }

    /**
     * Test total cost with discount.
     */
    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 1000.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(800.0, cart.getTotalCost());
    }

    /**
     * Test total cost with empty cart.
     */
    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost());
    }
}

