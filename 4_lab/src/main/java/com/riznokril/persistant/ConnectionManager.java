package com.riznokril.persistant;

import java.sql.Connection;
import java.sql.DriverManager;


public final class ConnectionManager {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/rizhko?useUnicode=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "234432or";

    private static Connection connection;

    public ConnectionManager() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            if (connection == null || connection.isClosed()) {
                try {
                    connection = DriverManager.getConnection(
                            url,
                            user,
                            password
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}