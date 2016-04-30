package com.evanmichaux.videogamesearch.Services;

import android.util.Log;

import com.evanmichaux.videogamesearch.DataModel.SearchResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by emichaux on 4/30/2016.
 */
public class GiantBombApiServiceImpl implements GiantBombApiServiceI {
    public static final String BASE_URL = "http://www.giantbomb.com/api/";
    private GiantBombApiEndpoint endpoint;

    public GiantBombApiServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endpoint = retrofit.create(GiantBombApiEndpoint.class);
    }


    public GiantBombApiEndpoint getApi() {
        return endpoint;
    }

    @Override
    public void getGameByName(String name, final OnRestCallComplete callFinished) {
        Call<SearchResults> call = getApi().getGameInfo(name, "game");
        call.enqueue(new Callback<SearchResults>() {

            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                if (response.isSuccessful()) {
                    callFinished.onDataReceived(response.body());
                } else {
                    Log.d("Failure Response", response.message());
                    callFinished.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<SearchResults> call, Throwable t) {
                callFinished.onFailure(t.getMessage());
                Log.d("Failure Response", t.getMessage());
            }
        });
    }

}
