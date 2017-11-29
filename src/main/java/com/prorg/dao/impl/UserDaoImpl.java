package com.prorg.dao.impl;

import com.prorg.dao.UserDao;
import com.prorg.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> list() {
        return getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    public boolean save(User user) {
        try {
            getCurrentSession().save(user);
            return true;
        } catch (HibernateException exception) {
            // TODO: Log exception
            System.out.println(exception.getMessage());
            return false;
        }
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
