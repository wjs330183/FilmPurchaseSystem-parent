package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import com.ioe.entity.Orderseat;
import java.util.*;
import java.math.BigDecimal;

/**
* 描述： 服务实现层接口
* @author wangjs
* @date 2018-04-19
*/
public interface OrderseatService {


    /**
    * 单个保存
    * @param orderdetailId 订单明细ID
	* @param seatId 预定座位ID
	
    * @param operator 操作者编号
    */
     DataResult<String>saveOrderseat(String orderdetailId, String seatId,  String operator);

    /**
    * 批量保存
    * @param orderseatJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    DataResult<Boolean> saveOrderseatBatch(String orderseatJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Orderseat> getOrderseatById (String id, int availData);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteOrderseatById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param orderdetailId 订单明细ID
	* @param seatId 预定座位ID
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateOrderseat(String id, String orderdetailId, String seatId, String operator);

}