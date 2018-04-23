package com.ioe.dao;

import com.ioe.entity.Orderdetail;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface OrderdetailDao {

    int save(@Param("entity")Orderdetail entity);

    int saveBatch(@Param("entities")List<Orderdetail> entities);

    int update(@Param("entity")Orderdetail entity);

    List<Orderdetail> getById (@Param("id")String id, @Param("availData")int availData);

    int deleteById (String id, @Param("operator")String operator);



}
