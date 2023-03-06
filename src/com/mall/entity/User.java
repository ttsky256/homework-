package com.mall.entity;
//建立用户类及方法
public class User {
    private String user_id;
    private String user_pwd;
    private String sex;
    private String email;
    private String phone;
    private String address;

    public User(String user_id, String user_pwd, String sex, String email, String phone, String address)
    {
        this.setUser_id(user_id);
        this.setUser_pwd(user_pwd);
        this.setSex(sex);
        this.setEmail(email);
        this.setPhone(phone);
        this.setAddress(address);
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
