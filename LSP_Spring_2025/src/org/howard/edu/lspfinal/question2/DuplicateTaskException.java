package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when attempting to add a task whose name already exists.
 */
public class DuplicateTaskException extends Exception {
    /**
     * Constructs a new DuplicateTaskException with the specified detail message.
     *
     * @param message detail message explaining the duplicate task
     */
    public DuplicateTaskException(String message) {
        super(message);
    }
}
