package assignment2;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestSong {
    
    private static final Song song1 = new Song("Hello", "Bob Smith", 185, 1978);
    private static final Song song2 = new Song("Hi", "Joe", 200, 1987);
    private static final Song song3 = new Song("Halo", "Beyonce", 180, 1999);
    private static final Song song4 = new Song("Stronger", "Kanye West", 220, 2000);
    private static final Song song5 = new Song("Error Song1", "Fake person", 0, 1978);
    private static final Song song6 = new Song("Error Song 2", "Other Fake Person", 240, 2018);
    
    
    
    @Test
    public void testAccessors() {
        assertEquals("Expected different song name", "Hello", song1.getName());
        assertEquals("Expected different artist name", "Joe", song2.getArtist());
        assertEquals("Expected different songLength", 180, song3.getDuration());
        assertEquals("Expected different release year", 2000, song4.getYear()); 
    }
    
    @Test
    public void testMutators(){
        song1.setArtist("Dave");
        song1.setYear(1878);
        assertEquals("Expected artist name to be changed", "Dave", song1.getArtist());
        assertEquals("Expected releaseyear to be changed", 1878, song1.getYear());
    }
    
    @Test
    public void testToString(){
        String correctString = "Hi (Joe, 1987)";
        assertEquals("Expected different ToString output", correctString, song2.toString());
    }
    
    @Test
    public void testStaticMethods(){
        Song[] songList = {song2, song3, song4};
        int totalTimeNoPause = 600;
        int totalTimeWithPause = 604;
        assertEquals("Expected different total time", totalTimeNoPause, Song.sumDurations(songList));
        assertEquals("Expected different total time with pauses", totalTimeWithPause, Song.sumDurations(songList, 2));  
    }
    
    @Test
    public void testErrorHandling(){
        song4.setYear(-1);
        song3.setYear(1599);
        assertEquals("Expected correction to zero", 0, song4.getYear());
        assertEquals("Expected year to be zero", 0, song6.getYear());
        assertEquals("Expected year to be zero", 0, song3.getYear());
        
    }

}
