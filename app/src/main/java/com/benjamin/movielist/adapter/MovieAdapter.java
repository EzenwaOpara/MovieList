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

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends ArrayAdapter<MovieResults.ResultsBean> {
    private int mImageResourceId;

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
//        titleTV.setText(currentMovie.getMovieTitle());

        TextView premiereTV = listView.findViewById(R.id.release_date);
//        premiereTV.setText(currentMovie.getPremiere());

        TextView directorTV = listView.findViewById(R.id.original_language);
//        directorTV.setText(currentMovie.getDirector());

//        titleTextView.setText(movie.getTitle());
//        dateTextView.setText(movie.getRelease_date());
//        languageTextView.setText(movie.getOriginal_language());

        return listView;
    }
}
