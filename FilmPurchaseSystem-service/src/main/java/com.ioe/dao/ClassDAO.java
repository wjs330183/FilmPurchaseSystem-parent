package com.ioe.dao;

import java.util.List;

public interface ClassDAO extends CommonDao {
    /**
     * 等级的DAO
     */
    public String createClass(Class aclass);//创建
    public List<Class> selectClassBySomething();//查找
    public List<Class> loadALL();//load
    public String deleteClass();//删除
}
