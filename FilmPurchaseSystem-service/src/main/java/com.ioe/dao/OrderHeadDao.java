package com.ioe.dao;

import com.ioe.entity.Orderhead;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface OrderHeadDao {

    int save(@Param("entity")Orderhead entity);

    int saveBatch(@Param("entities")List<Orderhead> entities);

    int update(@Param("entity")Orderhead entity);

    List<Orderhead> getById (@Param("id")String id, @Param("availData")int availData);

    int deleteById (String id, @Param("operator")String operator);



    /**
    * index:t_cjlu_orderhead ==> OrderHead_ID_UNIQUE
    */
    List<Orderhead> getByOrderheadId (String orderheadId, @Param("availData")int availData);

}
