package com.ioe.dao;

import com.ioe.entity.Hall;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface HallDao {

    int save(@Param("entity")Hall entity);

    int saveBatch(@Param("entities")List<Hall> entities);

    int update(@Param("entity")Hall entity);

    List<Hall> getById (@Param("id")String id);

    int deleteById (String id, @Param("operator")String operator);



    /**
    * index:t_cjlu_hall ==> Hall_ID_UNIQUE
    */
    List<Hall> getByHallId (String hallId);

}