package org.howard.edu.lsp.midterm.question5;

/**
 * Movie represents movie content and supports rewinding.
 */
public class Movie extends AbstractMedia {
    /**
     * Constructs a Movie object with the given title.
     * @param title the title of the movie.
     */
    public Movie(String title) {
        super(title);
    }

    @Override
    protected String getMediaType() {
        return "movie";
    }

    /**
     * Rewinds the movie by the specified number of seconds.
     * @param seconds the number of seconds to rewind.
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}