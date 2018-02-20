package dao;

import java.util.List;

public interface ClassDAO {
    /**
     * 等级的DAO
     */
    public String createClass(Class aclass);//创建
    public List<Class> selectClassBySomething();//查找
    public List<Class> loadALL();//load
    public String deleteClass();//删除
}
