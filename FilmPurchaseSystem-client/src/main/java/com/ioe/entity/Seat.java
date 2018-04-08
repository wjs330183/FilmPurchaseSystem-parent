package com.ioe.entity;

public class Seat {
    /**
     * 座位ID
     */
    private String seatID;
    /**
     * 放映厅ID
     */
    private String hallID;
    /**
     * 行
     */
    private int seatRow;
    /**
     * 列
     */
    private int seatColumn;
    /**
     * 是否使用
     */
    private String seatIsActive;
    /**
     * 是否删除 1删0不删
     */
    private int seatDisable;

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public String getHallID() {
        return hallID;
    }

    public void setHallID(String hallID) {
        this.hallID = hallID;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    public String getSeatIsActive() {
        return seatIsActive;
    }

    public void setSeatIsActive(String seatIsActive) {
        this.seatIsActive = seatIsActive;
    }

    public int getSeatDisable() {
        return seatDisable;
    }

    public void setSeatDisable(int seatDisable) {
        this.seatDisable = seatDisable;
    }
}
