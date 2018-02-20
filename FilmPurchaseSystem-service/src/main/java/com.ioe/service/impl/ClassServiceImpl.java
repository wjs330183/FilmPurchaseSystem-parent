package com.ioe.service.impl;


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
    private CommonService commonService;

    /**
     * 等级
     */
    @Transactional
    public void createClass(String json) {
        String tableName = "t_class";
        List<Class> classList = CommonUtils.getListByJson(json, Class.class);
        commonService.batchCreateTable(tableName, classList);
    }
}
