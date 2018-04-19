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

import com.ioe.entity.Orderseat;
import com.ioe.service.Orderseat;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("orderseatService")
public class OrderseatServiceImpl implements OrderseatService {

    private static Logger logger = LoggerFactory.getLogger(OrderseatServiceImpl.class);

    @Resource
    private OrderseatDao orderseatDao;

    /**
    * 单个保存
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveOrderseat(
            String orderdetailId,
            String seatId,
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
            Orderseat orderseat = new Orderseat();
            orderseat.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            orderseat.setOrderdetailId(orderdetailId);
            orderseat.setSeatId(seatId);
            orderseat.setSysCreateTime(sysCreateTime);
            orderseat.setSysCreator(sysCreator);
            orderseat.setSysUpdateTime(sysUpdateTime);
            orderseat.setSysUpdater(sysUpdater);
            orderseat.setSysDeleted(sysDeleted);
            orderseat.setSysHash(sysHash);
            orderseat.setSysAvailData(sysAvailData);
            orderseatDao.save(orderseat);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveOrderseat error:{}", e.getMessage());
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
    DataResult<Boolean> saveOrderseatBatch (String orderseatJson, String operator){
        if(CommonUtils.isEmpty(orderseatJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Orderseat> orderseatList = CommonUtils.getListByJson(orderseatJson, Orderseat.class);

            if (CommonUtils.isEmpty(orderseatList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            orderseatDao.saveBatch(orderseatList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveOrderseatBatch error:{}", e.getMessage());
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
    public ListResult<Orderseat> getOrderseatById (String id, int availData){
        ListResult<Orderseat> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Orderseat> orderseatList = orderseatDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(orderseatList)){
                result.setDataList(orderseatList);
            }
        } catch (Exception e){
            logger.error("saveOrderseatById error:{}", e.getMessage());
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
    public DataResult<Integer> deleteOrderseatById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = orderseatDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteOrderseatById error:{}", e.getMessage());
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
    DataResult<Boolean> updateOrderseat (
                String id,
                String orderdetailId,
                String seatId,
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
        Orderseat orderseat = new Orderseat();
        orderseat.setId(id);
        orderseat.setOrderdetailId(orderdetailId);
        orderseat.setSeatId(seatId);
        orderseat.setSysCreateTime(sysCreateTime);
        orderseat.setSysCreator(sysCreator);
        orderseat.setSysUpdateTime(sysUpdateTime);
        orderseat.setSysUpdater(sysUpdater);
        orderseat.setSysDeleted(sysDeleted);
        orderseat.setSysHash(sysHash);
        orderseat.setSysAvailData(sysAvailData);
        orderseat.setSysUpdater(operator);
        orderseatDao.update(orderseat);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateOrderseat error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

}