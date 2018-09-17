package com.weather.pc.movie.callback;

import com.weather.pc.movie.entity.Movie;

import java.util.List;

public interface MovieCallback {
    void onPreExecute();
    void onPostExecute(List<Movie> movieList);
}
