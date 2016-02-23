package luke.com.playlist;

import java.util.ArrayList;

/**
 * Created by luke on 2/8/16.
 */
public class Playlist {

    private static ArrayList<Song> songList;
    private int playcount;
    private String name;

    // default constructor
    public Playlist(String name){
        songList = new ArrayList<>();
        playcount = 0;
        this.name = name;
    }

    public Playlist(String name, Song[] list){
        songList = new ArrayList<>();
        for(Song song: list){
            add(song);
        }
        this.name = name;
    }

    // TODO add constructors for various sources i.e. soundcloud, youtube, local, etc.

    public void addYoutube(String url){
        Song song = new Song(url, url, "unknown", "unknown", 0);
        songList.add(song);
    }

    public void addSpotify(String url){
        Song song = new Song(url, url, "unknown", "unknown", 0);
        songList.add(song);
    }

    public void addSoundcloud(String url){
        Song song = new Song(url, url, "unknown", "unknown", 0);
        songList.add(song);
    }

    public void add(Song song){
        songList.add(song);
    }

    public int length(){
        return songList.size();
    }

    public int playCount(){
        return playcount;
    }

    public Song get(int i){
        return songList.get(i);
    }

    public String name(){
        return this.name;
    }

    //TODO
    /*
     * @return true on success
     * @return false on failure
     *
     */
    public boolean share(){
        return false;
    }// end share method
}
