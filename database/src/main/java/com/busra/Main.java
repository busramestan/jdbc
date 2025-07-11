package com.busra;

import com.busra.config.DatabaseConnector;

import java.sql.*;
;

public class Main {
    public static void main(String[] args) {
//        String sql = "CREATE TABLE IF NOT EXISTS users ("+
//                "id SERIAL PRIMARY KEY, " +
//                "name VARCHAR(50), " +
//                "email VARCHAR(50)" +
//                ")";
//
//        try(Connection connection = DatabaseConnector.getConnection();
//            Statement statement = connection.createStatement()) {
//
//            statement.execute(sql);
//            System.out.println("Table created successfully");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


        //Insert data into the users table

//        String sql = "INSERT INTO users (name, email) VALUES (? , ?)";
//
//        try (Connection connection = DatabaseConnector.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//            preparedStatement.setString(1, "mike");
//            preparedStatement.setString(2,"mike@gmail.com");
//            preparedStatement.executeUpdate();
//            System.out.println("Data inserted successfully");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//        String sql = "SELECT * FROM users";
//
//        try (Statement statement = DatabaseConnector.getConnection().createStatement()){
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String email = resultSet.getString("email");
//
//                System.out.printf("ID: %d, Name: %s, Email: %s\n", id, name, email);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


          //Update user

//        String upSql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
//        try (Connection connection = DatabaseConnector.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(upSql)) {
//            preparedStatement.setString(1, "Büşra");
//            preparedStatement.setString(2, "büşra@gmail.com");
//            preparedStatement.setInt(3, 1);
//            int rowsUpdated = preparedStatement.executeUpdate();
//
//            if ( rowsUpdated > 0){
//                System.out.println("User updated successfully");;
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


        //Delete user

        String delSql = "DELETE FROM users WHERE id=?";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(delSql)){
            preparedStatement.setInt(1, 4);

            int rowsDelete = preparedStatement.executeUpdate();
            if (rowsDelete >0) {
                System.out.println("User deleted");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}