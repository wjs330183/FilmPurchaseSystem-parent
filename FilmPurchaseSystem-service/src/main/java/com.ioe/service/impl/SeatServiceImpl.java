package com.ioe.service.impl;

import com.ioe.dao.SeatDao;
import com.ioe.service.SeatService;
import com.ioe.utils.CommonUtils;
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
* @author wangjs
* @date 2018-04-19
*/
@Service("seatService")
public class SeatServiceImpl implements SeatService {

    private static Logger logger = LoggerFactory.getLogger(SeatServiceImpl.class);

    @Resource
    private SeatDao seatDao;

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
    ){
        DataResult<String> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            Seat seat = new Seat();
            seat.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            seat.setSeatId(seatId);
            seat.setHallId(hallId);
            seat.setSeatRow(seatRow);
            seat.setSeatColumn(seatColumn);
            seat.setSeatIsactive(seatIsactive);
            seatDao.save(seat);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveSeat error:{}", e.getMessage());
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

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Boolean> saveSeatBatch(String seatJson, String operator){
        DataResult<Boolean> result = new DataResult();
        if(CommonUtils.isEmpty(seatJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Seat> seatList = CommonUtils.getListByJson(seatJson, Seat.class);

            if (CommonUtils.isEmpty(seatList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            seatDao.saveBatch(seatList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveSeatBatch error:{}", e.getMessage());
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

    public ListResult<Seat> getSeatById (String id, int availData){
        ListResult<Seat> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Seat> seatList = seatDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(seatList)){
                result.setDataList(seatList);
            }
        } catch (Exception e){
            logger.error("saveSeatById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

    /**
    * 根据id删除对象
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteSeatById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = seatDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteSeatById error:{}", e.getMessage());
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

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Boolean> updateSeat(
            String id,
            String seatId,
            String hallId,
            String seatRow,
            String seatColumn,
            String seatIsactive,
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
        Seat seat = new Seat();
        seat.setId(id);
        seat.setSeatId(seatId);
        seat.setHallId(hallId);
        seat.setSeatRow(seatRow);
        seat.setSeatColumn(seatColumn);
        seat.setSeatIsactive(seatIsactive);
        seat.setSysUpdater(operator);
        seatDao.update(seat);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateSeat error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
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

    public ListResult<Seat> getSeatBySeatId (String seatId, int availData){
        ListResult<Seat> result = new ListResult();
        //TODO:数据校验
        //if(){
        //    result.setCode("1");
        //    result.setCode("1");
        //    return result;
        //}
        try{
            // TODO : 前置代码
            List<Seat> seatList = seatDao.getBySeatId(seatId, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(seatList)){
                result.setDataList(seatList);
            }
        } catch (Exception e){
            logger.error("getSeatBySeatId error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

}