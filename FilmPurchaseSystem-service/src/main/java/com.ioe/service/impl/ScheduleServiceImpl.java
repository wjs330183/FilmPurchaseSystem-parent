package com.ioe.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;
import com.ioe.stat.annotation.Stat;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import java.util.*;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.ioe.entity.Schedule;
import com.ioe.service.Schedule;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    private static Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Resource
    private ScheduleDao scheduleDao;

    /**
    * 单个保存
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveSchedule(
            String scheduleId,
            String movieId,
            String hallId,
            BigDecimal schedulePrice,
            String scheduleBegindatetime,
            String operator
    ){
        DataResult<String> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            Schedule schedule = new Schedule();
            schedule.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            schedule.setScheduleId(scheduleId);
            schedule.setMovieId(movieId);
            schedule.setHallId(hallId);
            schedule.setSchedulePrice(schedulePrice);
            schedule.setScheduleBegindatetime(scheduleBegindatetime);
            schedule.setSysCreateTime(sysCreateTime);
            schedule.setSysCreator(sysCreator);
            schedule.setSysUpdateTime(sysUpdateTime);
            schedule.setSysUpdater(sysUpdater);
            schedule.setSysDeleted(sysDeleted);
            schedule.setSysHash(sysHash);
            schedule.setSysAvailData(sysAvailData);
            scheduleDao.save(schedule);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveSchedule error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 批量保存
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> saveScheduleBatch (String scheduleJson, String operator){
        if(CommonUtils.isEmpty(scheduleJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Schedule> scheduleList = CommonUtils.getListByJson(scheduleJson, Schedule.class);

            if (CommonUtils.isEmpty(scheduleList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            scheduleDao.saveBatch(scheduleList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveScheduleBatch error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据id获取对象
    */
    @Override
    @Stat
    public ListResult<Schedule> getScheduleById (String id, int availData){
        ListResult<Schedule> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Schedule> scheduleList = scheduleDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(scheduleList)){
                result.setDataList(scheduleList);
            }
        } catch (Exception e){
            logger.error("saveScheduleById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

    /**
    * 根据id删除对象
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteScheduleById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = scheduleDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteScheduleById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }



    /**
    * 更新对象
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> updateSchedule (
                String id,
                String scheduleId,
                String movieId,
                String hallId,
                BigDecimal schedulePrice,
                String scheduleBegindatetime,
                String operator
    ){
        DataResult<Boolean> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        Schedule schedule = new Schedule();
        schedule.setId(id);
        schedule.setScheduleId(scheduleId);
        schedule.setMovieId(movieId);
        schedule.setHallId(hallId);
        schedule.setSchedulePrice(schedulePrice);
        schedule.setScheduleBegindatetime(scheduleBegindatetime);
        schedule.setSysCreateTime(sysCreateTime);
        schedule.setSysCreator(sysCreator);
        schedule.setSysUpdateTime(sysUpdateTime);
        schedule.setSysUpdater(sysUpdater);
        schedule.setSysDeleted(sysDeleted);
        schedule.setSysHash(sysHash);
        schedule.setSysAvailData(sysAvailData);
        schedule.setSysUpdater(operator);
        scheduleDao.update(schedule);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateSchedule error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据scheduleId查询记录
    *
    * @param scheduleId 电影时间表ID
	
    */
    @Override
    @Stat
    public ListResult<Schedule> getScheduleByScheduleId (String scheduleId, int availData){
        ListResult<Schedule> result = new ListResult();
        //TODO:数据校验
        //if(){
        //    result.setCode("1");
        //    result.setCode("1");
        //    return result;
        //}
        try{
            // TODO : 前置代码
            List<Schedule> scheduleList = scheduleDao.getByScheduleId(scheduleId, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(scheduleList)){
                result.setDataList(scheduleList);
            }
        } catch (Exception e){
            logger.error("getScheduleByScheduleId error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

}