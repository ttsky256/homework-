package com.mall.service;

import com.mall.dbc.DBConnection;
import com.mall.entity.Good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodFunction {
    public static List<Good> loadGoods(){
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;
        List<Good> result = new ArrayList<>();
        try{
            String sql = "select * from goods";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                int good_id = resultSet.getInt("good_id");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                String image = resultSet.getString("image");
                String detail = resultSet.getString("detail");

                Good good =  new Good(good_id, name, category, price, stock, image, detail);
                result.add(good);
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
        return result;
    }
    public static Good findGood(int good_id){
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;
        Good good = null;
        try
        {
            String sql = "select * from goods where good_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, good_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                String image = resultSet.getString("image");
                String detail = resultSet.getString("detail");
                return new Good(good_id, name, category, price, stock, image, detail);
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
        return null;
    }

    public static void sell(int good_id, int count)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();

        try
        {
            String sql = "update goods set stock=stock-? where good_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, count);
            preparedStatement.setInt(2, good_id);
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

    public static int findStock(int good_id)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;

        try
        {
            String sql = "select stock from goods where good_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, good_id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                return resultSet.getInt("stock");
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally {
            DBConnection.closeAll(resultSet, preparedStatement, connection);
        }
        return 0;
    }

    public static void cancel(int good_id, int count)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();

        try
        {
            String sql = "update goods set stock=stock+? where good_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, count);
            preparedStatement.setInt(2, good_id);
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

    public static int insert(Good good)
    {
        String sql = "insert into goods values(?,?,?,?,?,?,?)";
        Object[] params = {
                good.getName(),
                good.getCategory(),
                good.getGood_id(),
                good.getPrice(),
                good.getStock(),
                good.getImage(),
                good.getDetail()
        };
        return DBConnection.executeInsert(sql, params);
    }
    public static int updateGood(Good good)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        int count = 0;

        try
        {
            String sql = "update goods set price=?, stock=?,image=?, detail=? where good_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(good.getPrice()));
            preparedStatement.setString(2, String.valueOf(good.getStock()));
            preparedStatement.setString(3, good.getImage());
            preparedStatement.setString(4, good.getDetail());
            preparedStatement.setString(5, String.valueOf(good.getGood_id()));
            count = preparedStatement.executeUpdate();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally {
            DBConnection.closeAll(null, preparedStatement, connection);
        }
        return count;
    }
}
