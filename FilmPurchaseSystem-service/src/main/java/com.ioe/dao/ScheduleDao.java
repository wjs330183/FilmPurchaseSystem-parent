package com.ioe.dao;

import com.ioe.entity.Schedule;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface ScheduleDao {

    int save(@Param("entity")Schedule entity);

    int saveBatch(@Param("entities")List<Schedule> entities);

    int update(@Param("entity")Schedule entity);

    List<Schedule> getById (@Param("id")String id);

    int deleteById (String id, @Param("operator")String operator);



    /**
    * index:t_cjlu_schedule ==> Schedule_ID_UNIQUE
    */
    List<Schedule> getByScheduleId (String scheduleId);

}