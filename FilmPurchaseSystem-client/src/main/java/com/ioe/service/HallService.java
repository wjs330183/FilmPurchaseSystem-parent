package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import com.ioe.entity.Hall;
import java.util.*;
import java.math.BigDecimal;

/**
* 描述： 服务实现层接口
* @author wangjs
* @date 2018-04-19
*/
public interface HallService {


    /**
    * 单个保存
    * @param hallId 放映厅ID号
	* @param hallSeats 座位数量
	* @param hallDescription 说明
	
    * @param operator 操作者编号
    */
     DataResult<String>saveHall(String hallId, String hallSeats, String hallDescription,  String operator);

    /**
    * 批量保存
    * @param hallJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    DataResult<Boolean> saveHallBatch(String hallJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Hall> getHallById (String id, int availData);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteHallById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param hallId 放映厅ID号
	* @param hallSeats 座位数量
	* @param hallDescription 说明
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateHall(String id, String hallId, String hallSeats, String hallDescription, String operator);

    /**
    * 根据hallId查询记录
    *
        * @param hallId 放映厅ID号
	
    */
    ListResult<Hall> getHallByHallId (String hallId, int availData);

}