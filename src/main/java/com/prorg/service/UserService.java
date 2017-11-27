package com.prorg.service;

import com.prorg.model.User;

import java.util.List;

public interface UserService {
    List<User> list();
    void save();
}
