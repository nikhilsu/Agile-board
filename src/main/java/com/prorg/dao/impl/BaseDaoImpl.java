package com.prorg.dao.impl;

import com.prorg.helper.QueryStatus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDaoImpl{
    private SessionFactory sessionFactory;

    public BaseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    QueryStatus save(Object object) {
        try {
            return QueryStatus.Success((int) getCurrentSession().save(object));
        } catch (HibernateException exception) {
            // TODO: Log exception
            System.out.println(exception.getMessage());
            return QueryStatus.Failure();
        }
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
