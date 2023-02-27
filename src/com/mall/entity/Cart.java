package com.mall.entity;
//建立购物车类和所需的函数
public class Cart {
    private int record_id;
    private String user_id;
    private int good_id;
    private int count;

    public Cart(int record_id, String user_id, int good_id, int count) {
        this.record_id = record_id;
        this.user_id = user_id;
        this.good_id = good_id;
        this.count = count;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
