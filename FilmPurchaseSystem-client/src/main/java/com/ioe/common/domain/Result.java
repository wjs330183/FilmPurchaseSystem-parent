package com.ioe.common.domain;

/*
 *@Author Sddd[271133147@qq.com]
 *@Date 2018/4/24  20:52
 */

import com.ioe.enums.ErrorEnum;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = -6866413938357794696L;
    private String requestId = null;
    private String code = null;
    private String message = null;

    public Result() {
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(ErrorEnum errorEnum) {
        this.code = errorEnum.getErrorinfo();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}