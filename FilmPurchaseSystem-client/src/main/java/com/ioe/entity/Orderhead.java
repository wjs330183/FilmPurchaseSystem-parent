package com.ioe.entity;

import java.sql.Date;

public class OrderHead {
    /**
     * 订单ID
     */
    private String orderHeadID;
    /**
     * 下单时间
     */
    private Date orderHeadBuyDate;
    /**
     * 用户ID
     */
    private String customerID;
    /**
     * 是否删除
     */
    private int orderHeadDisable;

    public String getOrderHeadID() {
        return orderHeadID;
    }

    public void setOrderHeadID(String orderHeadID) {
        this.orderHeadID = orderHeadID;
    }

    public Date getOrderHeadBuyDate() {
        return orderHeadBuyDate;
    }

    public void setOrderHeadBuyDate(Date orderHeadBuyDate) {
        this.orderHeadBuyDate = orderHeadBuyDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getOrderHeadDisable() {
        return orderHeadDisable;
    }

    public void setOrderHeadDisable(int orderHeadDisable) {
        this.orderHeadDisable = orderHeadDisable;
    }
}
