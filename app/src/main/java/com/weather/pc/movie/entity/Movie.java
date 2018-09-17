package com.weather.pc.movie.entity;

public class Movie {
    private String thumbnail;
    private String title;
    private String detail;

    public Movie(String thumbnail, String title, String detail) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
