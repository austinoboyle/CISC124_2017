package Assignments.assignment2;



public class Song implements Comparable<Song>{
    private String songName;
    private String artist;
    private int lengthOfSong;
    private int releaseYear;
    
    
    /**
     * Constructor.  Initializes object, handles errors in release date
     * and song length - setting them to zero if they are invalid
     * 
     * @param songName
     *          String - name of the song
     * @param artist
     *          String - name of the artist
     * @param lengthOfSong
     *          int - length of the song in seconds
     * @param releaseYear
     *          int - Year the song was released 
     */
    
    public Song(final String songName, String artist, final int lengthOfSong, int releaseYear){
        this.songName = songName;
        this.artist = artist;
        this.lengthOfSong = lengthOfSong;
        this.releaseYear = releaseYear;
        
        //Error handling: song length
        //Set song length to zero, print error msg to standard error
        if (lengthOfSong <= 0){
            System.err.println("Error: Invalid song Length");
            this.lengthOfSong = 0;
        }

        //Error handling: Release year
        //Set release year to zero, print error msg to standard error
        if (releaseYear < 1600 || releaseYear > 2017){
            System.err.println("Error: Invalid release date");
            this.releaseYear = 0;
        }
    }
    
    /**
     * Accessor method for the song name
     * @return
     *      String - Song's Name
     */
    public String getName(){
        return this.songName;
    }
    
    /**
     * Accessor Method for artist's name
     * @return
     *      String - Artist's name
     */
    public String getArtist(){
        return this.artist;
    }
    
    /**
     * Accessor Method for song duration
     * @return
     *      int - Duration of song in seconds
     */
    public int getDuration(){
        return this.lengthOfSong;
    }
    
    /**
     * Accessor Method for release date
     * @return
     *      int - release year of the song
     */
    public int getYear(){
        return this.releaseYear;
    }
    
    /**
     * Mutator method - sets the artist's name for a song
     * @param name
     *      String - artist name
     * changes instance variable for artist's name to name
     */
    public void setArtist(String name){
        this.artist = name;
    }
    
    /**
     * Mutator method - sets release year of song
     * @param year
     *      int - release year of the song
     *      
     * Changes instance variable for release year to year
     */
    public void setYear(int year){
        
        //Error handling: invalid release year
        //Set release year to zero and print error msg to standard error
        if (year < 1600 || year > 2017){
            System.err.println("Error: Invalid release date");
            this.releaseYear = 0;
        }
        else
            this.releaseYear = year;
    }
    
    /**
     * Instance method, checks if a song is greater than or equal to the length of another song
     * @param otherSong
     *          Song object - song to compare lengths with
     * @return
     *      true if self has longer or equal song duration to otherSong, false otherwise
     */
    public boolean isLonger(Song otherSong){
        return this.lengthOfSong >= otherSong.lengthOfSong;
    }
    
    /**
     * @return
     *      String
     */
    public String toString(){
        String returnString = "";
        returnString += this.songName + " (" + this.artist +", "
                        + Integer.toString(this.releaseYear) + ")"; 
        
        return returnString;
    }
    
    public static int sumDurations(Song[] songs){
        int totalTime = 0;
        for (Song song: songs){
            totalTime += song.lengthOfSong;
        }
        
        return totalTime;
    }
    
    public static int sumDurations(Song[] songs, int pauseLength){
        //handle zero length array case
        if (songs.length == 0)
            return 0;
        
        int totalTime = 0;
        //add length of each song to total time
        for (Song song: songs){
            totalTime += song.lengthOfSong;
        }
        //length - 1 song transitions
        totalTime += (songs.length - 1) * pauseLength;
        return totalTime;
    }
    
    public int compareTo(Song that){
        return this.lengthOfSong - that.lengthOfSong;
    }
    
    
}
