package luke.com.playlist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static Context context;
    private Playlist playlist;
    private ArrayList<CardView> cardList;
    private LayoutInflater inflater;
    private ViewGroup content;

    public MainActivity(){
        // generating dummy songs
        Song song1 = new Song("youtube.com",
                "How to be eaten by a woman",
                "The Glitch Mob", "Drink the Sea", 360);

        Song song2 = new Song("soundcloud.com",
                "I Am You", "Haywyre", "Monstercat LP", 245);

        Song song3 = new Song("spotify.com",
                "Feeling Good", "Audra Mae", "sngle", 230);

        playlist = new Playlist("Dummy Playlist", new Song[]{song1, song2, song3});
        cardList = new ArrayList<>();
    }// end MainActivity constructor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = (LayoutInflater) getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        content = (ViewGroup) findViewById(R.id.content_main);
        context = getApplicationContext();
        findViewById(R.id.toolbar).setBackgroundColor(Color.argb(64, 0, 0, 0));

        //interface stuff
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //TODO generate from xml file

        explodePlaylist(playlist);
    }// end onCreate method

    @Override
    public void onStart(){
        super.onStart();
    }// end onStart method

    @Override
    public void onResume(){
        super.onResume();

        // try to add song from intent
        if(getIntent() != null) {
            Log.i("MainActivity onResume", getIntent().toString());
        } else {
            Log.i("MainActivity onResume", "Intent is null");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = new Intent(getApplicationContext(), PlaylistsActivity.class);

        if (id == R.id.nav_playlists) {
            intent = new Intent(getApplicationContext(), PlaylistsActivity.class);
        } else if (id == R.id.nav_stats) {
            intent = new Intent(getApplicationContext(), StatsActivity.class);
        } else if (id == R.id.nav_import) {
            intent = new Intent(getApplicationContext(), ImportActivity.class);
        } else if (id == R.id.nav_settings) {
            intent = new Intent(getApplicationContext(), SettingsActivity.class);
        } else if (id == R.id.nav_login) {
            intent = new Intent(getApplicationContext(), LoginActivity.class);
        } else if (id == R.id.nav_share) {
            intent = new Intent(getApplicationContext(), PlaylistsActivity.class);
        } else if (id == R.id.nav_about){
            intent = new Intent(getApplicationContext(), AboutActivity.class);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static Context context(){
        return context;
    }

    // Inflate playlist object into cards
    private void explodePlaylist(Playlist p){
        for(int i=0; i<p.length(); i++){
            addCard(i);
        }
    }

    // TODO this could be a lot cleaner
    // create card from song at position i and display it
    private void addCard(int i){

        Song song = playlist.get(i);
        String[] info = song.songInfo();
        CardView card;
        ImageView icon;
        TextView title;
        TextView artist;
        View layout;
        RelativeLayout.LayoutParams params;

        // left-oriented cards (even)
        if(i%2 == 0){
            Log.i("addCard", "adding card " + i);

            layout = inflater.inflate(R.layout.proto_card_left, content, false);
            content.addView(layout);                                    //TODO get correct index

            card = (CardView) findViewById(R.id.protoLeft);
            cardList.add(i, card);
            icon = (ImageView) findViewById(R.id.protoIconLeft);
            title = (TextView) findViewById(R.id.protoTitleLeft);
            artist = (TextView) findViewById(R.id.protoArtistLeft);

            card.setId(View.generateViewId());

            // icon stuff
            int imgSrc = getResources().getIdentifier(
                    song.source(),
                    "drawable",
                    getPackageName());
            icon.setId(View.generateViewId());
            icon.setImageResource(imgSrc);

            // title stuff
            title.setId(View.generateViewId());
            title.setText(info[0]);
            params = ((RelativeLayout.LayoutParams) title.getLayoutParams());
            params.addRule(RelativeLayout.RIGHT_OF, icon.getId());

            artist.setId(View.generateViewId());
            artist.setText(info[1]);
            params = ((RelativeLayout.LayoutParams) artist.getLayoutParams());
            params.addRule(RelativeLayout.RIGHT_OF, icon.getId());
            params.addRule(RelativeLayout.BELOW, title.getId());

            // set card below previous card
            if(i != 0){
                params = ((RelativeLayout.LayoutParams) card.getLayoutParams());
                params.addRule(RelativeLayout.BELOW, cardList.get(i - 1).getId());
            }
        } else { // right-oriented cards (odd)
            Log.i("addCard", "adding card " + i);

            layout = inflater.inflate(R.layout.proto_card_right, content, false);
            content.addView(layout);                                //TODO get correct index

            card = (CardView) findViewById(R.id.protoRight);
            cardList.add(i, card);

            icon = (ImageView) findViewById(R.id.protoIconRight);
            title = (TextView) findViewById(R.id.protoTitleRight);
            artist = (TextView) findViewById(R.id.protoArtistRight);

            card.setId(View.generateViewId());

            // icon stuff
            icon.setId(View.generateViewId());
            int imgSrc = getResources().getIdentifier(
                    song.source(),
                    "drawable",
                    getPackageName());
            icon.setImageResource(imgSrc);

            // title stuff
            title.setId(View.generateViewId());
            title.setText(info[0]);

            artist.setId(View.generateViewId());
            artist.setText(info[1]);
            params = ((RelativeLayout.LayoutParams) artist.getLayoutParams());
            params.addRule(RelativeLayout.BELOW, title.getId());

            // set card below previous card
            params = ((RelativeLayout.LayoutParams) card.getLayoutParams());
            params.addRule(RelativeLayout.BELOW, cardList.get(i - 1).getId());
        }
    }// end addCard method
}