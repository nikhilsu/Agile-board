package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.User;

import java.util.List;

public interface UserDao {
    List<User> list();
    Response<Integer> save(User user);
    Response<User> findByEmail(String email) throws Exception;
    Response<User> findById(int userId);
}
