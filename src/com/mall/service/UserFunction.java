package com.mall.service;

import com.mall.dbc.DBConnection;
import com.mall.entity.Good;
import com.mall.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFunction {
    public static int insert(User user)
    {
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        Object[] params = {
                user.getUser_id(),
                user.getUser_pwd(),
                user.getSex(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getTag()
        };
        return DBConnection.executeInsert(sql, params);
    }

    public static int selectByLogin(String user_id, String user_pwd)
    {
        int count = 0;
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;

        try
        {
            String sql = "select count(*) from user where user_id=? and user_pwd=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2, user_pwd);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                count = resultSet.getInt(1);
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
        return count;
    }
    public static List<User> loadUsers(){
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;
        List<User> result = new ArrayList<>();
        try{
            String sql = "select * from user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                String user_id = resultSet.getString("user_id");
                String tag = resultSet.getString("tag");

                User user=new User(user_id, "", "","", "", "",tag);
                result.add(user);
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
    public static User findUser(String user_id)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;
        User user = null;
        String email, phone, address,tag;

        try
        {
            String sql = "select sex, email, phone, address, tag from user where user_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                String sex = resultSet.getString("sex");
                email = resultSet.getString("email");
                phone = resultSet.getString("phone");
                address = resultSet.getString("address");
                tag = resultSet.getString("tag");
                user = new User(user_id, "", sex, email, phone, address,tag);
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
        return user;
    }
    public static String findUserTag(String user_id)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet = null;
        String tag="";

        try
        {
            String sql = "select tag from user where user_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                tag = resultSet.getString("tag");
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
        return tag;
    }
    public static int updateUser(User user)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();
        int count = 0;

        try
        {
            String sql = "update user set email=?, phone=?, address=? ,tag=? where user_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getTag());
            preparedStatement.setString(5, user.getUser_id());
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
