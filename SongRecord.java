/*
 * A class representing a song with its associated information
 * 
 * @author Matthew Grunauer
 */
public class SongRecord{
    private String artist;
    private String title;
    private int minutes;
    private int seconds;
    /*
     * The method is a constructor for an object of type SongRecord
     * 
     * @param artist
     * A string object representing the name of the song's artist
     * 
     * @param title
     * A string object representing the title of the song
     * 
     * @param minutes
     * An integer representing the length of the song (in minutes)
     * 
     * @param seconds
     * An integer representing the length of the song (in seconds)
     */
    public SongRecord(String artist, String title, int minutes, int seconds){
        this.artist = artist;
        this.title = title;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    /*
     * This method clones the current SongRecord
     * 
     * @return
     * A new SongRecord object with identical attributes to the current SongRecord object
     */
    public SongRecord clone(){
        return new SongRecord(new String(this.artist),new String(this.title),this.minutes,this.seconds);
    }

    /*
     * This method obtains the artist for the current SongRecord
     * 
     * @return
     * A String object representing the name of the artist of the current SongRecord
     */
    public String getArtist(){
        return this.artist;
    }
    
    /*
     * This method obtains the title of the current SongRecord
     * 
     * @return
     * A String object representing the title of the current SongRecord
     */
    public String getTitle(){
        return this.title;
    }
    
    /*
     * This method obtains the amount of minutes in the current SongRecord
     * 
     * @return
     * An integer representing the amount of minutes in the current SongRecord
     */
    public int getMinutes(){
        return this.minutes;
    }

    /*
     * This method obtains the amount of seconds in the current SongRecord
     * 
     * @return
     * An integer representing the amount of seconds in the current SongRecord
     */
    public int getSeconds(){
        return this.seconds;
    }
    
    /*
     * This method sets the artist for the current SongRecord
     * 
     * @param newArtist
     * A String object representing the new artist for the current SongRecord
     */
    public void setArtist(String newArtist){
        this.artist = newArtist;
    }
    
    /*
     * This method sets the title for the current SongRecord
     * 
     * @param newTitle
     * A String object representing the new title for the current SongRecord
     */
    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    /*
     * This method sets the amount of minutes for the current SongRecord
     * 
     * @param newMinutes
     * An integer representing the new amount of minutes for the current SongRecord
     */
    public void setMinutes(int newMinutes){
        if (newMinutes < 0){
            throw new IllegalArgumentException("Entered an invalid amount of minutes");
        }
        else{
            this.minutes = newMinutes;
        }
    }
    
    /*
     * This method sets the amount of seconds in the current SongRecord
     * 
     * @param newSeconds
     * An integer representing the new amount of seconds for the 
     */
    public void setSeconds(int newSeconds){
        if (newSeconds < 0 || newSeconds > 59){
            throw new IllegalArgumentException("Entered an invalid amount of seconds");
        }
        else{
            this.seconds = newSeconds;
        }
    }

    /*
     * This method creates a String representation of the current SongRecord
     * 
     * @return
     * A String representation of the current SongRecord
     */
    public String toString(){
        if (seconds < 10){
            return(String.format("%-15s%-15s%5s", title, artist, minutes + ":" +  "0" + seconds));
        }
        else{
            return(String.format("%-15s%-15s%5s", title, artist, minutes + ":" + seconds));
        }
    }
}
