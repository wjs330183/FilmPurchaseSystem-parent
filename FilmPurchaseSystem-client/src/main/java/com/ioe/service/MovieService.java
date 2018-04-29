package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.entity.Movie;
import java.util.*;

/**
* 描述： 服务实现层接口
* @author wangjs
* @date 2018-04-19
*/
public interface MovieService {


    /**
    * 单个保存
    * @param movieId 电影ID
	* @param movieName 电影名
	* @param movieMainactor 主演
	* @param movieDirector 导演
	* @param movieRelease 上映时间
	* @param movieEnantiomer 下映时间
	* @param movieDescription 说明
	
    * @param operator 操作者编号
    */
     DataResult<String>saveMovie(String movieId, String movieName, String movieMainactor, String movieDirector, Date movieRelease, Date movieEnantiomer, String movieDescription,  String operator);

    /**
    * 批量保存
    * @param movieJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    DataResult<Boolean> saveMovieBatch(String movieJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Movie> getMovieById (String id, int availData);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteMovieById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param movieId 电影ID
	* @param movieName 电影名
	* @param movieMainactor 主演
	* @param movieDirector 导演
	* @param movieRelease 上映时间
	* @param movieEnantiomer 下映时间
	* @param movieDescription 说明
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateMovie(String id, String movieId, String movieName, String movieMainactor, String movieDirector, Date movieRelease, Date movieEnantiomer, String movieDescription, String operator);

    /**
    * 根据movieId查询记录
    *
        * @param movieId 电影ID
	
    */
    ListResult<Movie> getMovieByMovieId (String movieId, int availData);

}