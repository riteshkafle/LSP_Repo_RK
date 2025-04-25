package org.howard.edu.lspfinal.question1;

/**
 * Thrown when a ShoppingCart operation fails due to invalid input or state.
 */
public class ShoppingCartException extends RuntimeException {
    public ShoppingCartException(String message) {
        super(message);
    }
}
