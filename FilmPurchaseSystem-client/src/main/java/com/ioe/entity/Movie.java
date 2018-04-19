package com.ioe.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public class Movie extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *电影ID
    */
    private String movieId;

    /**
    *电影名
    */
    private String movieName;

    /**
    *主演
    */
    private String movieMainactor;

    /**
    *导演
    */
    private String movieDirector;

    /**
    *上映时间
    */
    private Date movieRelease;

    /**
    *下映时间
    */
    private Date movieEnantiomer;

    /**
    *说明
    */
    private String movieDescription;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getMovieMainactor() {
        return this.movieMainactor;
    }

    public void setMovieMainactor(String movieMainactor) {
        this.movieMainactor = movieMainactor;
    }
    public String getMovieDirector() {
        return this.movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }
    public Date getMovieRelease() {
        return this.movieRelease;
    }

    public void setMovieRelease(Date movieRelease) {
        this.movieRelease = movieRelease;
    }
    public Date getMovieEnantiomer() {
        return this.movieEnantiomer;
    }

    public void setMovieEnantiomer(Date movieEnantiomer) {
        this.movieEnantiomer = movieEnantiomer;
    }
    public String getMovieDescription() {
        return this.movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

}