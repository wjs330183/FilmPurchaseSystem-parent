package com.ioe.service.impl;

import com.ioe.dao.SeatDao;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.SeatService;
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

import com.ioe.entity.Seat;

/**
 * 描述：
 *
 * @author wangjs
 * @date 2018-04-19
 */
@Service("seatService")
public class SeatServiceImpl implements SeatService {

    private static Logger logger = LoggerFactory.getLogger(SeatServiceImpl.class);

    @Resource
    private SeatDao seatDao;
    @Resource
    private SnowflakeIdWorkerUtils snowflakeIdWorkerUtils;

    /**
     * 单个保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveSeat(
            String seatId,
            String hallId,
            String seatRow,
            String seatColumn,
            String seatIsactive,
            String operator
    ) {
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(seatId, hallId, seatRow, seatColumn, seatIsactive, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            Seat seat = new Seat();
            seat.setId(String.valueOf(snowflakeIdWorkerUtils.nextId()));
            seat.setSeatId(seatId);
            seat.setHallId(hallId);
            seat.setSeatRow(seatRow);
            seat.setSeatColumn(seatColumn);
            seat.setSeatIsactive(seatIsactive);
            seat.setSysCreator(operator);
            seat.setSysUpdater(operator);
            seatDao.save(seat);
            // TODO : 后置代码
        } catch (Exception e) {
            logger.error("saveSeat error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveSeat is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 批量保存
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public ListResult<String> saveSeatBatch(String seatJson, String operator) {
        ListResult<String> result = new ListResult<String>();
        if (CommonUtils.isEmpty(seatJson)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<Seat> seatList = CommonUtils.getListByJson(seatJson, Seat.class);

            List<String> ids = new ArrayList<String>();
            for (Seat seat : seatList) {
                seat.setId(String.valueOf(snowflakeIdWorkerUtils.nextId()));
                ids.add(seat.getId());
            }
            seatDao.saveBatch(seatList);
            result.setDataList(ids);

        } catch (Exception e) {
            logger.error("saveSeatBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveSeatBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据id获取对象
     */
    @Override

    public ListResult<Seat> getSeatById(String id) {
        ListResult<Seat> result = new ListResult();
        if (CommonUtils.isEmpty(id)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Seat> seatList = seatDao.getById(id);

                result.setDataList(seatList);

        } catch (Exception e) {
            logger.error("getSeatById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("getSeatById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteSeatById(String id, String operator) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            int count = seatDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e) {
            logger.error("deleteSeatById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteSeatById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 更新对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateSeat(
            String id,
            String seatId,
            String hallId,
            String seatRow,
            String seatColumn,
            String seatIsactive,
            String operator
    ) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,seatId,hallId,seatRow,seatColumn,seatIsactive,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            Seat seat = new Seat();
            seat.setId(id);
            seat.setSeatId(seatId);
            seat.setHallId(hallId);
            seat.setSeatRow(seatRow);
            seat.setSeatColumn(seatColumn);
            seat.setSeatIsactive(seatIsactive);
            seat.setSysUpdater(operator);

            int count = seatDao.update(seat);
            result.setData(count);

        } catch (Exception e) {
            logger.error("updateSeat error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateSeat is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据seatId查询记录
     *
     * @param seatId 座位ID
     */
    @Override

    public ListResult<Seat> getSeatBySeatId(String seatId) {
        ListResult<Seat> result = new ListResult();
        if (CommonUtils.isEmpty(seatId)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Seat> seatList = seatDao.getBySeatId(seatId);


                result.setDataList(seatList);

        } catch (Exception e) {
            logger.error("getSeatBySeatId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getSeatBySeatId is error");
        }
        return result;
    }

}