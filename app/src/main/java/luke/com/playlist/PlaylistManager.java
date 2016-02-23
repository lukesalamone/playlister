package luke.com.playlist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages operations to user's playlist list
 *
 * Created by luke on 2/23/16.
 */
public class PlaylistManager {

    private static ArrayList<Playlist> playlists;

    public PlaylistManager(){
        playlists = new ArrayList<>();
    }// end constructor

    public static void add(Playlist playlist){
        playlists.add(playlist);
    }

    public static void remove(Playlist playlist){
        playlists.remove(playlist);
    }

    public static int size(){
        return playlists.size();
    }

    public static String[] nameArray(){
        String[] names = new String[playlists.size()];
        for(int i=0; i<playlists.size(); i++){
            names[i] = playlists.get(i).name();
        }
        return names;
    }

    public static Playlist get(int i){
        return playlists.get(i);
    }

    public static Playlist findByName(String name) {
        for (Playlist temp : playlists) {
            if (temp.name().equals(name)) {
                return temp;
            }
        }
        return null;
    }

    public static Playlist[] findBySong(Song song){
        List<Playlist> ret = new ArrayList<>();
        for(Playlist p : playlists){
            for(int i=0; i<p.length(); i++){
                if(p.get(i).equals(song)){
                    ret.add(p);
                    break;
                }
            }
        }
        return ret.toArray(new Playlist[ret.size()]);
    }// end findBySong method

}
