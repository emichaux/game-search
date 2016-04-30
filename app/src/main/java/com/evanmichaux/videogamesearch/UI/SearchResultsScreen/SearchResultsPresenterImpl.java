package com.evanmichaux.videogamesearch.UI.SearchResultsScreen;

import com.evanmichaux.videogamesearch.DataModel.SearchResults;
import com.evanmichaux.videogamesearch.Services.GiantBombApiServiceI;
import com.evanmichaux.videogamesearch.Services.GiantBombApiServiceImpl;
import com.evanmichaux.videogamesearch.Services.OnRestCallComplete;

/**
 * Created by emichaux on 4/30/2016.
 */
public class SearchResultsPresenterImpl implements SearchResultsPresenterI, OnRestCallComplete {
    private SearchResultsViewI searchResultsView;
    private GiantBombApiServiceI apiService;

    public SearchResultsPresenterImpl(SearchResultsViewI searchResultsView) {
        this.searchResultsView = searchResultsView;
        this.apiService = new GiantBombApiServiceImpl();
    }

    @Override
    public void getGameInfo(String game) {
        apiService.getGameByName(game, this);
    }

    @Override
    public void onDataReceived(SearchResults results) {
        searchResultsView.setAdapterWithData(results);
    }

    @Override
    public void onFailure(String failureMessage) {
        searchResultsView.displayErrorMessage(failureMessage);

    }
}
