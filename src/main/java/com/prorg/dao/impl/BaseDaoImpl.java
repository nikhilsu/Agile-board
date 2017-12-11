package com.prorg.dao.impl;

import com.prorg.helper.result.Response;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collections;

public abstract class BaseDaoImpl{
    private SessionFactory sessionFactory;

    public BaseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Response save(Object object) {
        try {
            int serialId = (int) getCurrentSession().save(object);
            return Response.Success(serialId);
        } catch (HibernateException exception) {
            // TODO: Log exception
            System.out.println(exception.getMessage());
            return Response.Failure(Collections.singletonList(exception.getMessage()));
        }
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
