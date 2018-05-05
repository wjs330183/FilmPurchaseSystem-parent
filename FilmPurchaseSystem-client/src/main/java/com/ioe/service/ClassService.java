package com.ioe.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.entity.Class;

import java.math.BigDecimal;

/**
 * 描述： 服务实现层接口
 *
 * @author wangjs
 * @date 2018-04-19
 */
public interface ClassService {


    /**
     * 单个保存
     *
     * @param classId       等级ID号
     * @param className     等级名称
     * @param classDiscount 等级折扣
     * @param classIsactive 是否使用 使用/不使用：1/0
     * @param operator      操作者编号
     */
    DataResult<String> saveClass(String classId, String className, String classDiscount, Integer classIsactive, String operator);

    /**
     * 批量保存
     *
     * @param classJson 对象集合 Json 字符串
     * @param operator  操作者编号
     */
    ListResult<String> saveClassBatch(String classJson, String operator);

    /**
     * 根据id获取对象
     *
     * @param id
     */
    ListResult<Class> getClassById(String id);

    /**
     * 根据id删除对象
     *
     * @param id
     */
    DataResult<Integer> deleteClassById(String id, String operator);


    /**
     * 更新对象
     *
     * @param id
     * @param classId       等级ID号
     * @param className     等级名称
     * @param classDiscount 等级折扣
     * @param classIsactive 是否使用 使用/不使用：1/0
     * @param operator      操作者编号
     */
    DataResult<Integer> updateClass(String id, String classId, String className, String classDiscount, Integer classIsactive, String operator);

    /**
     * 根据classId查询记录
     *
     * @param classId 等级ID号
     */
    ListResult<Class> getClassByClassId(String classId);

}