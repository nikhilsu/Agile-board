package com.prorg.service.impl;

import com.prorg.dao.UserDao;
import com.prorg.helper.Password;
import com.prorg.helper.QueryStatus;
import com.prorg.model.User;
import com.prorg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private Password passwordHash;

    @Autowired
    public UserServiceImpl(UserDao userDao, Password passwordHash) {
        this.userDao = userDao;
        this.passwordHash = passwordHash;
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public QueryStatus createUser(String firstName, String lastName, String email, String password, String confirmPassword) {
        if (!password.equals(confirmPassword))
            return QueryStatus.Failure();
        String salt = passwordHash.getNextSalt();
        String password_hash = passwordHash.hash(password, salt);
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setSalt(salt);
        user.setPassword(password_hash);
        return userDao.save(user);
    }

    @Override
    public QueryStatus loginUser(String email, String password) {
        User userByEmail = userDao.findByEmail(email);
        if(userByEmail == null || !passwordHash.isExpectedPassword(password, userByEmail.getSalt(), userByEmail.getPassword()))
            return QueryStatus.Failure();
        else
            return QueryStatus.Success(userByEmail.getId());
    }
}
