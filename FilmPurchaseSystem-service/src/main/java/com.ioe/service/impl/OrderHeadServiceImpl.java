package com.ioe.service.impl;

import com.ioe.dao.OrderHeadDao;
import com.ioe.entity.OrderHead;
import com.ioe.service.OrderHeadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import java.util.List;
import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("orderheadService")
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
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            OrderHead orderhead = new OrderHead();
            orderhead.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            orderhead.setOrderHeadId(orderheadId);
            orderhead.setOrderHeadBuyDate(orderheadBuydate);
            orderhead.setCustomerId(customerId);
            orderheadDao.save(orderhead);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveOrderhead error:{}", e.getMessage());
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
    DataResult<Boolean> saveOrderheadBatch (String orderheadJson, String operator){
        DataResult<Boolean> result = new DataResult();
        if(CommonUtils.isEmpty(orderheadJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<OrderHead> orderheadList = CommonUtils.getListByJson(orderheadJson, OrderHead.class);

            if (CommonUtils.isEmpty(orderheadList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            orderheadDao.saveBatch(orderheadList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveOrderheadBatch error:{}", e.getMessage());
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

    public ListResult<OrderHead> getOrderheadById (String id, int availData){
        ListResult<OrderHead> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<OrderHead> orderheadList = orderheadDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(orderheadList)){
                result.setDataList(orderheadList);
            }
        } catch (Exception e){
            logger.error("saveOrderheadById error:{}", e.getMessage());
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
    public DataResult<Integer> deleteOrderheadById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = orderheadDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteOrderheadById error:{}", e.getMessage());
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
    public DataResult<Boolean> updateOrderhead(
            String id,
            String orderheadId,
            Date orderheadBuydate,
            String customerId,
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
            OrderHead orderhead = new OrderHead();
            orderhead.setId(id);
            orderhead.setOrderHeadId(orderheadId);
            orderhead.setOrderHeadBuyDate(orderheadBuydate);
            orderhead.setCustomerId(customerId);
            orderhead.setSysUpdater(operator);
            orderheadDao.update(orderhead);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateOrderhead error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
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

    public ListResult<OrderHead> getOrderheadByOrderheadId (String orderheadId, int availData){
        ListResult<OrderHead> result = new ListResult();
        //TODO:数据校验
        //if(){
        //    result.setCode("1");
        //    result.setCode("1");
        //    return result;
        //}
        try{
            // TODO : 前置代码
            List<OrderHead> orderheadList = orderheadDao.getByOrderheadId(orderheadId, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(orderheadList)){
                result.setDataList(orderheadList);
            }
        } catch (Exception e){
            logger.error("getOrderheadByOrderheadId error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

}