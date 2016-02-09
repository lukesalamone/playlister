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
    private int length;
    private int playcount;

    // constructor
    public Song(){
        playcount = 0;
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
        int songLength = 0;
        length = songLength;
    }

    public void incrementPlaycount(){
        playcount++;
    }

    public String getURI(){
        return URI;
    }

    public String[] songInfo(){
        return new String[] {Title, Artist, Album,
                Integer.toString(length), Integer.toString(playcount)};
    }

    //return a CardView populated with song info
    public CardView card(){
        CardView card = new CardView(MainActivity.context());

        // TODO add stuff to the card

        return card;
    }//end card method
}
