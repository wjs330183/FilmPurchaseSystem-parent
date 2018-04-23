package com.ioe.entity;

public class Customer extends BaseEntity{
    /**
     * 用户ID
     */
    private String customerId;
    /**
     * 用户姓名
     */
    private String customerName;
    /**
     * 用户邮箱
     */
    private String customerEmail;
    /**
     * 用户电话
     */
    private String customerMobile;
    /**
     * 等级号
     */
    private String classId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

}

