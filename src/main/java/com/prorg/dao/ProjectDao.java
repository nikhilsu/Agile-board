package com.prorg.dao;

import com.prorg.model.User;

import java.util.List;

public interface UserDao {
    List<User> list();
    boolean save(User user);
    User findByEmail(String email);
}
