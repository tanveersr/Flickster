package com.trandhawa.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by trandhawa on 9/17/17.
 */

public class Movie {

    String posterPath;
    String originalTitle;
    String overview;

    private static final String POSTER_PATH_PREFIX = "https://image.tmdb.org/t/p/w342/";

    public String getPosterPath() {
        return String.format(POSTER_PATH_PREFIX+"%s",posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Movie(JSONObject jsonObject) throws JSONException{
        posterPath = jsonObject.getString("poster_path");
        originalTitle = jsonObject.getString("original_title");
        overview = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){

        ArrayList<Movie> results = new ArrayList<Movie>();
        for(int i=0;i<array.length();i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
