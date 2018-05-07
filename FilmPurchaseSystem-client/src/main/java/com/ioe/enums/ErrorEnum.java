package com.ioe.enums;

/*
 *@Author Sddd[271133147@qq.com]
 *@Date 2018/5/5  14:54
 */

public enum ErrorEnum {

    EMPTY_ERROR (1,"参数错误"),
    CREAT_ERROR(2,"创建失败"),
    UPDETE_ERROR(3,"更新失败"),
    DELETE_ERROR(4,"删除失败"),
    GET_ERROR(5,"获取失败"),
    QUERY_ERROR(6,"更新失败");

    private int error;

    private String errorinfo;

    ErrorEnum(int error, String errorinfo) {
        this.error = error;
        this.errorinfo = errorinfo;
    }

    public int getError() {
        return error;
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    public static ErrorEnum errorof(int index){
        for(ErrorEnum error : values()){
            if(error.getError() == index)
                return error;
        }
        return null;
    }
}
