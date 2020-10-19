/*
 * This class is designed to test the functionality of all the other classes
 * 
 * @author Matthew Grunauer
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 
public class PlaylistOperations{
    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        String artist = "";
        String title = "";
        int minutes = 0;
        int seconds = 0;
        int position = 0;
        Playlist userPlaylist = new Playlist();
        while (!(userInput.equalsIgnoreCase("q"))){
            System.out.println("A) Add Song");
            System.out.println("B) Print Songs by Artist");
            System.out.println("G) Get Song");
            System.out.println("R) Remove Song");
            System.out.println("P) Print All Songs");
            System.out.println("S) Size");
            System.out.println("Q) Quit");
            System.out.print("\nSelect a menu option: ");
            userInput = stdin.readLine();

            if (userInput.equalsIgnoreCase("a")){
                System.out.print("Enter the title: ");
                title = stdin.readLine();
                System.out.print("Enter the artist: ");
                artist = stdin.readLine();
                System.out.print("Enter the song length (minutes): ");
                minutes = Integer.parseInt(stdin.readLine());
                System.out.print("Enter the song length (seconds): ");
                seconds = Integer.parseInt(stdin.readLine());
                System.out.print("Enter the position: ");
                position = Integer.parseInt(stdin.readLine());
                try {
                    userPlaylist.addSong(new SongRecord(artist, title, minutes, seconds), position);
                }
                catch (FullPlaylistException fullError) {
                    System.out.println(fullError.getMessage());
                }
                catch (IllegalArgumentException illegalArgumentError) {
                    System.out.println(illegalArgumentError.getMessage());
                }
            }
            else if (userInput.equalsIgnoreCase("p")){
                userPlaylist.printAllSongs();
            }
            else if (userInput.equalsIgnoreCase("b")){
                System.out.print("Enter the artist: ");
                artist = stdin.readLine();
                Playlist artistPlaylist = new Playlist();
                artistPlaylist = userPlaylist.getSongsByArtist(userPlaylist, artist);
                artistPlaylist.printAllSongs();
            }
            else if (userInput.equalsIgnoreCase("g")){
                System.out.print("Enter the position: ");
                position = Integer.parseInt(stdin.readLine());
                try{
                    SongRecord requestedSong = userPlaylist.getSong(position);
                    System.out.println("\nSong#   Title          Artist          Length");
                    System.out.println("---------------------------------------------");
                    System.out.print(position + "\t");
                    System.out.println(requestedSong.toString() + "\n");
                }
                catch (IllegalArgumentException illegalArgumentError){
                    System.out.println(illegalArgumentError.getMessage());
                }
            }
            else if (userInput.equalsIgnoreCase("s")){
                System.out.println("\nThere are " + userPlaylist.size() 
                    + " song(s) in the current playlist.\n");
            }
            else if (userInput.equalsIgnoreCase("r")){
                System.out.print("Enter the position: ");
                position = Integer.parseInt(stdin.readLine());
                try {
                    userPlaylist.removeSong(position);
                }
                catch (IllegalArgumentException illegalArgumentError) {
                    System.out.println(illegalArgumentError.getMessage());
                }
            }
            else if (userInput.equalsIgnoreCase("q")){
                break;
            }
            else {
                System.out.println("Invalid command, returning to main menu.\n");
            }
        }
        System.out.println("\nProgram terminating normally...");
    }
}
