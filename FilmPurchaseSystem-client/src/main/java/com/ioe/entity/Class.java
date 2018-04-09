package com.ioe.entity;

public class Class {
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
    /**
    是否删除
     */
    /*private int classdisabled;*/
    /**
     *
     * 是否使用
     */
   /* private int classIsActive;*/

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

    /*public int getClassdisabled() {
        return classdisabled;
    }

    public void setClassdisabled(int classdisabled) {
        this.classdisabled = classdisabled;
    }

    public int getClassIsActive() {
        return classIsActive;
    }

    public void setClassIsActive(int classIsActive) { this.classIsActive = classIsActive; }*/
}
