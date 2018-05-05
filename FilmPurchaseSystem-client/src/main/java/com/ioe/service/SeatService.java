package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.entity.Seat;


/**
* 描述： 服务实现层接口
* @author wangjs
* @date 2018-04-19
*/
public interface SeatService {


    /**
    * 单个保存
    * @param seatId 座位ID
	* @param hallId 放映厅ID
	* @param seatRow 座位的行
	* @param seatColumn 座位的列
	* @param seatIsactive 是否使用
	
    * @param operator 操作者编号
    */
     DataResult<String>saveSeat(String seatId, String hallId, String seatRow, String seatColumn, String seatIsactive,  String operator);

    /**
    * 批量保存
    * @param seatJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    ListResult<String> saveSeatBatch(String seatJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Seat> getSeatById (String id);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteSeatById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param seatId 座位ID
	* @param hallId 放映厅ID
	* @param seatRow 座位的行
	* @param seatColumn 座位的列
	* @param seatIsactive 是否使用
	
    * @param operator 操作者编号
    */
    DataResult<Integer> updateSeat(String id, String seatId, String hallId, String seatRow, String seatColumn, String seatIsactive, String operator);

    /**
    * 根据seatId查询记录
    *
        * @param seatId 座位ID
	
    */
    ListResult<Seat> getSeatBySeatId (String seatId);

}