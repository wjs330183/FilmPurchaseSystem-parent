package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.entity.Schedule;
import java.math.BigDecimal;

/**
* 描述： 服务实现层接口
* @author wangjs
* @date 2018-04-19
*/
public interface ScheduleService {


    /**
    * 单个保存
    * @param scheduleId 电影时间表ID
	* @param movieId 电影ID
	* @param hallId 放映厅ID
	* @param schedulePrice 票价
	* @param scheduleBegindatetime 放映时间
	
    * @param operator 操作者编号
    */
     DataResult<String>saveSchedule(String scheduleId, String movieId, String hallId, String schedulePrice, String scheduleBegindatetime,  String operator);

    /**
    * 批量保存
    * @param scheduleJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    ListResult<String> saveScheduleBatch(String scheduleJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Schedule> getScheduleById (String id);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteScheduleById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param scheduleId 电影时间表ID
	* @param movieId 电影ID
	* @param hallId 放映厅ID
	* @param schedulePrice 票价
	* @param scheduleBegindatetime 放映时间
	
    * @param operator 操作者编号
    */
    DataResult<Integer> updateSchedule(String id, String scheduleId, String movieId, String hallId, String schedulePrice, String scheduleBegindatetime, String operator);

    /**
    * 根据scheduleId查询记录
    *
        * @param scheduleId 电影时间表ID
	
    */
    ListResult<Schedule> getScheduleByScheduleId (String scheduleId);

}