package com.ioe.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{

    private String sysCreator;
    private Date sysCreateTime;
    private String sysUpdater;
    private Date sysUpdateTime;
    private int sysDeleted;
    private int sysAvailData;
    private String sysHash;

    public BaseEntity() {
    }

    public String getSysCreator() {
        return this.sysCreator;
    }

    public void setSysCreator(String sysCreator) {
        this.sysCreator = sysCreator;
    }

    public Date getSysCreateTime() {
        return this.sysCreateTime;
    }

    public void setSysCreateTime(Date sysCreateTime) {
        this.sysCreateTime = sysCreateTime;
    }

    public String getSysUpdater() {
        return this.sysUpdater;
    }

    public void setSysUpdater(String sysUpdater) {
        this.sysUpdater = sysUpdater;
    }

    public Date getSysUpdateTime() {
        return this.sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public int getSysDeleted() {
        return this.sysDeleted;
    }

    public void setSysDeleted(int sysDeleted) {
        this.sysDeleted = sysDeleted;
    }

    public int getSysAvailData() {
        return this.sysAvailData;
    }

    public void setSysAvailData(int sysAvailData) {
        this.sysAvailData = sysAvailData;
    }

    public String getSysHash() {
        return this.sysHash;
    }

    public void setSysHash(String sysHash) {
        this.sysHash = sysHash;
    }


}
