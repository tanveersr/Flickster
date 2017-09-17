package com.trandhawa.flickster.adapters;

import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.List;
import com.trandhawa.flickster.models.Movie;

/**
 * Created by trandhawa on 9/17/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }
}
