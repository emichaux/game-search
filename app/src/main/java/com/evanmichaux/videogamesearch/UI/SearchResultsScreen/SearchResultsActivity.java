package com.evanmichaux.videogamesearch.UI.SearchResultsScreen;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.evanmichaux.videogamesearch.DataModel.SearchResults;
import com.evanmichaux.videogamesearch.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchResultsActivity extends AppCompatActivity implements SearchResultsViewI {

    @Bind(R.id.cardList)
    RecyclerView cardList;
    @Bind(R.id.searching_text)
    TextView searchingText;

    private SearchResultsPresenterI presenter;
    private LinearLayoutManager linearLayoutManager;
    private SearchResultsRecyclerAdapter adapter;
    private SearchResults gameResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);

        showSearchingText();
        linearLayoutManager = new LinearLayoutManager(this);
        cardList.setLayoutManager(linearLayoutManager);

        presenter = new SearchResultsPresenterImpl(this);
        String searchCriteria = (String) getIntent().getSerializableExtra("searchCriteria");

        if(savedInstanceState == null || !savedInstanceState.containsKey("gameResults")) {
            presenter.getGameInfo(searchCriteria);
        }
        else {
            gameResults = savedInstanceState.getParcelable("gameResults");
            hideSearchingText();
            setAdapter();
        }
    }


    private void setAdapter() {
        adapter = new SearchResultsRecyclerAdapter(this, gameResults);
        cardList.setHasFixedSize(true);
        cardList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search_results, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) this.getSystemService(this.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newGame) {
                presenter.getGameInfo(newGame);
                showSearchingText();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void updateAdapterData() {
        adapter.refreshData(gameResults);
    }

    @Override
    public void setAdapterWithData(SearchResults results) {
        gameResults = results;
        if (results.getResults().size() > 0) {
            hideSearchingText();
            if(adapter == null)
                setAdapter();
            else
                updateAdapterData(); //refresh with new data
        }
        else {
            searchingText.setText(R.string.nothing_found);
        }

    }

    @Override
    public void displayErrorMessage(String message) {
        hideSearchingText();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void hideSearchingText() {
        searchingText.setVisibility(View.GONE);
        cardList.setVisibility(View.VISIBLE);
    }
    private void showSearchingText() {
        searchingText.setVisibility(View.VISIBLE);
        cardList.setVisibility(View.GONE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("gameResults", gameResults);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
