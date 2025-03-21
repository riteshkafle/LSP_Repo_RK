package org.howard.edu.lsp.midterm.question5;
/**
 * The Streamable interface defines the shared behaviors for all media types.
 */
public interface Streamable {
    /**
     * Plays the content.
     */
    void play();

    /**
     * Pauses the content.
     */
    void pause();

    /**
     * Stops the content.
     */
    void stop();
}