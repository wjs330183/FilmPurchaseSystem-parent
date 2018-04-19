package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import com.ioe.entity.Orderdetail;
import java.util.*;
import java.math.BigDecimal;

/**
* 描述： 服务实现层接口
* @author wangjs
* @date 2018-04-19
*/
public interface OrderdetailService {


    /**
    * 单个保存
    * @param orderdetailId 订单明细ID
	* @param orderheadId 订单ID
	* @param scheduleId 电影时间表ID
	* @param orderdetailAdjustedprice 打折后的价格
	
    * @param operator 操作者编号
    */
     DataResult<String>saveOrderdetail(String orderdetailId, String orderheadId, String scheduleId, BigDecimal orderdetailAdjustedprice,  String operator);

    /**
    * 批量保存
    * @param orderdetailJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    DataResult<Boolean> saveOrderdetailBatch(String orderdetailJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Orderdetail> getOrderdetailById (String id, int availData);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteOrderdetailById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param orderdetailId 订单明细ID
	* @param orderheadId 订单ID
	* @param scheduleId 电影时间表ID
	* @param orderdetailAdjustedprice 打折后的价格
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateOrderdetail(String id, String orderdetailId, String orderheadId, String scheduleId, BigDecimal orderdetailAdjustedprice, String operator);

}