package luke.com.playlist;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by luke on 2/8/16.
 */
public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {
    private Playlist playlist;

    //constructor
    public PlaylistAdapter() {
        //TODO
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;

        public ViewHolder(CardView c) {
            super(c);
            cardView = c;
        }

        public void set(CardView c){
            cardView = c;
        }
    }//end ViewHolder subclass

    // Add cards to view
    // TODO
    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        Log.i("onCreateViewHolder", "init");
        CardView cardView = new CardView(parent.getContext());
        Log.i("onCreateViewHolder", "returning");
        return new ViewHolder(cardView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.set(playlist.get(position).card());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return playlist.length();
    }
}
