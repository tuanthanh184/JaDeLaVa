package com.aptech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private final static String DB_URL = "jdbc:sqlserver://localhost/StudentManagement";
    private final static String USERNAME = "sa";
    private final static String PASSWORD = "1234567";
    private final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private Connection connection = null;

    private static DBManager dbManager;

    private DBManager() {

    }

    public static DBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Connection con = DBManager.getInstance().getConnection();
        if (con != null) {
            System.out.println("Ket noi thanh cong");
        } else {
            System.out.println("Ket noi that bai");
        }
    }
}
