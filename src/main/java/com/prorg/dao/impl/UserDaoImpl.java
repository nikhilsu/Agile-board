package com.prorg.dao.impl;

import com.prorg.dao.UserDao;
import com.prorg.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> list() {
        return sessionFactory.openSession().createQuery("from User").getResultList();
    }

    @Override
    public void save() {

    }
}
