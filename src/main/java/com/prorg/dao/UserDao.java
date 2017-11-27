package com.prorg.dao;

import com.prorg.model.User;

import java.util.List;

public interface UserDao {
    List<User> list();
    void save();
}
