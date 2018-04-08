package com.ioe.entity;

public class OrderDetail {
    /**
     * 订单明细ID
     */
    private String orderdetailID;
    /**
     * 订单ID
     */
    private String orderHeadID;
    /**
     * 电影时间表
     */
    private String scheduleID;
    /**
     * 打折后价格
     */
    private double orderdetailAdjustedPrice;


    public String getOrderHeadID() {
        return orderHeadID;
    }

    public void setOrderHeadID(String orderHeadID) {
        this.orderHeadID = orderHeadID;
    }

    public String getOrderdetailID() {

        return orderdetailID;
    }

    public void setOrderdetailID(String orderdetailID) {
        this.orderdetailID = orderdetailID;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public double getOrderdetailAdjustedPrice() {
        return orderdetailAdjustedPrice;
    }

    public void setOrderdetailAdjustedPrice(double orderdetailAdjustedPrice) {
        this.orderdetailAdjustedPrice = orderdetailAdjustedPrice;
    }
}
