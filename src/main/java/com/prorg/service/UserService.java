package com.prorg.service;

import com.prorg.model.User;

import java.util.List;

public interface UserService {
    List<User> list();
    boolean createUser(String firstName, String lastName, String email, String password, String confirmPassword);
    int loginUser(String email, String password);
}
