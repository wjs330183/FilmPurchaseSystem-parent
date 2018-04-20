package com.ioe.dao;

import com.ioe.entity.Customer;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface CustomerDao {

    int save(@Param("entity")Customer entity);

    int saveBatch(@Param("entities")List<Customer> entities);

    int update(@Param("entity")Customer entity);

    List<Customer> getById (@Param("id")String id, @Param("availData")int availData);

    int deleteById (String id, @Param("operator")String operator);



    /**
    * index:t_cjlu_customer ==> Customer_ID_UNIQUE
    */
    List<Customer> getByCustomerId (String customerId, @Param("availData")int availData);

}