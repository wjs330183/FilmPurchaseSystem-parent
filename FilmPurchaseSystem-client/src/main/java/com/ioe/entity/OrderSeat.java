package com.ioe.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public class OrderSeat extends BaseEntity{

    /**
    *
    */
    private String id;

    /**
    *订单明细ID
    */
    private String orderDetailId;

    /**
    *预定座位ID
    */
    private String seatId;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOrderDetailId() {
        return this.orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    public String getSeatId() {
        return this.seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

}