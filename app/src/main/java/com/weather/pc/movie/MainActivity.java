package com.weather.pc.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.weather.pc.movie.adapter.MovieAdapter;
import com.weather.pc.movie.callback.MovieCallback;
import com.weather.pc.movie.callback.MovieClickListener;
import com.weather.pc.movie.data.MovieData;
import com.weather.pc.movie.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieCallback,MovieClickListener{

    private RecyclerView rcvMovie;
    private MovieAdapter adapter;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvMovie=findViewById(R.id.rcvMovie);
        movieList=new ArrayList<>();
        GridLayoutManager manager=new GridLayoutManager(this,2);
        rcvMovie.setLayoutManager(manager);
        new MovieData(this).execute();
        adapter.OnConnect(this);
        adapter=new MovieAdapter(this);
        rcvMovie.setAdapter(adapter);
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onPostExecute(List<Movie> movieList) {
        adapter.AddMovie(movieList);
    }


    @Override
    public void OnItemClick(String url) {
        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}
