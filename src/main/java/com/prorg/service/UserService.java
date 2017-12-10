package com.prorg.service;

import com.prorg.helper.QueryStatus;
import com.prorg.model.User;

import java.util.List;

public interface UserService {
    List<User> list();
    QueryStatus createUser(String firstName, String lastName, String email, String password, String confirmPassword);
    QueryStatus loginUser(String email, String password);
    User getUserById(int userId);
}
