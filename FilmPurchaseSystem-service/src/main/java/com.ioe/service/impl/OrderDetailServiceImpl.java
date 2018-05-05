package com.ioe.service.impl;

import com.ioe.dao.OrderDetailDao;
import com.ioe.entity.OrderDetail;
import com.ioe.service.OrderDetailService;
import com.ioe.utils.CommonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("orderdetailService")
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
            OrderDetail orderdetail = new OrderDetail();
            orderdetail.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            orderdetail.setOrderDetailId(orderdetailId);
            orderdetail.setOrderHeadId(orderheadId);
            orderdetail.setScheduleId(scheduleId);
            orderdetail.setOrderdetailAdjustedPrice(orderdetailAdjustedprice);
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

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Boolean> saveOrderdetailBatch(String orderdetailJson, String operator){
        DataResult<Boolean> result = new DataResult();
        if(CommonUtils.isEmpty(orderdetailJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<OrderDetail> orderdetailList = CommonUtils.getListByJson(orderdetailJson, Orderdetail.class);

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

    public ListResult<OrderDetail> getOrderdetailById (String id, int availData){
        ListResult<OrderDetail> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<OrderDetail> orderdetailList = orderdetailDao.getById(id, availData);
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

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Boolean> updateOrderdetail(
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
            OrderDetail orderdetail = new OrderDetail();
            orderdetail.setId(id);
            orderdetail.setOrderDetailId(orderdetailId);
            orderdetail.setOrderHeadId(orderheadId);
            orderdetail.setScheduleId(scheduleId);
            orderdetail.setOrderdetailAdjustedPrice(orderdetailAdjustedprice);
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