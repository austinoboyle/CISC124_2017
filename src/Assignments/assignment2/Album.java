package Assignments.assignment2;

public class Album {

    private Song[] songList;
    private String album;
    private String artist;
    private int numberOfSongs;
    
    public Album(final int numberOfSongs, final String album, final String artist){
        this.numberOfSongs = numberOfSongs;
        if (numberOfSongs <= 0){
            System.err.println("Error: Invalid number of songs");
            this.numberOfSongs = 0;
        }
        this.songList = new Song[this.numberOfSongs];
        this.album = album;
        this.artist = artist;
    }
    
    public Song[] getSongList(){
        Song[] songListCopy = new Song[this.numberOfSongs];
        for (int i = 0; i < this.numberOfSongs; i++){
            songListCopy[i] = this.songList[i];
        }
        return songListCopy;
    }
    
    public String getName(){
        return this.album;
    }
    
    public String getArtist(){
        return this.artist;
    }
    
    public void addSong(Song song, int index){
        if (index < 0 || index >= this.numberOfSongs){
            System.err.println("Error: Invalid Index for Song");
            return;
        }
        
        this.songList[index] = song;
    }
    
    public String toString(){
        return this.album + " from " + this.artist;
    }
}
