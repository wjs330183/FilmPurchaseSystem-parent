package com.ioe.dao;

import com.ioe.entity.OrderDetail;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface OrderDetailDao {

    int save(@Param("entity")OrderDetail entity);

    int saveBatch(@Param("entities")List<OrderDetail> entities);

    int update(@Param("entity")OrderDetail entity);

    List<OrderDetail> getById (@Param("id")String id, @Param("availData")int availData);

    int deleteById (String id, @Param("operator")String operator);



}
