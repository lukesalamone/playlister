package luke.com.playlist;

import java.util.ArrayList;

/**
 * Created by luke on 2/8/16.
 */
public class Playlist {

    private ArrayList<Song> songList;
    private int length;
    private int playcount;

    // default constructor
    public Playlist(){
        length = 0;
        playcount = 0;
    }

    // TODO add constructors for various sources i.e. soundcloud, youtube, local, etc.

    public void add(Song song){
        songList.add(song);
        length++;
    }

    public int length(){
        return length;
    }

    public int playCount(){
        return playcount;
    }

    public Song get(int i){
        return songList.get(i);
    }

}
