package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import com.ioe.entity.Customer;
import java.util.*;
import java.math.BigDecimal;

/**
* 描述： 服务实现层接口
* @author wangjs
* @date 2018-04-19
*/
public interface CustomerService {


    /**
    * 单个保存
    * @param customerId 用户ID
	* @param customerName 用户姓名
	* @param customerEmail 用户邮箱
	* @param customerMobile 用户电话
	* @param classId 等级号
	
    * @param operator 操作者编号
    */
     DataResult<String>saveCustomer(String customerId, String customerName, String customerEmail, String customerMobile, String classId,  String operator);

    /**
    * 批量保存
    * @param customerJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    DataResult<Boolean> saveCustomerBatch(String customerJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Customer> getCustomerById (String id, int availData);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteCustomerById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param customerId 用户ID
	* @param customerName 用户姓名
	* @param customerEmail 用户邮箱
	* @param customerMobile 用户电话
	* @param classId 等级号
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateCustomer(String id, String customerId, String customerName, String customerEmail, String customerMobile, String classId, String operator);

    /**
    * 根据customerId查询记录
    *
        * @param customerId 用户ID
	
    */
    ListResult<Customer> getCustomerByCustomerId (String customerId, int availData);

}