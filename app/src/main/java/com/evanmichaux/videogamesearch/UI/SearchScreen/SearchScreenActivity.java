package com.evanmichaux.videogamesearch.UI.SearchScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.evanmichaux.videogamesearch.R;
import com.evanmichaux.videogamesearch.UI.SearchResultsScreen.SearchResultsActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchScreenActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView titleText;
    @Bind(R.id.gameSearchText)
    EditText gameSearchText;
    @Bind(R.id.searchButton)
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.searchButton)
    public void searchGame() {
        String searchCriteria = gameSearchText.getText().toString();
        if(!searchCriteria.isEmpty())
            openResultsActivity(searchCriteria);
    }

    private void openResultsActivity(String searchCriteria){
        Intent searchActivity = new Intent(this, SearchResultsActivity.class);
        searchActivity.putExtra("searchCriteria", searchCriteria);
        startActivity(searchActivity);
    }
}
