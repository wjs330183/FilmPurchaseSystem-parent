package com.ioe.service.impl;

import com.ioe.dao.MovieDao;
import com.ioe.service.MovieService;
import com.ioe.utils.CommonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;
import com.ioe.stat.annotation.Stat;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import java.util.*;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.ioe.entity.Movie;
import com.ioe.service.Movie;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("movieService")
public class MovieServiceImpl implements MovieService {

    private static Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Resource
    private MovieDao movieDao;

    /**
    * 单个保存
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveMovie(
            String movieId,
            String movieName,
            String movieMainactor,
            String movieDirector,
            Date movieRelease,
            Date movieEnantiomer,
            String movieDescription,
            String operator
    ){
        DataResult<String> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            Movie movie = new Movie();
            movie.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            movie.setMovieId(movieId);
            movie.setMovieName(movieName);
            movie.setMovieMainactor(movieMainactor);
            movie.setMovieDirector(movieDirector);
            movie.setMovieRelease(movieRelease);
            movie.setMovieEnantiomer(movieEnantiomer);
            movie.setMovieDescription(movieDescription);
            movieDao.save(movie);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveMovie error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 批量保存
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Boolean> saveMovieBatch(String movieJson, String operator){
        if(CommonUtils.isEmpty(movieJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Movie> movieList = CommonUtils.getListByJson(movieJson, Movie.class);

            if (CommonUtils.isEmpty(movieList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            movieDao.saveBatch(movieList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveMovieBatch error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据id获取对象
    */
    @Override

    public ListResult<Movie> getMovieById (String id, int availData){
        ListResult<Movie> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Movie> movieList = movieDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(movieList)){
                result.setDataList(movieList);
            }
        } catch (Exception e){
            logger.error("saveMovieById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

    /**
    * 根据id删除对象
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteMovieById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = movieDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteMovieById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }



    /**
    * 更新对象
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> updateMovie (
                String id,
                String movieId,
                String movieName,
                String movieMainactor,
                String movieDirector,
                Date movieRelease,
                Date movieEnantiomer,
                String movieDescription,
                String operator
    ){
        DataResult<Boolean> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        Movie movie = new Movie();
        movie.setId(id);
        movie.setMovieId(movieId);
        movie.setMovieName(movieName);
        movie.setMovieMainactor(movieMainactor);
        movie.setMovieDirector(movieDirector);
        movie.setMovieRelease(movieRelease);
        movie.setMovieEnantiomer(movieEnantiomer);
        movie.setMovieDescription(movieDescription);
        movie.setSysCreateTime(sysCreateTime);
        movie.setSysCreator(sysCreator);
        movie.setSysUpdateTime(sysUpdateTime);
        movie.setSysUpdater(sysUpdater);
        movie.setSysDeleted(sysDeleted);
        movie.setSysHash(sysHash);
        movie.setSysAvailData(sysAvailData);
        movie.setSysUpdater(operator);
        movieDao.update(movie);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateMovie error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据movieId查询记录
    *
    * @param movieId 电影ID
	
    */
    @Override

    public ListResult<Movie> getMovieByMovieId (String movieId, int availData){
        ListResult<Movie> result = new ListResult();
        //TODO:数据校验
        //if(){
        //    result.setCode("1");
        //    result.setCode("1");
        //    return result;
        //}
        try{
            // TODO : 前置代码
            List<Movie> movieList = movieDao.getByMovieId(movieId, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(movieList)){
                result.setDataList(movieList);
            }
        } catch (Exception e){
            logger.error("getMovieByMovieId error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

}