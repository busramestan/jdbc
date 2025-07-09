package com.busra.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(
                        DatabaseConfig.DATABASE_URL,
                        DatabaseConfig.DATABASE_USERNAME,
                        DatabaseConfig.DATABASE_PASSWORD);

            System.out.println("Connected established successfully");
            return connection;

        }catch (SQLException e) {
            System.err.println("Failed to connect");
            throw new RuntimeException(e);
        }

    }

}