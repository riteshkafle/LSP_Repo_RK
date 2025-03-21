package org.howard.edu.lsp.midterm.question5;

/**
 * AbstractMedia provides the common implementations for play, pause, and stop.
 * This design focuses on shared behavior by letting subclasses supply the media type.
 */
public abstract class AbstractMedia implements Streamable {
    protected String title; // Title of the media content

    /**
     * Constructs an AbstractMedia object with the given title.
     * @param title the title of the media.
     */
    public AbstractMedia(String title) {
        this.title = title;
    }

    /**
     * Returns the type of media (e.g., "music", "movie", "audiobook").
     * @return the media type as a string.
     */
    protected abstract String getMediaType();

    @Override
    public void play() {
        System.out.println("Playing " + getMediaType() + ": " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused " + getMediaType() + ": " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped " + getMediaType() + ": " + title);
    }
}