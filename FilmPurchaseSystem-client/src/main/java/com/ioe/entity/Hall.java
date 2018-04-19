package com.ioe.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public class Hall extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *放映厅ID号
    */
    private String hallId;

    /**
    *座位数量
    */
    private String hallSeats;

    /**
    *说明
    */
    private String hallDescription;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getHallId() {
        return this.hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }
    public String getHallSeats() {
        return this.hallSeats;
    }

    public void setHallSeats(String hallSeats) {
        this.hallSeats = hallSeats;
    }
    public String getHallDescription() {
        return this.hallDescription;
    }

    public void setHallDescription(String hallDescription) {
        this.hallDescription = hallDescription;
    }

}