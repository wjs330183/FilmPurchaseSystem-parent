package com.ioe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ioe.entity.Customer;
import com.ioe.service.CommonService;
import com.ioe.service.CustomerService;
import com.ioe.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CommonService commonService;

    private String tableName = "t_customer";
    @Transactional
    @Override
    public int createCustomer(String customerJson) {
        List<Customer> customerList = CommonUtils.getListByJson(customerJson, Customer.class);
        commonService.batchCreateTable(tableName, customerList);
        return 0;
    }

    @Override
    public int updateCustomer(String customerJson) {
        return 0;
    }
    /**
     * 用户服务
     */
}
