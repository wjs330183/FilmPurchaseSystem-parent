package com.ioe.service.impl;

import com.ioe.dao.HallDao;
import com.ioe.service.HallService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ioe.entity.Hall;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
@Service("hallService")
public class HallServiceImpl implements HallService {

    private static Logger logger = LoggerFactory.getLogger(HallServiceImpl.class);

    @Resource
    private HallDao hallDao;

    /**
    * 单个保存
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveHall(
            String hallId,
            String hallSeats,
            String hallDescription,
            String operator
    ){
        DataResult<String> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            Hall hall = new Hall();
            hall.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            hall.setHallId(hallId);
            hall.setHallSeats(hallSeats);
            hall.setHallDescription(hallDescription);
            hallDao.save(hall);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveHall error:{}", e.getMessage());
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
    DataResult<Boolean> saveHallBatch (String hallJson, String operator){
        if(CommonUtils.isEmpty(hallJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Hall> hallList = CommonUtils.getListByJson(hallJson, Hall.class);

            if (CommonUtils.isEmpty(hallList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            hallDao.saveBatch(hallList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveHallBatch error:{}", e.getMessage());
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

    public ListResult<Hall> getHallById (String id, int availData){
        ListResult<Hall> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Hall> hallList = hallDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(hallList)){
                result.setDataList(hallList);
            }
        } catch (Exception e){
            logger.error("saveHallById error:{}", e.getMessage());
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
    public DataResult<Integer> deleteHallById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = hallDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteHallById error:{}", e.getMessage());
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
    DataResult<Boolean> updateHall (
                String id,
                String hallId,
                String hallSeats,
                String hallDescription,
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
        Hall hall = new Hall();
        hall.setId(id);
        hall.setHallId(hallId);
        hall.setHallSeats(hallSeats);
        hall.setHallDescription(hallDescription);
        hallDao.update(hall);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateHall error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据hallId查询记录
    *
    * @param hallId 放映厅ID号
	
    */
    @Override

    public ListResult<Hall> getHallByHallId (String hallId, int availData){
        ListResult<Hall> result = new ListResult();
        //TODO:数据校验
        //if(){
        //    result.setCode("1");
        //    result.setCode("1");
        //    return result;
        //}
        try{
            // TODO : 前置代码
            List<Hall> hallList = hallDao.getByHallId(hallId, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(hallList)){
                result.setDataList(hallList);
            }
        } catch (Exception e){
            logger.error("getHallByHallId error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

}