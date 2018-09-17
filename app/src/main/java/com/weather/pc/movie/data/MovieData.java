package com.weather.pc.movie.data;

import android.os.AsyncTask;
import android.util.Log;

import com.weather.pc.movie.callback.MovieCallback;
import com.weather.pc.movie.entity.Movie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MovieData extends AsyncTask<Void,Void,List<Movie>> {

    private static final String BASE_URL="https://www.legend.com.kh/";
    private static final String URL=BASE_URL+"movies/comingsoon.aspx";
    private static final String Detail_URL="https://www.legend.com.kh/movies/";
    private List<Movie> movieList=new ArrayList<>();
    private MovieCallback callback;

    public MovieData(MovieCallback callback){
        this.callback=callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Loading....
        callback.onPreExecute();
    }

    @Override
    protected List<Movie> doInBackground(Void... voids) {
        try {
            Document document=Jsoup.connect(URL).get();
            Elements elements=document.select("div.text-center div.InfoGroup");
            for(Element ele:elements){
                String thumbnail=BASE_URL+ele.select("img").get(0).attr("src");
                String title=ele.select("span").get(0).text();
                String detail=Detail_URL+ele.select("a").get(0).attr("href");
                movieList.add(new Movie(thumbnail,title,detail));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return movieList;
    }

    @Override
    protected void onPostExecute(List<Movie> movieList) {
        super.onPostExecute(movieList);
        callback.onPostExecute(movieList);
    }
}
