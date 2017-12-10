package com.prorg.dao.impl;

import com.prorg.dao.BaseDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDaoImpl implements BaseDao {
    private SessionFactory sessionFactory;

    public BaseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean save(Object object) {
        try {
            getCurrentSession().save(object);
            return true;
        } catch (HibernateException exception) {
            // TODO: Log exception
            System.out.println(exception.getMessage());
            return false;
        }
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
