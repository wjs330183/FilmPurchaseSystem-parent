package com.ioe.service.impl;

import com.ioe.dao.OrderSeatDao;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.OrderSeatService;
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

import com.ioe.entity.OrderSeat;

/**
 * 描述：
 *
 * @author wangjs
 * @date 2018-04-19
 */
@Service("orderSeatService")
public class OrderSeatServiceImpl implements OrderSeatService {

    private static Logger logger = LoggerFactory.getLogger(OrderSeatServiceImpl.class);

    @Resource
    private OrderSeatDao orderseatDao;

    /**
     * 单个保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveOrderseat(
            String orderdetailId,
            String seatId,
            String operator
    ) {
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(orderdetailId, seatId, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            OrderSeat orderSeat = new OrderSeat();
            orderSeat.setId(SnowflakeIdWorkerUtils.getnextId(operator));
            orderSeat.setOrderDetailId(orderdetailId);
            orderSeat.setSeatId(seatId);
            orderSeat.setSysCreator(operator);
            orderSeat.setSysUpdater(operator);
            orderseatDao.save(orderSeat);

        } catch (Exception e) {
            logger.error("saveOrderseat error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveOrderseat is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 批量保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ListResult<String> saveOrderseatBatch(String orderseatJson, String operator) {
        ListResult<String> result = new ListResult<String>();
        if (CommonUtils.isEmpty(orderseatJson)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<OrderSeat> orderSeatList = CommonUtils.getListByJson(orderseatJson, OrderSeat.class);

            List<String> ids = new ArrayList<String>();
            for (OrderSeat orderseat : orderSeatList) {
                orderseat.setId(SnowflakeIdWorkerUtils.getnextId(operator));
                ids.add(orderseat.getId());
            }

            orderseatDao.saveBatch(orderSeatList);
            result.setDataList(ids);


        } catch (Exception e) {
            logger.error("saveOrderseatBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveOrderseatBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据id获取对象
     */
    @Override
    public ListResult<OrderSeat> getOrderseatById(String id) {
        ListResult<OrderSeat> result = new ListResult();
        if (CommonUtils.isEmpty(id)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<OrderSeat> orderSeatList = orderseatDao.getById(id);


            result.setDataList(orderSeatList);

        } catch (Exception e) {
            logger.error("saveOrderseatById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("saveOrderseatById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteOrderseatById(String id, String operator) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            int count = orderseatDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e) {
            logger.error("deleteOrderseatById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteOrderseatById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 更新对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateOrderseat(
            String id,
            String orderdetailId,
            String seatId,
            String operator
    ) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id, orderdetailId, seatId, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            OrderSeat orderSeat = new OrderSeat();
            orderSeat.setId(id);
            orderSeat.setOrderDetailId(orderdetailId);
            orderSeat.setSeatId(seatId);
            orderSeat.setSysUpdater(operator);
            int count = orderseatDao.update(orderSeat);

            result.setData(count);
        } catch (Exception e) {
            logger.error("updateOrderseat error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateOrderseat is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 根据orderseatId查询记录
     *
     * @param orderseatId 订单ID

     */
    @Override
    public ListResult<OrderSeat> getOrderSeatByOrderseatId (String orderseatId){
        ListResult<OrderSeat> result = new ListResult();
        if (CommonUtils.isEmpty(orderseatId)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try{

            List<OrderSeat> orderheadList = orderseatDao.getByOrderseatId(orderseatId);

            result.setDataList(orderheadList);

        } catch (Exception e){
            logger.error("getOrderSeatByOrderseatId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getOrderSeatByOrderseatId is error");
        }
        return result;
    }
}