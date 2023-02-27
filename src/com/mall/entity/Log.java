package com.mall.entity;
//建立日志类及相关方法
import java.sql.Timestamp;

public class Log {
    private int log_id;
    private String user_id;
    private int good_id;
    private int count;
    private Timestamp time;
    private String act;

    public Log(int log_id, String user_id, int good_id, int count, Timestamp time, String act) {
        this.user_id = user_id;
        this.good_id = good_id;
        this.count = count;
        this.time = time;
        this.log_id = log_id;
        this.act = act;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
