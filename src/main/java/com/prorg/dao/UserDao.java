package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.User;

import java.util.List;

public interface UserDao {
    List<User> list();
    Response save(User user);
    Response findByEmail(String email) throws Exception;
    Response findById(int userId);
}
