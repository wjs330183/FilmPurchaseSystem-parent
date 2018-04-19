package com.ioe.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public class Orderhead extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *订单ID
    */
    private String orderheadId;

    /**
    *下单时间
    */
    private Date orderheadBuydate;

    /**
    *用户ID
    */
    private String customerId;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOrderheadId() {
        return this.orderheadId;
    }

    public void setOrderheadId(String orderheadId) {
        this.orderheadId = orderheadId;
    }
    public Date getOrderheadBuydate() {
        return this.orderheadBuydate;
    }

    public void setOrderheadBuydate(Date orderheadBuydate) {
        this.orderheadBuydate = orderheadBuydate;
    }
    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}