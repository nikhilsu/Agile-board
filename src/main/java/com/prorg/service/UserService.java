package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.User;

import java.util.List;

public interface UserService {
    List<User> list();
    Response createUser(String firstName, String lastName, String email, String password, String confirmPassword) throws Exception;
    Response loginUser(String email, String password) throws Exception;
    Response getUserById(int userId) throws Exception;
}
