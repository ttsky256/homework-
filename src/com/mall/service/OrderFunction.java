package com.mall.service;


import com.mall.dbc.DBConnection;
import com.mall.entity.Order;
import com.mall.entity.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderFunction {
    public static void insert(Order order)
    {
        String sql = "insert into orders values(?,?,?,?,?,?)";
        Object[] params = {
                order.getOrder_id(),
                order.getUser_id(),
                order.getTotal_price(),
                order.getGoods(),
                order.getCreateTime(),
                order.getPayTime()
        };
        DBConnection.executeInsert(sql, params);
    }
    
    public static List<Record> createOrder(String goods)
    {
        String[] goodArr = goods.split("#");
        List<Record> orderList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;
        String name = "";
        int price = 0;
        
        try
        {
            String sql = "select name, price from goods where good_id=?";
            for(String g : goodArr)
            {
                String[] good1 = g.split("x");
                String[] good = good1[0].split("~");
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, good[1]);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    name = resultSet.getString("name");
                    price = resultSet.getInt("price");
                }

                int good_id = Integer.parseInt(good[1]);
                int count = Integer.parseInt(good1[1]);
                int record_id = Integer.parseInt(good[0]);
                Record record = new Record(record_id, good_id, "", name, count, price * count);
                orderList.add(record);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally
        {
            DBConnection.closeAll(resultSet, preparedStatement, connection);
        }
        return orderList;
    }

    public static List<Order> getOrders(String user_id)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;
        List<Order> orders = new ArrayList<>();

        try
        {
            String sql = "select * from orders where user_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                int order_id = resultSet.getInt("order_id");
                int total_price = resultSet.getInt("total_price");
                String goods = resultSet.getString("goods");
                Timestamp createTime = resultSet.getTimestamp("create_date");
                Timestamp payTime = resultSet.getTimestamp("pay_date");

                Order order = new Order(order_id, user_id, total_price, goods, createTime, payTime);
                orders.add(order);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally {
            DBConnection.closeAll(resultSet, preparedStatement, connection);
        }
        return orders;
    }

    public static void pay(int order_id)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();

        try
        {
            String sql = "update orders set payTime=? where order_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, DBConnection.getCurrentTime());
            preparedStatement.setInt(2, order_id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally {
            DBConnection.closeAll(null, preparedStatement, connection);
        }
    }

    public static String getGoods(int order_id)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;
        String goods = "";

        try
        {
            String sql = "select goods from orders where order_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order_id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                goods = resultSet.getString("goods");
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally {
            DBConnection.closeAll(resultSet, preparedStatement, connection);
        }
        return goods;
    }

    public static void cancelOrder(int order_id)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();

        try
        {
            String sql = "delete from orders where order_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order_id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally {
            DBConnection.closeAll(null, preparedStatement, connection);
        }
    }
}
