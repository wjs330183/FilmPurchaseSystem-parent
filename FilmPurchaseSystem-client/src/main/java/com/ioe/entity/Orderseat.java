package com.ioe.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public class Orderseat extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *订单明细ID
    */
    private String orderdetailId;

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
    public String getOrderdetailId() {
        return this.orderdetailId;
    }

    public void setOrderdetailId(String orderdetailId) {
        this.orderdetailId = orderdetailId;
    }
    public String getSeatId() {
        return this.seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

}