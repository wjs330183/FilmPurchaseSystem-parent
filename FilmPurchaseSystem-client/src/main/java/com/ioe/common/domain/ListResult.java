package com.ioe.common.domain;

/*
 *@Author Sddd[271133147@qq.com]
 *@Date 2018/4/24  20:51
 */

import java.util.List;

public class ListResult<T> extends Result {
    private static final long serialVersionUID = 924734425329604463L;
    private List<T> dataList;

    public ListResult() {
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}