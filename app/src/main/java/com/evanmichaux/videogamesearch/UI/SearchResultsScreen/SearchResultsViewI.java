package com.evanmichaux.videogamesearch.UI.SearchResultsScreen;

import com.evanmichaux.videogamesearch.DataModel.SearchResults;

/**
 * Created by emichaux on 4/30/2016.
 */
public interface SearchResultsViewI {
    void setAdapterWithData(SearchResults results);

    void displayErrorMessage(String message);
}
