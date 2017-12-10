package com.prorg.dao;

import com.prorg.helper.QueryStatus;
import com.prorg.model.User;

import java.util.List;

public interface UserDao {
    List<User> list();
    QueryStatus save(User user);
    User findByEmail(String email);
}
