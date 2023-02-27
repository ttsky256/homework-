package com.mall.service;

import com.mall.dbc.DBConnection;
import com.mall.entity.Log;

public class LogFunction {
    public static void insert(Log log)
    {
        String sql = "insert into logs values(?,?,?,?,?,?)";
        Object[] params = {
                log.getUser_id(),
                log.getGood_id(),
                log.getCount(),
                log.getTime(),
                log.getLog_id(),
                log.getAct()
        };
        DBConnection.executeInsert(sql, params);
    }
}
