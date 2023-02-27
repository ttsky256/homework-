package com.mall.entity;
//记录类
public class Record {
    private int record_id;
    private int good_id;
    private String image;
    private String name;
    private int count;
    private int totalPrice;

    public Record(int record_id, int good_id, String image, String name, int count, int totalPrice) {
        this.record_id = record_id;
        this.good_id = good_id;
        this.image = image;
        this.name = name;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
