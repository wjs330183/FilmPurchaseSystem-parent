package com.ioe.dao;

import com.ioe.entity.Orderseat;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface OrderseatDao {

    int save(@Param("entity")Orderseat entity);

    int saveBatch(@Param("entities")List<Orderseat> entities);

    int update(@Param("entity")Orderseat entity);

    List<Orderseat> getById (@Param("id")String id, @Param("availData")int availData);

    int deleteById (String id, @Param("operator")String operator);



}