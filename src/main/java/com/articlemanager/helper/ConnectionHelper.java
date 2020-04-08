package com.articlemanager.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionHelper {

    private static final String DATABASE_URL = "jdbc:mysql://localhost/article-manager?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Bangkok&characterEncoding=utf-8";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "";
    private static Connection connection; // ban đầu bằng null.

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            System.out.println("Khởi tạo kết nối mới đến db.");
            connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PWD);
        }
        return connection;
    }
}
