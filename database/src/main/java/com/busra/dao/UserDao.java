package com.busra.dao;

import com.busra.user.User;

import java.util.List;

public interface UserDao {

    boolean createUserTable();
    User save(User user);
    User update(User user);
    boolean delete(long id);
    List<User> getAll();
}
