package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a requested task cannot be found.
 */
public class TaskNotFoundException extends Exception {
    /**
     * Constructs a new TaskNotFoundException with the specified detail message.
     *
     * @param message detail message explaining which task was not found
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
