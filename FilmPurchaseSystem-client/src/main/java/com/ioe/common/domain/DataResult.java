package com.ioe.common.domain;

/*
 *@Author Sddd[271133147@qq.com]
 *@Date 2018/4/24  20:50
 */

public class DataResult<T> extends Result {
    private static final long serialVersionUID = 5789764650870022341L;
    private T data;

    public DataResult() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
