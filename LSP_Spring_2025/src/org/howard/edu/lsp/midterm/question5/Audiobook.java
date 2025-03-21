package org.howard.edu.lsp.midterm.question5;

/**
 * Audiobook represents audiobook content and supports changing the playback speed.
 */
public class Audiobook extends AbstractMedia {
    /**
     * Constructs an Audiobook object with the given title.
     * @param title the title of the audiobook.
     */
    public Audiobook(String title) {
        super(title);
    }

    @Override
    protected String getMediaType() {
        return "audiobook";
    }

    /**
     * Sets the playback speed for the audiobook.
     * @param speed the new playback speed.
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed for audiobook: " + title + " to " + speed + "x");
    }
}