package com.ioe.service.impl;

import com.ioe.dao.ScheduleDao;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.ScheduleService;
import com.ioe.utils.CommonUtils;
import com.ioe.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;

import java.util.*;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ioe.entity.Schedule;

/**
 * 描述：
 *
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

    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveSchedule(
            String scheduleId,
            String movieId,
            String hallId,
            String schedulePrice,
            String scheduleBegindatetime,
            String operator
    ) {
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(scheduleId, movieId, hallId, schedulePrice, scheduleBegindatetime, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            Schedule schedule = new Schedule();
            schedule.setId(SnowflakeIdWorkerUtils.getnextId(operator));
            schedule.setScheduleId(scheduleId);
            schedule.setMovieId(movieId);
            schedule.setHallId(hallId);
            schedule.setSchedulePrice(new BigDecimal(schedulePrice));
            schedule.setScheduleBegindatetime(scheduleBegindatetime);
            schedule.setSysCreator(operator);
            schedule.setSysUpdater(operator);
            scheduleDao.save(schedule);

        } catch (Exception e) {
            logger.error("saveSchedule error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveSchedule is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 批量保存
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public ListResult<String> saveScheduleBatch(String scheduleJson, String operator) {
        ListResult<String> result = new ListResult<String>();
        if (CommonUtils.isEmpty(scheduleJson)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<Schedule> scheduleList = CommonUtils.getListByJson(scheduleJson, Schedule.class);

            List<String> ids = new ArrayList<String>();
            for (Schedule schedule : scheduleList) {
                schedule.setId(SnowflakeIdWorkerUtils.getnextId(operator));
                ids.add(schedule.getId());
            }
            scheduleDao.saveBatch(scheduleList);
            result.setDataList(ids);


        } catch (Exception e) {
            logger.error("saveScheduleBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveScheduleBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据id获取对象
     */
    @Override

    public ListResult<Schedule> getScheduleById(String id) {
        ListResult<Schedule> result = new ListResult();
        if (CommonUtils.isEmpty(id)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Schedule> scheduleList = scheduleDao.getById(id);

            result.setDataList(scheduleList);

        } catch (Exception e) {
            logger.error("getScheduleById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("getScheduleById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteScheduleById(String id, String operator) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            int count = scheduleDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e) {
            logger.error("deleteScheduleById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteScheduleById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 更新对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateSchedule(
            String id,
            String scheduleId,
            String movieId,
            String hallId,
            String schedulePrice,
            String scheduleBegindatetime,
            String operator
    ) {
        DataResult<Integer> result = new DataResult();

        if (CommonUtils.isAnyEmpty(id, scheduleId, movieId, hallId, schedulePrice,scheduleBegindatetime, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            Schedule schedule = new Schedule();
            schedule.setId(id);
            schedule.setScheduleId(scheduleId);
            schedule.setMovieId(movieId);
            schedule.setHallId(hallId);
            schedule.setSchedulePrice(new BigDecimal(schedulePrice));
            schedule.setScheduleBegindatetime(scheduleBegindatetime);
            schedule.setSysUpdater(operator);
            int count = scheduleDao.update(schedule);
            result.setData(count);

        } catch (Exception e) {
            logger.error("updateSchedule error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateSchedule is error");
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

    public ListResult<Schedule> getScheduleByScheduleId(String scheduleId) {
        ListResult<Schedule> result = new ListResult();
        if (CommonUtils.isEmpty(scheduleId)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Schedule> scheduleList = scheduleDao.getByScheduleId(scheduleId);

                result.setDataList(scheduleList);

        } catch (Exception e) {
            logger.error("getScheduleByScheduleId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getScheduleByScheduleId is error");
        }
        return result;
    }

}