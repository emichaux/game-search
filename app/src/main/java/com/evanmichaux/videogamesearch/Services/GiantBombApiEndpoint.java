package com.evanmichaux.videogamesearch.Services;

import com.evanmichaux.videogamesearch.DataModel.SearchResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by emichaux on 4/30/2016.
 */
public interface GiantBombApiEndpoint {
    String API_KEY = "ADD_API_KEY_HERE";

    @GET("search/?api_key=" + API_KEY + "&format=json")
    Call<SearchResults> getGameInfo(@Query("query") String game, @Query("resources") String type);

}
