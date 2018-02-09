package dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommonDao {

    String getTable(@Param("tableName") String tableName);

    int batchCreateTable(@Param("tableName") String tableName, @Param("datas") List<Map<String, String>> datas);

    int batchUpdate(@Param("tableName") String tableName, @Param("information") String information, @Param("datas") List<Map<String, String>> datas);

}
