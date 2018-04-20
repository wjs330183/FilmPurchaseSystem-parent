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

import com.ioe.entity.Customer;
import com.ioe.service.Customer;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Resource
    private CustomerDao customerDao;

    /**
    * 单个保存
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveCustomer(
            String customerId,
            String customerName,
            String customerEmail,
            String customerMobile,
            String classId,
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
            Customer customer = new Customer();
            customer.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            customer.setCustomerId(customerId);
            customer.setCustomerName(customerName);
            customer.setCustomerEmail(customerEmail);
            customer.setCustomerMobile(customerMobile);
            customer.setClassId(classId);
            customer.setSysCreateTime(sysCreateTime);
            customer.setSysCreator(sysCreator);
            customer.setSysUpdateTime(sysUpdateTime);
            customer.setSysUpdater(sysUpdater);
            customer.setSysDeleted(sysDeleted);
            customer.setSysHash(sysHash);
            customer.setSysAvailData(sysAvailData);
            customerDao.save(customer);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveCustomer error:{}", e.getMessage());
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
    DataResult<Boolean> saveCustomerBatch (String customerJson, String operator){
        if(CommonUtils.isEmpty(customerJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Customer> customerList = CommonUtils.getListByJson(customerJson, Customer.class);

            if (CommonUtils.isEmpty(customerList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            customerDao.saveBatch(customerList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveCustomerBatch error:{}", e.getMessage());
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
    public ListResult<Customer> getCustomerById (String id, int availData){
        ListResult<Customer> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Customer> customerList = customerDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(customerList)){
                result.setDataList(customerList);
            }
        } catch (Exception e){
            logger.error("saveCustomerById error:{}", e.getMessage());
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
    public DataResult<Integer> deleteCustomerById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = customerDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteCustomerById error:{}", e.getMessage());
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
    DataResult<Boolean> updateCustomer (
                String id,
                String customerId,
                String customerName,
                String customerEmail,
                String customerMobile,
                String classId,
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
        Customer customer = new Customer();
        customer.setId(id);
        customer.setCustomerId(customerId);
        customer.setCustomerName(customerName);
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerMobile(customerMobile);
        customer.setClassId(classId);
        customer.setSysCreateTime(sysCreateTime);
        customer.setSysCreator(sysCreator);
        customer.setSysUpdateTime(sysUpdateTime);
        customer.setSysUpdater(sysUpdater);
        customer.setSysDeleted(sysDeleted);
        customer.setSysHash(sysHash);
        customer.setSysAvailData(sysAvailData);
        customer.setSysUpdater(operator);
        customerDao.update(customer);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateCustomer error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据customerId查询记录
    *
    * @param customerId 用户ID
	
    */
    @Override
    @Stat
    public ListResult<Customer> getCustomerByCustomerId (String customerId, int availData){
        ListResult<Customer> result = new ListResult();
        //TODO:数据校验
        //if(){
        //    result.setCode("1");
        //    result.setCode("1");
        //    return result;
        //}
        try{
            // TODO : 前置代码
            List<Customer> customerList = customerDao.getByCustomerId(customerId, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(customerList)){
                result.setDataList(customerList);
            }
        } catch (Exception e){
            logger.error("getCustomerByCustomerId error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

}