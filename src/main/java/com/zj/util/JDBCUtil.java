package com.zj.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/***
 * JDBC 工具类
 * 1. 获取connection
 * 2. 释放资源
 */
public class JDBCUtil {

    /***
     * 获取Connection
     * @return 所获得Connection
     * @throws Exception SQLException
     */
    public static Connection getConnection() throws Exception{

        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String driverClassName = properties.getProperty("jdbc.driverClassName");
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");

        Class.forName(driverClassName);
        return  DriverManager.getConnection(url, user, password);
    }

    /***
     * 释放资源
     * @param resultSet 返回数据集
     * @param statement SQL语句
     * @param connection 数据库连接
     */
    public static void realease(ResultSet resultSet,
                                Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
