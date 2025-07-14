package com.busra.dao;

import com.busra.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("+
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "email VARCHAR(50)" +
                ")";

        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
            return true;

        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public User save(User user) {

        String sql = "INSERT INTO users (name, email) VALUES (? , ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                long generatedId = rs.getLong(1);
                user.setId(generatedId);
            }

            return user;

        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public User update(User user) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setLong(3, user.getId());
            preparedStatement.executeUpdate();
            return user;

        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM users WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            System.out.println("User deleted");
            return true;


        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
            return false;
        }

    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
            return users;

        }catch (SQLException e) {
            return null;
        }

    }
}
