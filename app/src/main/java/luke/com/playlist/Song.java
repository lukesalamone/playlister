package luke.com.playlist;

import android.support.v7.widget.CardView;

/**
 * Created by luke on 2/8/16.
 */
public class Song {

    private String URI;                                     // source of song
    private String Title;
    private String Artist;
    private String Album;
    private int Length;
    private int playcount;
    private int ID;
    private String source;

    // default constructor
    public Song(){
        playcount = 0;
    }

    public Song(String uri, String title, String artist, String album, int length){
        URI = uri;
        Title = title;
        Artist = artist;
        Album = album;
        Length = length;
        ID = 0;

        // TODO account for short urls
        if(uri.contains("youtube")){
            source = "youtube";
        } else if(uri.contains("spotify")){
            source = "spotify";
        } else if(uri.contains("soundcloud")){
            source = "soundcloud";
        }

        if(source.equals("")){
            source = "youtube";
        }

    }

    public void setURI(String uri){
        URI = uri;
    }

    public void setTitle(String title){
        Title = title;
    }

    public void setArtist(String artist){
        Artist = artist;
    }

    public void setAlbum(String album){
        Album = album;
    }

    public void setLength(){
        //TODO get song length. Method will vary by URI.
        Length = 0;
    }

    public void incrementPlaycount(){
        playcount++;
    }

    public String getURI(){
        return URI;
    }

    public String[] songInfo(){
        return new String[] {Title, Artist, Album,
                Integer.toString(Length), Integer.toString(playcount)};
    }

    //return a CardView populated with song info
    public CardView card(){
        CardView card = new CardView(MainActivity.context());

        // TODO add stuff to the card

        return card;
    }//end card method

    public int id(){
        return ID;
    }

    public void setID(int id){
        ID = id;
    }

    public String source(){
        return source;
    }
}
