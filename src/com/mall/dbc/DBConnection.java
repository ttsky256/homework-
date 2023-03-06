package com.mall.dbc;

import java.sql.*;
import java.util.Date;

public class DBConnection {
    static final String URL = "jdbc:mysql://localhost:3306/shoppingmall?" +
            "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=true";
    static final String USER = "root";
    static final String PASSWORD = "cptbtptp123,,";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConn()
    {
        Connection connection = null;
        try
        {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    public static int executeInsert(String sql, Object[] params)
    {
        int count = 0;//检测是否有修改数据库内容，如果修改，就返回修改的行数
        Connection connection = DBConnection.getConn();
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++)
            {
                preparedStatement.setObject(i+1, params[i]);
            }
            count = preparedStatement.executeUpdate();

        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
            DBConnection.closeAll(null, preparedStatement, connection);
        }
        return count;
    }

    public static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection conn)
    {
        try
        {
            if(resultSet != null)
            {
                resultSet.close();
            }
            if(preparedStatement != null)
            {
                preparedStatement.close();
            }
            if(conn != null)
            {
                conn.close();
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    public static Timestamp getCurrentTime()
    {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }
}
