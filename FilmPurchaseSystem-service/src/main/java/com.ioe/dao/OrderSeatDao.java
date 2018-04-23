package com.ioe.dao;

import com.ioe.entity.OrderSeat;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface OrderSeatDao {

    int save(@Param("entity")OrderSeat entity);

    int saveBatch(@Param("entities")List<OrderSeat> entities);

    int update(@Param("entity")OrderSeat entity);

    List<OrderSeat> getById (@Param("id")String id, @Param("availData")int availData);

    int deleteById (String id, @Param("operator")String operator);



}