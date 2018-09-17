package com.weather.pc.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weather.pc.movie.R;
import com.weather.pc.movie.callback.MovieClickListener;
import com.weather.pc.movie.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<Movie> movieList;
    Context context;
    private MovieClickListener listener;

    public MovieAdapter(Context context) {
        this.context=context;
        movieList=new ArrayList<>();
    }

    public void OnConnect(MovieClickListener listener){
        this.listener=listener;
    }
    public void AddMovie(List<Movie> movieList){
        this.movieList.addAll(movieList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_layout,viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie=movieList.get(position);
        holder.mvtitle.setText(movie.getTitle());
        Picasso.get()
                .load(movie.getThumbnail())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.mvthumbnail);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView mvthumbnail;
        TextView mvtitle;
        public MovieViewHolder(View itemView) {
            super(itemView);

            mvthumbnail=itemView.findViewById(R.id.mvthumbnail);
            mvtitle=itemView.findViewById(R.id.mvtitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(movieList.get(getAdapterPosition()).getDetail());
                }
            });
        }
    }
}
