package luke.com.playlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;

/**
 * Receives intents from outside applications
 *
 * Created by luke on 2/23/16.
 */
public class AddSongActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Bundle extras;
    private String url;
    private Spinner spinner;
    private Playlist playlist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsong);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.activity_addsong,
                PlaylistManager.nameArray());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }// end onCreate method

    @Override
    protected void onStart(){
        super.onStart();
    }// end onStart method

    @Override
    protected void onResume(){
        super.onResume();
        extras = getIntent().getExtras();
        url = extras.getString(Intent.EXTRA_TEXT);
        url = url.toLowerCase();

        //TODO add card to MainActivity
        if(url.contains("youtube") || url.contains("youtu.be")){
            playlist.addYoutube(url);
            //addCard(playlist.length() - 1);
        }
    }// end onResume method

    @Override
    protected void onStop(){
        super.onStop();
    }// end onStop method

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }// end onDestroy method

    // An item was selected. You can retrieve the selected item using
    // parent.getItemAtPosition(pos)
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        playlist = PlaylistManager.get(pos);
    }// end onItemSelected method

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}