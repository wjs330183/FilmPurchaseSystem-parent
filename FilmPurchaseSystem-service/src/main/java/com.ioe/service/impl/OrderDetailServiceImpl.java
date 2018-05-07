package com.ioe.service.impl;

import com.ioe.dao.OrderDetailDao;
import com.ioe.entity.OrderDetail;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.OrderDetailService;
import com.ioe.utils.CommonUtils;
import com.ioe.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 描述：
 *
 * @author wangjs
 * @date 2018-04-19
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    private static Logger logger = LoggerFactory.getLogger(OrderDetailServiceImpl.class);

    @Resource
    private OrderDetailDao orderdetailDao;


    /**
     * 单个保存
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveOrderdetail(
            String orderdetailId,
            String orderheadId,
            String scheduleId,
            String orderdetailAdjustedprice,
            String operator
    ) {
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(orderdetailId, orderheadId, scheduleId, orderdetailAdjustedprice, operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            OrderDetail orderdetail = new OrderDetail();
            orderdetail.setId(SnowflakeIdWorkerUtils.getnextId(operator));
            orderdetail.setOrderDetailId(orderdetailId);
            orderdetail.setOrderHeadId(orderheadId);
            orderdetail.setScheduleId(scheduleId);
            orderdetail.setOrderdetailAdjustedPrice(new BigDecimal(orderdetailAdjustedprice));
            orderdetail.setSysCreator(operator);
            orderdetail.setSysUpdater(operator);
            orderdetailDao.save(orderdetail);
        } catch (Exception e) {
            logger.error("saveOrderdetail error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveOrderdetail is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 批量保存
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public ListResult<String> saveOrderdetailBatch(String orderdetailJson, String operator) {
        ListResult<String> result = new ListResult<String>();
        if (CommonUtils.isEmpty(orderdetailJson)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<OrderDetail> orderdetailList = CommonUtils.getListByJson(orderdetailJson, OrderDetail.class);

            List<String> ids = new ArrayList<String>();
            for (OrderDetail orderDetail : orderdetailList) {
                orderDetail.setId(SnowflakeIdWorkerUtils.getnextId(operator));
                ids.add(orderDetail.getId());
            }
            orderdetailDao.saveBatch(orderdetailList);
            result.setDataList(ids);
        } catch (Exception e) {
            logger.error("saveOrderdetailBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveOrderdetailBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据id获取对象
     */
    @Override

    public ListResult<OrderDetail> getOrderdetailById(String id) {
        ListResult<OrderDetail> result = new ListResult();
        if (CommonUtils.isEmpty(id)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<OrderDetail> orderdetailList = orderdetailDao.getById(id);

            result.setDataList(orderdetailList);

        } catch (Exception e) {
            logger.error("getOrderdetailById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("getOrderdetailById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteOrderdetailById(String id, String operator) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            int count = orderdetailDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e) {
            logger.error("deleteOrderdetailById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteOrderdetailById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 更新对象
     */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateOrderdetail(
            String id,
            String orderdetailId,
            String orderheadId,
            String scheduleId,
            String orderdetailAdjustedprice,
            String operator
    ) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,orderdetailId,orderheadId,scheduleId,orderdetailAdjustedprice,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            OrderDetail orderdetail = new OrderDetail();
            orderdetail.setId(id);
            orderdetail.setOrderDetailId(orderdetailId);
            orderdetail.setOrderHeadId(orderheadId);
            orderdetail.setScheduleId(scheduleId);
            orderdetail.setOrderdetailAdjustedPrice(new BigDecimal(orderdetailAdjustedprice));
            orderdetail.setSysUpdater(operator);
            int count = orderdetailDao.update(orderdetail);
            result.setData(count);
        } catch (Exception e) {
            logger.error("updateOrderdetail error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateOrderdetail is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }
    /**
     * 根据orderdetailId查询记录
     *
     * @param orderdetailId 订单ID

     */
    @Override

    public ListResult<OrderDetail> getOrderdetailByOrderdetailId (String orderdetailId){
        ListResult<OrderDetail> result = new ListResult();
        if (CommonUtils.isEmpty(orderdetailId)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try{

            List<OrderDetail> orderheadList = orderdetailDao.getByOrderdetailId(orderdetailId);

            result.setDataList(orderheadList);

        } catch (Exception e){
            logger.error("getOrderdetailByOrderdetailId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getOrderdetailByOrderdetailId is error");
        }
        return result;
    }
}