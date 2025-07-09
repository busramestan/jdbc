package com.busra;

import com.busra.config.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;;

public class Main {
    public static void main(String[] args) {
        String sql = "CREATE TABLE IF NOT EXISTS users ("+
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "email VARCHAR(50)" +
                ")";

        try(Connection connection = DatabaseConnector.getConnection();
            Statement statement = connection.createStatement()) {

            statement.execute(sql);
            System.out.println("Table created successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}