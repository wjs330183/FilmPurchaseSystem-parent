package dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonDao {

    String getTable(@Param("tableName") String tableName);

    int batchCreateTable(@Param("commonList") List commonList);

    int batchUpdate(@Param("commonList") List commonList);

}
