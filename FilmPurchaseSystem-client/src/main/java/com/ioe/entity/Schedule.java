package com.ioe.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public class Schedule extends BaseEntity {

    /**
    *
    */
    private String id;

    /**
    *电影时间表ID
    */
    private String scheduleId;

    /**
    *电影ID
    */
    private String movieId;

    /**
    *放映厅ID
    */
    private String hallId;

    /**
    *票价
    */
    private BigDecimal schedulePrice;

    /**
    *放映时间
    */
    private String scheduleBegindatetime;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getHallId() {
        return this.hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }
    public BigDecimal getSchedulePrice() {
        return this.schedulePrice;
    }

    public void setSchedulePrice(BigDecimal schedulePrice) {
        this.schedulePrice = schedulePrice;
    }
    public String getScheduleBegindatetime() {
        return this.scheduleBegindatetime;
    }

    public void setScheduleBegindatetime(String scheduleBegindatetime) {
        this.scheduleBegindatetime = scheduleBegindatetime;
    }

}