package org.howard.edu.lsp.midterm.question5;

/**
 * Music represents music content and supports adding songs to a playlist.
 */
public class Music extends AbstractMedia {
    /**
     * Constructs a Music object with the given title.
     * @param title the title of the music.
     */
    public Music(String title) {
        super(title);
    }

    @Override
    protected String getMediaType() {
        return "music";
    }

    /**
     * Adds the current music track to the specified playlist.
     * @param playlistName the name of the playlist.
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Adding " + title + " to playlist: " + playlistName);
    }
}
