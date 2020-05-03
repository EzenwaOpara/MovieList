package com.benjamin.movielist.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.benjamin.movielist.adapter.MovieAdapter;
import com.benjamin.movielist.model.APIInterface;
import com.benjamin.movielist.model.MovieResults;
import com.benjamin.movielist.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String BASE_URL = "https://api.themoviedb.org";
    public static String API_KEY = "my_api_key";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";
    public static int PAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);

        Call<MovieResults> call = apiInterface.listOfMovies(CATEGORY, API_KEY, LANGUAGE, PAGE);

        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
                List<MovieResults.ResultsBean> listOfMovies = results.getResults();

                MovieAdapter adapter = new MovieAdapter(MainActivity.this, 0, listOfMovies);
                ListView listView = findViewById(R.id.list_view);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

