package com.ioe.service.impl;

import com.ioe.dao.CustomerDao;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.CustomerService;
import com.ioe.utils.CommonUtils;
import com.ioe.utils.SnowflakeIdWorkerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ioe.entity.Customer;

/**
 * 描述：
 *
 * @author wangjs
 * @date 2018-04-19
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Resource
    private CustomerDao customerDao;

    @Resource
    private SnowflakeIdWorkerUtils snowflakeIdWorkerUtils;
    /**
     * 单个保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveCustomer(
            String customerId,
            String customerName,
            String customerEmail,
            String customerMobile,
            String classId,
            String operator
    ) {
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(customerId,customerName,customerEmail,customerMobile,classId,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            Customer customer = new Customer();
            customer.setId(String.valueOf(snowflakeIdWorkerUtils.nextId()));
            customer.setCustomerId(customerId);
            customer.setCustomerName(customerName);
            customer.setCustomerEmail(customerEmail);
            customer.setCustomerMobile(customerMobile);
            customer.setClassId(classId);
            customer.setSysCreator(operator);
            customer.setSysUpdater(operator);
            customerDao.save(customer);
        } catch (Exception e) {
            logger.error("saveCustomer error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveCustomer is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 批量保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ListResult<String> saveCustomerBatch(String customerJson, String operator) {

        ListResult<String> result = new ListResult<String>();
        if (CommonUtils.isAnyEmpty(customerJson,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<Customer> customerList = CommonUtils.getListByJson(customerJson, Customer.class);

            List<String> ids = new ArrayList<String>();
            for (Customer customer : customerList) {
                customer.setId(String.valueOf(snowflakeIdWorkerUtils.nextId()));
                ids.add(customer.getId());
            }
            customerDao.saveBatch(customerList);
            result.setDataList(ids);
        } catch (Exception e) {
            logger.error("saveCustomerBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveCustomerBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据id获取对象
     */
    @Override
    public ListResult<Customer> getCustomerById(String id) {
        ListResult<Customer> result = new ListResult();
        if (CommonUtils.isEmpty(id)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<Customer> customerList = customerDao.getById(id);


            result.setDataList(customerList);

        } catch (Exception e) {
            logger.error("saveCustomerById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("getCustomerById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteCustomerById(String id, String operator) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            int count = customerDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e) {
            logger.error("deleteCustomerById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteCustomerById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 更新对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateCustomer(
            String id,
            String customerId,
            String customerName,
            String customerEmail,
            String customerMobile,
            String classId,
            String operator
    ) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,customerId,customerName,customerEmail,customerMobile,classId,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }

        try {

            Customer customer = new Customer();
            customer.setId(id);
            customer.setCustomerId(customerId);
            customer.setCustomerName(customerName);
            customer.setCustomerEmail(customerEmail);
            customer.setCustomerMobile(customerMobile);
            customer.setClassId(classId);
            customer.setSysUpdater(operator);

            int count = customerDao.update(customer);
            result.setData(count);

        } catch (Exception e) {
            logger.error("updateCustomer error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateCustomer is error");
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
    public ListResult<Customer> getCustomerByCustomerId(String customerId) {
        ListResult<Customer> result = new ListResult();
        if(CommonUtils.isEmpty(customerId)){
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Customer> customerList = customerDao.getByCustomerId(customerId);


            result.setDataList(customerList);

        } catch (Exception e) {
            logger.error("getCustomerByCustomerId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getCustomerByCustomerId is error");
        }
        return result;
    }

}