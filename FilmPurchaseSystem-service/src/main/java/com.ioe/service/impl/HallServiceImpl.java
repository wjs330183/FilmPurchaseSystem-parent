package com.ioe.service.impl;

import com.ioe.dao.HallDao;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.HallService;
import com.ioe.utils.CommonUtils;
import com.ioe.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ioe.entity.Hall;

/**
 * 描述：
 *
 * @author wangjs
 * @date 2018-04-19
 */
@Service("hallService")
public class HallServiceImpl implements HallService {

    private static Logger logger = LoggerFactory.getLogger(HallServiceImpl.class);

    @Resource
    private HallDao hallDao;

    @Resource
    private SnowflakeIdWorkerUtils snowflakeIdWorkerUtils;
    /**
     * 单个保存
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveHall(
            String hallId,
            String hallSeats,
            String hallDescription,
            String operator
    ) {
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(hallId,hallSeats,hallDescription,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            Hall hall = new Hall();
            hall.setId(String.valueOf(snowflakeIdWorkerUtils.nextId()));
            hall.setHallId(hallId);
            hall.setHallSeats(hallSeats);
            hall.setHallDescription(hallDescription);
            hall.setSysCreator(operator);
            hall.setSysUpdater(operator);
            hallDao.save(hall);
        } catch (Exception e) {
            logger.error("saveHall error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveHall is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 批量保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ListResult<String>  saveHallBatch(String hallJson, String operator) {

        ListResult<String>  result = new ListResult<String> ();
        if (CommonUtils.isAnyEmpty(hallJson,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<Hall> hallList = CommonUtils.getListByJson(hallJson, Hall.class);

            List<String> ids = new ArrayList<String>();
            for (Hall hall : hallList) {
                hall.setId(String.valueOf(snowflakeIdWorkerUtils.nextId()));
                ids.add(hall.getId());
            }
            hallDao.saveBatch(hallList);
            result.setDataList(ids);
        } catch (Exception e) {
            logger.error("saveHallBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveHallBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据id获取对象
     */
    @Override

    public ListResult<Hall> getHallById(String id) {
        ListResult<Hall> result = new ListResult();
        if (CommonUtils.isEmpty(id)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Hall> hallList = hallDao.getById(id);

            result.setDataList(hallList);

        } catch (Exception e) {
            logger.error("saveHallById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("getHallById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteHallById(String id, String operator) {
        DataResult<Integer> result = new DataResult();

        if (CommonUtils.isAnyEmpty(id,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            int count = hallDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e) {
            logger.error("deleteHallById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteHallById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 更新对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateHall(
            String id,
            String hallId,
            String hallSeats,
            String hallDescription,
            String operator
    ) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,hallId,hallSeats,hallDescription,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            // TODO : 前置代码
            Hall hall = new Hall();
            hall.setId(id);
            hall.setHallId(hallId);
            hall.setHallSeats(hallSeats);
            hall.setHallDescription(hallDescription);
            hall.setSysUpdater(operator);

            int count = hallDao.update(hall);
            result.setData(count);

        } catch (Exception e) {
            logger.error("updateHall error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateHall is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据hallId查询记录
     *
     * @param hallId 放映厅ID号
     */
    @Override
    public ListResult<Hall> getHallByHallId(String hallId) {
        ListResult<Hall> result = new ListResult();
        if(CommonUtils.isEmpty(hallId)){
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Hall> hallList = hallDao.getByHallId(hallId);

            result.setDataList(hallList);

        } catch (Exception e) {
            logger.error("getHallByHallId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getHallByHallId is error");
        }
        return result;
    }

}