package com.ioe.service;

import java.util.List;

public interface CommonService<T> {

    int batchCreateTable(String tableName, List<T> clazz);

}
