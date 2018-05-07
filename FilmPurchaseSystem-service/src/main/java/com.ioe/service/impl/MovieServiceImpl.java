package com.ioe.service.impl;

import com.ioe.dao.MovieDao;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.MovieService;
import com.ioe.utils.CommonUtils;
import com.ioe.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;

import java.util.*;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ioe.entity.Movie;

/**
 * 描述：
 *
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
    ) {
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(movieId, movieName, movieMainactor, movieDirector, movieDescription, operator)
                && (movieRelease == null) && (movieEnantiomer == null)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            Movie movie = new Movie();
            movie.setId(SnowflakeIdWorkerUtils.getnextId(operator));
            movie.setMovieId(movieId);
            movie.setMovieName(movieName);
            movie.setMovieMainactor(movieMainactor);
            movie.setMovieDirector(movieDirector);
            movie.setMovieRelease(movieRelease);
            movie.setMovieEnantiomer(movieEnantiomer);
            movie.setMovieDescription(movieDescription);
            movie.setSysCreator(operator);
            movie.setSysUpdater(operator);
            movieDao.save(movie);
        } catch (Exception e) {
            logger.error("saveMovie error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveMovie is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 批量保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ListResult<String> saveMovieBatch(String movieJson, String operator) {
        ListResult<String> result = new ListResult<String>();
        if (CommonUtils.isEmpty(movieJson)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<Movie> movieList = CommonUtils.getListByJson(movieJson, Movie.class);

            List<String> ids = new ArrayList<String>();
            for (Movie movie : movieList) {
                movie.setId(SnowflakeIdWorkerUtils.getnextId(operator));
                ids.add(movie.getId());
            }
            movieDao.saveBatch(movieList);
            result.setDataList(ids);
        } catch (Exception e) {
            logger.error("saveMovieBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveMovieBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据id获取对象
     */
    @Override

    public ListResult<Movie> getMovieById(String id) {
        ListResult<Movie> result = new ListResult();
        if (CommonUtils.isEmpty(id)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Movie> movieList = movieDao.getById(id);

            result.setDataList(movieList);

        } catch (Exception e) {
            logger.error("saveMovieById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("getMovieById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteMovieById(String id, String operator) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            int count = movieDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e) {
            logger.error("deleteMovieById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteMovieById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 更新对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateMovie(
            String id,
            String movieId,
            String movieName,
            String movieMainactor,
            String movieDirector,
            Date movieRelease,
            Date movieEnantiomer,
            String movieDescription,
            String operator
    ) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id, movieId, movieName, movieMainactor, movieDirector, movieDescription, operator)
                && (movieRelease == null) && (movieEnantiomer == null)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            Movie movie = new Movie();
            movie.setId(id);
            movie.setMovieId(movieId);
            movie.setMovieName(movieName);
            movie.setMovieMainactor(movieMainactor);
            movie.setMovieDirector(movieDirector);
            movie.setMovieRelease(movieRelease);
            movie.setMovieEnantiomer(movieEnantiomer);
            movie.setMovieDescription(movieDescription);
            movie.setSysUpdater(operator);
            int count = movieDao.update(movie);
            result.setData(count);
        } catch (Exception e) {
            logger.error("updateMovie error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateMovie is error");
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
    public ListResult<Movie> getMovieByMovieId(String movieId) {
        ListResult<Movie> result = new ListResult();
        if (CommonUtils.isEmpty(movieId)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Movie> movieList = movieDao.getByMovieId(movieId);

            result.setDataList(movieList);

        } catch (Exception e) {
            logger.error("getMovieByMovieId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getMovieByMovieId is error");
        }
        return result;
    }

}