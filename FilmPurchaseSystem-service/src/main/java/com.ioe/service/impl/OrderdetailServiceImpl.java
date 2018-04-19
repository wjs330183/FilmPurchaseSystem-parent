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

import com.ioe.entity.Orderdetail;
import com.ioe.service.Orderdetail;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("orderdetailService")
public class OrderdetailServiceImpl implements OrderdetailService {

    private static Logger logger = LoggerFactory.getLogger(OrderdetailServiceImpl.class);

    @Resource
    private OrderdetailDao orderdetailDao;

    /**
    * 单个保存
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveOrderdetail(
            String orderdetailId,
            String orderheadId,
            String scheduleId,
            BigDecimal orderdetailAdjustedprice,
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
            Orderdetail orderdetail = new Orderdetail();
            orderdetail.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            orderdetail.setOrderdetailId(orderdetailId);
            orderdetail.setOrderheadId(orderheadId);
            orderdetail.setScheduleId(scheduleId);
            orderdetail.setOrderdetailAdjustedprice(orderdetailAdjustedprice);
            orderdetail.setSysCreateTime(sysCreateTime);
            orderdetail.setSysCreator(sysCreator);
            orderdetail.setSysUpdateTime(sysUpdateTime);
            orderdetail.setSysUpdater(sysUpdater);
            orderdetail.setSysDeleted(sysDeleted);
            orderdetail.setSysHash(sysHash);
            orderdetail.setSysAvailData(sysAvailData);
            orderdetailDao.save(orderdetail);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveOrderdetail error:{}", e.getMessage());
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
    DataResult<Boolean> saveOrderdetailBatch (String orderdetailJson, String operator){
        if(CommonUtils.isEmpty(orderdetailJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Orderdetail> orderdetailList = CommonUtils.getListByJson(orderdetailJson, Orderdetail.class);

            if (CommonUtils.isEmpty(orderdetailList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            orderdetailDao.saveBatch(orderdetailList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveOrderdetailBatch error:{}", e.getMessage());
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
    public ListResult<Orderdetail> getOrderdetailById (String id, int availData){
        ListResult<Orderdetail> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Orderdetail> orderdetailList = orderdetailDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(orderdetailList)){
                result.setDataList(orderdetailList);
            }
        } catch (Exception e){
            logger.error("saveOrderdetailById error:{}", e.getMessage());
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
    public DataResult<Integer> deleteOrderdetailById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = orderdetailDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteOrderdetailById error:{}", e.getMessage());
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
    DataResult<Boolean> updateOrderdetail (
                String id,
                String orderdetailId,
                String orderheadId,
                String scheduleId,
                BigDecimal orderdetailAdjustedprice,
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
        Orderdetail orderdetail = new Orderdetail();
        orderdetail.setId(id);
        orderdetail.setOrderdetailId(orderdetailId);
        orderdetail.setOrderheadId(orderheadId);
        orderdetail.setScheduleId(scheduleId);
        orderdetail.setOrderdetailAdjustedprice(orderdetailAdjustedprice);
        orderdetail.setSysCreateTime(sysCreateTime);
        orderdetail.setSysCreator(sysCreator);
        orderdetail.setSysUpdateTime(sysUpdateTime);
        orderdetail.setSysUpdater(sysUpdater);
        orderdetail.setSysDeleted(sysDeleted);
        orderdetail.setSysHash(sysHash);
        orderdetail.setSysAvailData(sysAvailData);
        orderdetail.setSysUpdater(operator);
        orderdetailDao.update(orderdetail);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateOrderdetail error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

}