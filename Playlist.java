/*
 * This class represents a playlist of songs
 * 
 * @author Matthew Grunauer
 */
public class Playlist{
    private SongRecord[] songList;
    private int actualLength;
    private final int MAXIMUM_LENGTH = 50;
    /*
     * This is the no-argument contructor used to create a new Playlist object
     */
    public Playlist(){
        this.songList = new SongRecord[MAXIMUM_LENGTH];
        this.actualLength = 0;
    }

    /*
     * This is an alternate contructor used to create a new Playlist object
     * 
     * @param realLength
     * Refers to the actual amount of songs contained in the Playlist
     */
    public Playlist(int realLength){
        this.songList = new SongRecord[MAXIMUM_LENGTH];
        this.actualLength = realLength;
    }

    /*
     * This is a getter method to obtain the amount of songs in a Playlist
     * 
     * @return
     * The amount of songs in the Playlist
     */
    public int getActualLength(){
        return this.actualLength;
    }

    /*
     * This is a mutator method designed to alter the count of songs in a Playlist
     * 
     * @param specifiedLength
     * Refers to the user-specified amount of songs in the Playlist
     */
    public void setActualLength(int specifiedLength){
        this.actualLength = specifiedLength;
    }

    /*
     * This is a getter method that obtains the array of SongRecords in a Playlist
     * 
     * @return
     * The SongRecords in a Playlist as an array
     */
    public SongRecord[] getSongList(){
        return this.songList;
    }

    /*
     * This method clones the current Playlist
     * 
     * @return
     * A Playlist object that has the same values as the current Playlist
     */
    public Playlist clone(){
        Playlist clonedPlaylist = new Playlist(this.getActualLength());
        for (int i = 0; i < this.size(); i++){
            clonedPlaylist.songList[i] = this.songList[i].clone();
        }
        return clonedPlaylist;
    }

    /*
     * This method checks for the equality of two Objects
     * 
     * @param obj
     * An object of type Object to be checked against the current Playlist
     * 
     * @return
     * A boolean value; true if the objects are equal, false otherwise
     */
    public boolean equals(Object obj){
        boolean flag = true;
        if (obj instanceof Playlist) {
            Playlist secondPlaylist = (Playlist)obj;
            if (this.size() != secondPlaylist.size() || obj == null){
                return false;
            }
            for (int i = 0; i < this.songList.length; i++){
                if (this.songList[i] == null){
                    break;
                }
                else if (this.songList[i].getTitle().equals(secondPlaylist.songList[i].getTitle()) == false){
                    flag = false;
                    break;
                }
                else if (this.songList[i].getArtist().equals(secondPlaylist.songList[i].getArtist()) == false){
                    flag = false;
                    break;
                }
                else if (this.songList[i].getMinutes() != secondPlaylist.songList[i].getMinutes()){
                    flag = false;
                    break;
                }
                else if (this.songList[i].getSeconds() != secondPlaylist.songList[i].getSeconds()){
                    flag = false;
                    break;
                }
                else{
                    continue;
                }
            }
        }
        else {
            return false;
        }
        return flag;
    }

    /*
     * This is a method that gets the number of SongRecords in a Playlist
     * 
     * @return
     * An integer representing the amount of SongRecords in a Playlist
     */
    public int size(){
        return this.getActualLength();
    }

