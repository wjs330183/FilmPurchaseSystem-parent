package com.ioe.service.impl;

import com.ioe.dao.ClassDao;
import com.ioe.enums.ErrorEnum;
import com.ioe.service.ClassService;
import com.ioe.utils.CommonUtils;
import com.ioe.utils.SnowflakeIdWorkerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;

import java.util.*;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ioe.entity.Class;


/**
 * 描述：
 *
 * @author wangjs
 * @date 2018-04-19
 */
@Service("classService")
public class ClassServiceImpl implements ClassService {

    private static Logger logger = LoggerFactory.getLogger(ClassServiceImpl.class);

    @Resource
    private ClassDao classDao;

    /**
     * 单个保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveClass(
            String classId,
            String className,
            String classDiscount,
            Integer classIsactive,
            String operator
    ) {
        DataResult<String> result = new DataResult();
        if (CommonUtils.isAnyEmpty(classId,className,classDiscount,String.valueOf(classIsactive),operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            Class aClass = new Class();
            aClass.setId(SnowflakeIdWorkerUtils.getnextId(operator));
            aClass.setClassId(classId);
            aClass.setClassName(className);
            aClass.setClassDiscount(new BigDecimal(classDiscount));
            aClass.setClassIsactive(classIsactive);
            aClass.setSysCreator(operator);
            aClass.setSysUpdater(operator);
            classDao.save(aClass);
            result.setData(aClass.getId());
        } catch (Exception e) {
            logger.error("saveClass error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveClass is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 批量保存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ListResult<String> saveClassBatch(String classJson, String operator) {

        ListResult<String> result = new ListResult<String>();
        if (CommonUtils.isAnyEmpty(classJson,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            List<Class> classList = CommonUtils.getListByJson(classJson, Class.class);

            List<String> ids = new ArrayList<String>();
            for (Class aClass : classList) {
                aClass.setId(SnowflakeIdWorkerUtils.getnextId(operator));
                ids.add(aClass.getId());
            }
            classDao.saveBatch(classList);
            result.setDataList(ids);
        } catch (Exception e) {
            logger.error("saveClassBatch error:{}", e.getMessage());
            result.setCode(ErrorEnum.CREAT_ERROR);
            result.setMessage("saveClassBatch is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据id获取对象
     */
    @Override
    public ListResult<Class> getClassById(String id) {
        ListResult<Class> result = new ListResult();
        if (CommonUtils.isEmpty(id)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {

            List<Class> classList = classDao.getById(id);

            result.setDataList(classList);

        } catch (Exception e) {
            logger.error("saveClassById error:{}", e.getMessage());
            result.setCode(ErrorEnum.GET_ERROR);
            result.setMessage("getClassById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteClassById(String id, String operator) {
        DataResult<Integer> result = new DataResult();

        if (CommonUtils.isAnyEmpty(id,operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            // TODO : 未理解cout为何会增加
            int count = classDao.deleteById(id, operator);

            result.setData(count);
        } catch (Exception e) {
            logger.error("deleteClassById error:{}", e.getMessage());
            result.setCode(ErrorEnum.DELETE_ERROR);
            result.setMessage("deleteClassById is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
     * 更新对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> updateClass(
            String id,
            String classId,
            String className,
            String classDiscount,
            Integer classIsactive,
            String operator
    ) {
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isAnyEmpty(id,classId,className,classDiscount,String.valueOf(classIsactive),operator)) {
            result.setCode(ErrorEnum.EMPTY_ERROR);
            return result;
        }
        try {
            Class aclass = new Class();
            aclass.setId(id);
            aclass.setClassId(classId);
            aclass.setClassName(className);
            aclass.setClassDiscount(new BigDecimal(classDiscount));
            aclass.setClassIsactive(classIsactive);
            aclass.setSysUpdater(operator);

            int count = classDao.update(aclass);
            result.setData(count);

        } catch (Exception e) {
            logger.error("updateClass error:{}", e.getMessage());
            result.setCode(ErrorEnum.UPDETE_ERROR);
            result.setMessage("updateClass is error");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
     * 根据classId查询记录
     *
     * @param classId 等级ID号
     */
    @Override
    public ListResult<Class> getClassByClassId(String classId) {
        ListResult<Class> result = new ListResult();
       if(CommonUtils.isEmpty(classId)){
           result.setCode(ErrorEnum.EMPTY_ERROR);
           return result;
       }
        try {

            List<Class> classList = classDao.getByClassId(classId);

            result.setDataList(classList);

        } catch (Exception e) {
            logger.error("getClassByClassId error:{}", e.getMessage());
            result.setCode(ErrorEnum.QUERY_ERROR);
            result.setMessage("getClassByClassId is error");
        }
        return result;
    }

}