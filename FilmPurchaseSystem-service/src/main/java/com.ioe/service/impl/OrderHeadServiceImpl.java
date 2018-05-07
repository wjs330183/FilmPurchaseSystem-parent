package com.ioe.service.impl;

import com.ioe.dao.OrderHeadDao;
import com.ioe.entity.OrderHead;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.OrderHeadService;
import com.ioe.utils.CommonUtils;
import com.ioe.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import java.util.*;
import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("orderHeadService")
public class OrderHeadServiceImpl implements OrderHeadService {

    private static Logger logger = LoggerFactory.getLogger(OrderHeadServiceImpl.class);

    @Resource
    private OrderHeadDao orderheadDao;

    /**
    * 单个保存
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveOrderhead(
            String orderheadId,
            Date orderheadBuydate,
            String customerId,
            String operator
    ){
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(orderheadId,customerId,operator)&&(orderheadBuydate==null)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try{
            OrderHead orderhead = new OrderHead();
            orderhead.setId(SnowflakeIdWorkerUtils.getnextId(operator));
            orderhead.setOrderHeadId(orderheadId);
            orderhead.setOrderHeadBuyDate(orderheadBuydate);
            orderhead.setCustomerId(customerId);
            orderhead.setSysCreator(operator);
            orderhead.setSysUpdater(operator);
            orderheadDao.save(orderhead);
        } catch (Exception e){
            logger.error("saveOrderhead error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveOrderhead is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 批量保存
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public ListResult<String>  saveOrderheadBatch(String orderheadJson, String operator){
        ListResult<String>  result = new ListResult<String> ();
        if(CommonUtils.isEmpty(orderheadJson)){
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try{
            List<OrderHead> orderheadList = CommonUtils.getListByJson(orderheadJson, OrderHead.class);

            List<String> ids = new ArrayList<String>();
            for (OrderHead orderHead : orderheadList) {
                orderHead.setId(SnowflakeIdWorkerUtils.getnextId(operator));
                ids.add(orderHead.getId());
            }
            orderheadDao.saveBatch(orderheadList);
            result.setDataList(ids);
        } catch (Exception e){
            logger.error("saveOrderheadBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveOrderheadBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据id获取对象
    */
    @Override

    public ListResult<OrderHead> getOrderheadById (String id){
        ListResult<OrderHead> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try{

            List<OrderHead> orderheadList = orderheadDao.getById(id);

                result.setDataList(orderheadList);

        } catch (Exception e){
            logger.error("saveOrderheadById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("saveOrderheadById is error");
        }
        return result;
    }

    /**
    * 根据id删除对象
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteOrderheadById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try{

        int count = orderheadDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e){
            logger.error("deleteOrderheadById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteOrderheadById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }



    /**
    * 更新对象
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateOrderhead(
            String id,
            String orderheadId,
            Date orderheadBuydate,
            String customerId,
            String operator
    ){
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,orderheadId,customerId,operator)&&(orderheadBuydate == null)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try{

            OrderHead orderhead = new OrderHead();
            orderhead.setId(id);
            orderhead.setOrderHeadId(orderheadId);
            orderhead.setOrderHeadBuyDate(orderheadBuydate);
            orderhead.setCustomerId(customerId);
            orderhead.setSysUpdater(operator);
            int count = orderheadDao.update(orderhead);

            result.setData(count);
        } catch (Exception e){
            logger.error("updateOrderhead error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateOrderhead is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据orderheadId查询记录
    *
    * @param orderheadId 订单ID
	
    */
    @Override

    public ListResult<OrderHead> getOrderheadByOrderheadId (String orderheadId){
        ListResult<OrderHead> result = new ListResult();
        if (CommonUtils.isEmpty(orderheadId)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try{

            List<OrderHead> orderheadList = orderheadDao.getByOrderheadId(orderheadId);


                result.setDataList(orderheadList);

        } catch (Exception e){
            logger.error("getOrderheadByOrderheadId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getOrderheadByOrderheadId is error");
        }
        return result;
    }

}