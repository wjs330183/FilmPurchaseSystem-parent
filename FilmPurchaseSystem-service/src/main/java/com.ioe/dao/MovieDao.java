package com.ioe.dao;

import com.ioe.entity.Movie;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface MovieDao {

    int save(@Param("entity")Movie entity);

    int saveBatch(@Param("entities")List<Movie> entities);

    int update(@Param("entity")Movie entity);

    List<Movie> getById (@Param("id")String id);

    int deleteById (String id, @Param("operator")String operator);



    /**
    * index:t_cjlu_movie ==> Movie_ID_UNIQUE
    */
    List<Movie> getByMovieId (String movieId);

}