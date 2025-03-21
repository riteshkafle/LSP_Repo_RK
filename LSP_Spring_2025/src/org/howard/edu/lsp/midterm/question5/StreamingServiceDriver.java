package org.howard.edu.lsp.midterm.question5;

/**
 * StreamingServiceDriver demonstrates creating and using different media types.
 */
public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Create instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");
        
        // Test the common behaviors for all media types (play, pause, stop)
        System.out.println("Testing common behaviors for all media types:\n");
        
        // Test Music
        System.out.println("Testing Music:");
        music.play();   
        music.pause();  
        music.stop();   
        System.out.println();
        
        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();   
        movie.pause();  
        movie.stop();   
        System.out.println();
        
        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();   // Expected Output: "Playing audiobook: A Promised Land – Barack Obama"
        audiobook.pause();  // Expected Output: "Paused audiobook: A Promised Land – Barack Obama"
        audiobook.stop();   // Expected Output: "Stopped audiobook: A Promised Land – Barack Obama"
        System.out.println();
        
        // Test unique behaviors for each media type
        // Test Movie-specific behavior (rewind)
        Movie movieWithRewind = (Movie) movie;  // Cast to Movie for specific method
        movieWithRewind.rewind(30);  // Expected Output: "Rewinding movie: Avengers End Game by 30 minutes"
        System.out.println();
        
        // Test Audiobook-specific behavior (setPlaybackSpeed)
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;  // Cast to Audiobook for specific method
        audiobookWithSpeed.setPlaybackSpeed(1.5);  // Expected Output: "Setting playback speed of audiobook: A Promised Land – Barack Obama 1.5x"
        System.out.println();
        
        // Test Music-specific behavior (addToPlaylist)
        Music musicWithPlaylist = (Music) music;  // Cast to Music for specific method
        musicWithPlaylist.addToPlaylist("Favorites");  // Expected Output: "Added Still a Friend - Incognito to Favorites playlist"
        System.out.println();
    }
}