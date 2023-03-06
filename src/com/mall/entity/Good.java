package com.mall.entity;
//建立货物类和相关方法
public class Good {
    private int good_id;
    private String name;
    private String category;
    private int price;
    private int stock;
    private String image;
    private String detail;

    public Good(int good_id, String name, String category, int price, int stock, String image, String detail)
    {

        this.setName(name);
        this.setCategory(category);
        this.setGood_id(good_id);
        this.setPrice(price);
        this.setStock(stock);
        this.setImage(image);
        this.setDetail(detail);
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
