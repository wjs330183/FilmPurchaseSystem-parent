package com.ioe.entity;

public class Hall {
    /**
     * 放映厅ID
     */
    private String hallID;

    /**
     * 座位数量
     */
    private int seats;
    /**
     * 说明
     */
    private int description;
    /**
     * 是否删除 1删0不删
     */
    private int hallDisable;

    public String getHallID() {
        return hallID;
    }

    public void setHallID(String hallID) {
        this.hallID = hallID;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getHallDisable() {
        return hallDisable;
    }

    public void setHallDisable(int hallDisable) {
        this.hallDisable = hallDisable;
    }
}
