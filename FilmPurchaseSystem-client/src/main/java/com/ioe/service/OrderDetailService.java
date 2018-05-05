package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.entity.OrderDetail;
import java.math.BigDecimal;

/**
* 描述： 服务实现层接口
* @author wangjs
* @date 2018-04-19
*/
public interface OrderDetailService {


    /**
    * 单个保存
    * @param orderdetailId 订单明细ID
	* @param orderheadId 订单ID
	* @param scheduleId 电影时间表ID
	* @param orderdetailAdjustedprice 打折后的价格
	
    * @param operator 操作者编号
    */
     DataResult<String>saveOrderdetail(String orderdetailId, String orderheadId, String scheduleId, String orderdetailAdjustedprice,  String operator);

    /**
    * 批量保存
    * @param orderdetailJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    ListResult<String>  saveOrderdetailBatch(String orderdetailJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<OrderDetail> getOrderdetailById (String id);

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
    DataResult<Integer> updateOrderdetail(String id, String orderdetailId, String orderheadId, String scheduleId, String orderdetailAdjustedprice, String operator);

    /**
     * 根据orderdetailId查询记录
     *
     * @param orderdetailId 订单ID

     */
    ListResult<OrderDetail> getOrderdetailByOrderdetailId (String orderdetailId);
}