    /*
     * This method adds a SongRecord to a Playlist at a specified position
     * 
     * @param song
     * An object of type SongRecord representing the song to be added to the Playlist
     *      
     * @param position
     * An integer representing the position in the Playlist the song will be added to
     * 
     * @throws FullPlaylistException
     * When the user attempts to insert a song into a Playlist that is at full capacity
     * 
     * @throws IllegalArgumentException
     * When the user attempts to insert a song into a Playlist at an invalid position
     */
    public void addSong(SongRecord song, int position) throws FullPlaylistException{
        if (position < 1 || position > 49 || position > this.size() + 1){
            throw new IllegalArgumentException("Invalid insertion index.\n");
        }
        else if (this.size() == 50){
            try{
                throw new FullPlaylistException("Cannot insert song into a full playlist.\n");
            }
            catch (FullPlaylistException err){
                System.out.println(err.getMessage());
            }
        }
        else{
            SongRecord[] newSongList = new SongRecord[MAXIMUM_LENGTH];
            for (int i = 0; i < this.songList.length; i++){
                if (i < position - 1){
                    newSongList[i] = this.songList[i];
                }
                else if (i == position - 1){
                    newSongList[i] = song;
                    this.setActualLength(this.getActualLength() + 1);
                    System.out.println("Song Added: " + song.getTitle() + " by " + song.getArtist() + "\n");
                }
                else{
                    newSongList[i] = this.songList[i - 1];
                }
            }
            this.songList = newSongList;
        }
    }

    /*
     * This method removes a SongRecord from a Playlist at a specified position
     * 
     * @param position
     * An integer representing the position in the Playlist the user would like to remove a SongRecord from
     * 
     * @throws IllegalArgumentException
     * When a user attempts to remove a SongRecord from a Playlist at an invalid position
     */
    public void removeSong(int position){
        position--;
        if (position < 0 || position > 49 || position >= this.size()){
            throw new IllegalArgumentException("Invalid deletion index.\n");
        }
        else{
            SongRecord[] newSongList = new SongRecord[MAXIMUM_LENGTH];
            for (int i = 0, j = 0; i < this.songList.length; i++) { 
                if (i == position) { 
                    this.setActualLength(this.getActualLength() - 1);
                    System.out.println("The song at position " + (position + 1) + " has been removed.\n");
                    continue;
                }  
                newSongList[j++] = this.songList[i]; 
            } 
            this.songList = newSongList;
        }
    }

    /*
     * This method allows a user to retrieve a SongRecord from a specified position in a Playlist
     * 
     * @param position
     * An integer representing the position in the Playlist the user would like to retrieve a SongRecord from
     * 
     * @throws IllegalArgumentException
     * When a user attempts to retrieve a SongRecord from an invalid position in a Playlist
     */
    public SongRecord getSong(int position){
        position--;
        if (position + 1 > this.size() || position < 0){
            throw new IllegalArgumentException("There is no song at this position.\n");
        }
        else if (this.songList[position] != null) {
            return this.songList[position];
        }
        else{
            return null;
        }
    }

    /*
     * This method prints all of the SongRecords from a Playlist in a neatly ordered table
     */
    public void printAllSongs(){
        System.out.println("\nSong#   Title          Artist          Length");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < this.size(); i++){
            System.out.print(i + 1 + "\t");
            System.out.println(this.songList[i].toString());
        }
        System.out.println();
    }

    /*
     * This method allows a user to create a new Playlist of SongRecords by specified artist
     * 
     * @param originalList
     * A Playlist object representing the original Playlist containing all of the original SongRecords
     * 
     * @param artist
     * A String object representing the artist the user would like to create a Playlist for
     * 
     * @return
     * A new Playlist object containing SongRecords whose artist matches the specified artist 
     */
    public static Playlist getSongsByArtist(Playlist originalList, String artist){
        Playlist newPlaylist = new Playlist();
        if (originalList == null || artist == null){
            return null;
        }
        for (int i = 0, j = 0; i < originalList.size(); i++){
            if (originalList.songList[i].getArtist().equalsIgnoreCase(artist)){
                newPlaylist.songList[j++] = originalList.songList[i].clone();
                newPlaylist.setActualLength(newPlaylist.getActualLength() + 1);
            }
        }
        return newPlaylist;
    }

    /*
     * This method creates a String representation of a Playlist object
     * 
     * @return
     * A String representation of the current Playlist object
     */
    public String toString(){
        String representation = "";
        for (int i = 0; i < this.size(); i++){
            if (this.songList[i] != null){
                representation += (i + 1) + "\t" + this.songList[i].toString() + "\n";
            }
        }
        return representation;
    }
}
