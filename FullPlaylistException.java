/*
 * The class represents a custom runtime exception
 * that is thrown when a user attempts to add a SongRecord
 * to a full Playlist
 * 
 * @author Matthew Grunauer
 */
public class FullPlaylistException extends Exception{
    /*
     * This method is a constructor for the FullPlaylistException class
     * 
     * @param errorMessage
     * A string representing the error message associated
     * with a particular instance of the thrown exception
     */
    public FullPlaylistException(String errorMessage){
        super(errorMessage);
    }
}
