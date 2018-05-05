package com.ioe.entity;

import java.math.BigDecimal;

public class Class extends BaseEntity{

    /**
     *ID
     */
    private String id;

    /**
     * 等级ID
     */
    private String classId;
    /**
     *等级名称
     */
    private String className;
    /**
     * 等级折扣
     */
    private BigDecimal classDiscount;


    /*
    * 是否使用 使用/不使用：1/0
    * */
    private Integer classIsactive;

    public Integer getClassIsactive() {
        return classIsactive;
    }

    public void setClassIsactive(Integer classIsactive) {
        this.classIsactive = classIsactive;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BigDecimal getClassDiscount() {
        return classDiscount;
    }

    public void setClassDiscount(BigDecimal classDiscount) {
        this.classDiscount = classDiscount;
    }

}
