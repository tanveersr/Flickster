package com.trandhawa.flickster.adapters;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import java.util.List;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trandhawa.flickster.R;
import com.trandhawa.flickster.models.Movie;

/**
 * Created by trandhawa on 9/17/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    // View lookup cache
    private static class ViewHolder {
        TextView title;
        TextView description;
    }


    public MovieArrayAdapter(Context context, List<Movie> movies){

        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // get data item for position
        Movie movie = getItem(position);
        ViewHolder viewHolder;

        // check the existing view being used
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            int orientation = getContext().getResources().getConfiguration().orientation;
            if(orientation == Configuration.ORIENTATION_PORTRAIT){
                convertView = inflater.inflate(R.layout.item_movie, parent, false);
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
                convertView = inflater.inflate(R.layout.item_movie_landscape, parent, false);
            }
            viewHolder.title = convertView.findViewById(R.id.tvTitle);
            viewHolder.description = convertView.findViewById(R.id.tvOverview);

            // cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        // clear out image from converView
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        // populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        // Populate the data from the data object via the viewHolder object
        // into the template view.

        viewHolder.title.setText(movie.getOriginalTitle());
        viewHolder.description.setText(movie.getOverview());

        return convertView;
    }
}
