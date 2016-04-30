package com.evanmichaux.videogamesearch.Services;

/**
 * Created by emichaux on 4/30/2016.
 */
public interface GiantBombApiServiceI {
    void getGameByName(String name, OnRestCallComplete callFinished);
}
