package com.ioe.entity;

public class Class extends BaseEntity{
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
    private double classDiscount;

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

    public double getClassDiscount() {
        return classDiscount;
    }

    public void setClassDiscount(double classDiscount) {
        this.classDiscount = classDiscount;
    }

}
