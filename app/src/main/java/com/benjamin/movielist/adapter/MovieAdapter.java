package com.benjamin.movielist.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.benjamin.movielist.R;
import com.benjamin.movielist.model.MovieResults;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<MovieResults.ResultsBean> {

    public MovieAdapter(@NonNull Context context, int resource, @NonNull List<MovieResults.ResultsBean> movies) {
        super(context, 0, movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MovieResults.ResultsBean currentMovie = getItem(position);

        View listView = convertView;
        if (listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.movie_list, parent, false);
        }
        TextView titleTV = listView.findViewById(R.id.movie_title);
        TextView dateTV = listView.findViewById(R.id.release_date);
        TextView langTV = listView.findViewById(R.id.original_language);
        TextView ratingTV = listView.findViewById(R.id.rating);
        TextView overviewTV = listView.findViewById(R.id.overview);
        ImageView imageView = listView.findViewById(R.id.movie_image);

        titleTV.setText(currentMovie.getTitle());
        dateTV.setText(currentMovie.getRelease_date());
        langTV.setText(currentMovie.getOriginal_language());
        ratingTV.setText(Double.toString(currentMovie.getVote_average()));
        overviewTV.setText(currentMovie.getOverview());

        String url = "https://image.tmdb.org/t/p/original" + currentMovie.getPoster_path();
        Picasso.with(getContext()).load(url).into(imageView);

        return listView;
    }
}
