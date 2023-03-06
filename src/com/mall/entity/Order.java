package com.mall.entity;
//建立订单类及相关方法
import java.sql.Timestamp;

public class Order {
    private int order_id;
    private String user_id;
    private int total_price;
    private String goods;
    private Timestamp createTime;
    private Timestamp payTime;

    public Order(int order_id, String user_id, int total_price, String goods, Timestamp createTime, Timestamp payTime) {

        this.user_id = user_id;
        this.order_id = order_id;
        this.payTime = payTime;
        this.goods = goods;
        this.total_price = total_price;
        this.createTime = createTime;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }
}
