package com.ioe.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ioe.dao.CommonDao;
import com.ioe.service.CommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonServiceImpl<T> implements CommonService<T> {

    @Autowired
    private CommonDao commonDao;

    @Transactional
    @Override
    public int batchCreateTable(String tableName, List<T> clazz) {
        //TODO
        String params = JSONObject.toJSON(clazz).toString();
        batchCreate(tableName, params);
        return 0;
    }

    private void batchCreate(String tableName, String params) {
        List<Map<String, String>> slaveTableDatas = new ArrayList<Map<String, String>>();
        JSONArray jsonArray = JSONArray.parseArray(params);
        if (StringUtils.isBlank(tableName)) {
            //TODO
        }
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            for (String key : jsonObject.keySet()) {
                if ("".equals(jsonObject.getString(key))) {
                    jsonObject.put(key, null);
                }
            }

            Map<String, String> masterTableData = new HashMap<String, String>();
            match(masterTableData, tableName, jsonObject);
            slaveTableDatas.add(masterTableData);
        }
        commonDao.batchCreateTable(tableName, slaveTableDatas);
    }
    /**
     * 将数据库字段转换为驼峰格式
     *
     * @param column
     * @return
     */
    private String parseHump(String column) {
        if (!column.contains("_")) {
            return column;
        }
        String res = "";
        String[] strs = column.split("_");
        for (String str : strs) {
            if (res.length() > 0) {
                str = str.substring(0, 1).toUpperCase() + str.substring(1);
            }
            res += str;
        }
        return res;
    }

    private void match(Map<String, String> result, String columns, JSONObject jsonObject) {
        for (String column : columns.split(",")) {
            if ("id".equals(column) || "disabled".equals(column) || "sys_last_modified_time"
                    .equals(column) || "sys_create_time".equals(column)) {
                continue;
            }
            //将数据库字段变更为驼峰式的类属性名
            String propertyColumnName = parseHump(column);
            String value = jsonObject.getString(propertyColumnName);
            //插入对应的值
            result.put(column, value);
        }
    }

}
