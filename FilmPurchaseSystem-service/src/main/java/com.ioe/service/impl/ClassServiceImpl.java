package com.ioe.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.ioe.entity.Class;
import com.ioe.service.ClassService;
import com.ioe.service.CommonService;
import com.ioe.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("classService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private CommonService classService;
    private String tableName = "t_class";

    /**
     * 等级
     */
    @Transactional
    @Override
    public int createClass(String classJson) {

        List<Class> classList = CommonUtils.getListByJson(classJson, Class.class);
        classService.batchCreateTable(tableName, classList);
        return 0;
    }

    public int updateClass(String classJson) {
        return 0;
    }
}
