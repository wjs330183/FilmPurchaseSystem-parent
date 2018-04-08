package com.ioe.entity;

import java.sql.Date;

public class Movie {
    /**
     * 电影ID
     */
    private String movieID;
    /**
     * 电影名
     */
    private String movieName;
    /**
     * 主演
     */
    private String movieMainActor;
    /**
     * 导演
     */
    private String movieDirector;
    /**
     * 上映时间
     */
    private Date movieRelease;
    /**
     * 下映时间
     */
    private Date movieEnantiomer;
    /**
     * 说明
     */
    private int movieDisable;
    /**
     * 是否删除 1删0不删
     */

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovieMainActor() {
        return movieMainActor;
    }

    public void setMovieMainActor(String movieMainActor) {
        this.movieMainActor = movieMainActor;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(Date movieRelease) {
        this.movieRelease = movieRelease;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public int getMovieDisable() {
        return movieDisable;
    }

    public void setMovieDisable(int movieDisable) {
        this.movieDisable = movieDisable;
    }

    public Date getMovieEnantiomer() {
        return movieEnantiomer;
    }

    public void setMovieEnantiomer(Date movieEnantiomer) {
        this.movieEnantiomer = movieEnantiomer;
    }
}
