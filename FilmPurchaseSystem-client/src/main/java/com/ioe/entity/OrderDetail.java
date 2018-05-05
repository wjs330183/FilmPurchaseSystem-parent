package com.ioe.entity;

import java.math.BigDecimal;

public class OrderDetail extends BaseEntity{
    /**
     *
     */
    private String id;

    /**
     * 订单明细ID
     */
    private String orderDetailId;
    /**
     * 订单ID
     */
    private String orderHeadId;
    /**
     * 电影时间表
     */
    private String scheduleId;
    /**
     * 打折后价格
     */
    private BigDecimal orderdetailAdjustedPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderHeadId() {
        return orderHeadId;
    }

    public void setOrderHeadId(String orderHeadId) {
        this.orderHeadId = orderHeadId;
    }

    public String getOrderDetailId() {

        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public BigDecimal getOrderdetailAdjustedPrice() {
        return orderdetailAdjustedPrice;
    }

    public void setOrderdetailAdjustedPrice(BigDecimal orderdetailAdjustedPrice) {
        this.orderdetailAdjustedPrice = orderdetailAdjustedPrice;
    }
}
