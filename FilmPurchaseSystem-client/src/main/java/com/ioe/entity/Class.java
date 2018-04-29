package com.ioe.entity;

import java.math.BigDecimal;

public class Class extends BaseEntity{

    /**
     *
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
