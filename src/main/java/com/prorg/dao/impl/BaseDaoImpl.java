package com.prorg.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDaoImpl{
    private SessionFactory sessionFactory;

    public BaseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    boolean save(Object object) {
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
