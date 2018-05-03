package com.ioe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ioe.common.domain.Result;
import com.ioe.dao.ClassDao;
import com.ioe.service.ClassService;
import com.ioe.utils.CommonUtils;
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
            String classIsactive,
            String operator
    ){
        DataResult<String> result = new DataResult();
        if(CommonUtils.isEmpty(classId)
                && CommonUtils.isEmpty(className)
                && CommonUtils.isEmpty(classIsactive)
                ){
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码(setId未设置)
            Class aClass = new Class();
            aClass.setClassId(classId);
            aClass.setClassName(className);
            aClass.setClassDiscount(new BigDecimal(classDiscount));
            classDao.save(aClass);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveClass error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 批量保存
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ListResult<String> saveClassBatch(String classJson, String operator){

        ListResult<String> result = new ListResult<String>();
        if(CommonUtils.isEmpty(classJson)){
            result.setCode("1");
            return result;
        }
        try{
            List<Class> classList = CommonUtils.getListByJson(classJson, Class.class);

            if (CommonUtils.isEmpty(classList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }
            List<String> ids = new ArrayList<String>();
            for (Class aClass : classList) {
                //TODO
//                aClass.setClassId();
                ids.add(aClass.getId());
            }
            // TODO : 前置代码
            classDao.saveBatch(classList);
            result.setDataList(ids);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveClassBatch error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据id获取对象
    */
    @Override
    public ListResult<Class> getClassById (String id, int availData){
        ListResult<Class> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Class> classList = classDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(classList)){
                result.setDataList(classList);
            }
        } catch (Exception e){
            logger.error("saveClassById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

    /**
    * 根据id删除对象
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteClassById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = classDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteClassById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }


    /**
    * 更新对象
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> updateClass (
                String id,
                String classId,
                String className,
                BigDecimal classDiscount,
                String classIsactive,
                String operator
    ){
        DataResult<Boolean> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        Class class = new Class();
        class.setId(id);
        class.setClassId(classId);
        class.setClassName(className);
        class.setClassDiscount(classDiscount);
        class.setClassIsactive(classIsactive);
        classDao.update(class);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateClass error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
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
    public ListResult<Class> getClassByClassId (String classId, int availData){
        ListResult<Class> result = new ListResult();
        //TODO:数据校验
        //if(){
        //    result.setCode("1");
        //    result.setCode("1");
        //    return result;
        //}
        try{
            // TODO : 前置代码
            List<Class> classList = classDao.getByClassId(classId, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(classList)){
                result.setDataList(classList);
            }
        } catch (Exception e){
            logger.error("getClassByClassId error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

}