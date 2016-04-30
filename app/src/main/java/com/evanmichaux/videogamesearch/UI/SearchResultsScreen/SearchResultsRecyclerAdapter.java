package com.evanmichaux.videogamesearch.UI.SearchResultsScreen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evanmichaux.videogamesearch.DataModel.Platform;
import com.evanmichaux.videogamesearch.DataModel.SearchResults;
import com.evanmichaux.videogamesearch.R;
import com.squareup.picasso.Picasso;


/**
 * Created by emichaux on 4/30/2016.
 */
public class SearchResultsRecyclerAdapter extends RecyclerView.Adapter<SearchResultsRecyclerAdapter.RecyclerViewHolder> {

    private Context context;
    private SearchResults gameResults;

    public SearchResultsRecyclerAdapter(Context context, SearchResults gameResults) {
        this.context = context;
        this.gameResults = gameResults;
    }


    @Override
    public SearchResultsRecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        RecyclerViewHolder vh = new RecyclerViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SearchResultsRecyclerAdapter.RecyclerViewHolder holder, int position) {
        if(gameResults.getResults().get(position).getImage() != null)
            Picasso.with(context).load(gameResults.getResults().get(position).getImage().getSmallUrl()).resize(265, 320)
                .into(holder.gameImage);
        holder.title.setText(gameResults.getResults().get(position).getName());
        holder.deck.setText(gameResults.getResults().get(position).getDeck());
        holder.gameUrl = gameResults.getResults().get(position).getSiteDetailUrl();

        String dateReleased = gameResults.getResults().get(position).getOriginalReleaseDate();
        if(dateReleased != null && !dateReleased.isEmpty()) {
            dateReleased = dateReleased.substring(0, dateReleased.length() - 9);
            holder.dateReleased.setText(" " + dateReleased);
        }

        if(gameResults.getResults().get(position).getPlatforms() != null) {
            String platforms = "";
            for (Platform p : gameResults.getResults().get(position).getPlatforms()) {
                platforms += p.getName() + ", ";
            }
            holder.platform.setText(platforms.substring(0, platforms.length() - 2));
        }

    }

    @Override
    public int getItemCount() {
        return gameResults.getResults().size();
    }

    public void refreshData(SearchResults results) {
        gameResults = results;
        notifyDataSetChanged();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public View cardViewLayout;
        TextView title, deck, dateReleased, platform;
        ImageView gameImage;
        String gameUrl;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            deck = (TextView) itemView.findViewById(R.id.deck);
            dateReleased = (TextView) itemView.findViewById(R.id.dateReleased);
            platform = (TextView) itemView.findViewById(R.id.platform);
            gameImage = (ImageView) itemView.findViewById(R.id.gameImage);

            cardViewLayout = itemView.findViewById(R.id.relativeLayoutItem);
            cardViewLayout.setOnClickListener(rowClickListener);
        }
        private View.OnClickListener rowClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameUrl != null && !gameUrl.isEmpty()) {
                    Intent urlIntent = new Intent(Intent.ACTION_VIEW);
                    urlIntent.setData(Uri.parse(gameUrl));
                    context.startActivity(urlIntent);
                }
            }
        };
    }


}
