package com.mall.service;

import com.mall.dbc.DBConnection;
import com.mall.entity.Cart;
import com.mall.entity.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartFunction {
    public static int insert(Cart cart)
    {
        String sql = "insert into car values(?,?,?,?)";
        Object[] params = {
                cart.getRecord_id(),
                cart.getUser_id(),
                cart.getGood_id(),
                cart.getCount()
        };
        return DBConnection.executeInsert(sql, params);
    }
    public static List<Record> loadRecords(String user_id)//加载记录
    {
        PreparedStatement preparedStatement1 = null, preparedStatement2 = null;
        Connection connection = DBConnection.getConn();
        ResultSet resultSet1 = null, resultSet2 = null;
        List<Record> result = new ArrayList<>();
        try
        {
            String sql = "select * from car where user_id=?";
            preparedStatement1 = connection.prepareStatement(sql);
            preparedStatement1.setString(1, user_id);
            resultSet1 = preparedStatement1.executeQuery();

            while(resultSet1.next())
            {
                int good_id = resultSet1.getInt("good_id");
                int count = resultSet1.getInt("count");
                int record_id = resultSet1.getInt("record_id");
                String image = "";
                String name = "";
                int price = 0;

                sql = "select * from goods where good_id=?";
                preparedStatement2 = connection.prepareStatement(sql);
                preparedStatement2.setString(1, String.valueOf(good_id));
                resultSet2 = preparedStatement2.executeQuery();

                if(resultSet2.next())
                {
                    image = resultSet2.getString("image");
                    price = resultSet2.getInt("price");
                    name = resultSet2.getString("name");
                }

                Record record = new Record(record_id, good_id, image, name, count, count * price);
                result.add(record);
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            DBConnection.closeAll(resultSet1, preparedStatement1, connection);
            DBConnection.closeAll(resultSet2, preparedStatement2, null);
        }
        return result;
    }

    public static void deleteRecord(int record_id)
    {
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConn();

        try
        {
            String sql = "delete from car where record_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(record_id));
            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally {
            DBConnection.closeAll(null, preparedStatement, connection);
        }
    }
}
