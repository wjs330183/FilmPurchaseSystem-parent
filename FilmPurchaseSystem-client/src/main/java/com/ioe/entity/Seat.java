package com.ioe.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public class Seat extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *座位ID
    */
    private String seatId;

    /**
    *放映厅ID
    */
    private String hallId;

    /**
    *座位的行
    */
    private String seatRow;

    /**
    *座位的列
    */
    private String seatColumn;

    /**
    *是否使用
    */
    private String seatIsactive;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getSeatId() {
        return this.seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
    public String getHallId() {
        return this.hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }
    public String getSeatRow() {
        return this.seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }
    public String getSeatColumn() {
        return this.seatColumn;
    }

    public void setSeatColumn(String seatColumn) {
        this.seatColumn = seatColumn;
    }
    public String getSeatIsactive() {
        return this.seatIsactive;
    }

    public void setSeatIsactive(String seatIsactive) {
        this.seatIsactive = seatIsactive;
    }

}