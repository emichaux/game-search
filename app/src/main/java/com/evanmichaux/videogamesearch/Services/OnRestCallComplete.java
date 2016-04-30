package com.evanmichaux.videogamesearch.Services;

import com.evanmichaux.videogamesearch.DataModel.SearchResults;

/**
 * Created by Evan PC on 4/30/2016.
 */
public interface OnRestCallComplete {
    void onDataReceived(SearchResults results);
    void onFailure(String failureMessage);
}
