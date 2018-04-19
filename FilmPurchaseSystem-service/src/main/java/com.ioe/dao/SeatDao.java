package com.ioe.dao;

import com.ioe.entity.Seat;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author wangjs
* @date 2018-04-19
*/
public interface SeatDao {

    int save(@Param("entity")Seat entity);

    int saveBatch(@Param("entities")List<Seat> entities);

    int update(@Param("entity")Seat entity);

    List<Seat> getById (@Param("id")String id, @Param("availData")int availData);

    int deleteById (String id, @Param("operator")String operator);



    /**
    * index:t_cjlu_seat ==> Seat_ID_UNIQUE
    */
    List<Seat> getBySeatId (String seatId, @Param("availData")int availData);

}