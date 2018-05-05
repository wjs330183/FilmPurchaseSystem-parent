package com.ioe.dao;

import com.ioe.entity.Class;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface ClassDao {

    int save(@Param("entity")Class entity);

    int saveBatch(@Param("entities")List<Class> entities);

    int update(@Param("entity")Class entity);

    List<Class> getById (@Param("id")String id);

    int deleteById (String id, @Param("operator")String operator);



    /**
    * index:t_cjlu_class ==> Class_ID_UNIQUE
    */
    List<Class> getByClassId (String classId);

}