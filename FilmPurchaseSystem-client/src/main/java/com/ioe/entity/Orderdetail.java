package com.ioe.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public class Orderdetail extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *订单明细ID
    */
    private String orderdetailId;

    /**
    *订单ID
    */
    private String orderheadId;

    /**
    *电影时间表ID
    */
    private String scheduleId;

    /**
    *打折后的价格
    */
    private BigDecimal orderdetailAdjustedprice;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOrderdetailId() {
        return this.orderdetailId;
    }

    public void setOrderdetailId(String orderdetailId) {
        this.orderdetailId = orderdetailId;
    }
    public String getOrderheadId() {
        return this.orderheadId;
    }

    public void setOrderheadId(String orderheadId) {
        this.orderheadId = orderheadId;
    }
    public String getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    public BigDecimal getOrderdetailAdjustedprice() {
        return this.orderdetailAdjustedprice;
    }

    public void setOrderdetailAdjustedprice(BigDecimal orderdetailAdjustedprice) {
        this.orderdetailAdjustedprice = orderdetailAdjustedprice;
    }

}