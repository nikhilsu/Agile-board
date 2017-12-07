package com.prorg.dao.impl;

import com.prorg.dao.StoryboardDao;
import com.prorg.model.Storyboard;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoryboardDaoImpl implements StoryboardDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public StoryboardDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Storyboard> list() {
        return getCurrentSession().createQuery("from Storyboard").getResultList();
    }

    @Override
    public boolean save(Storyboard storyboard) {
        try {
            getCurrentSession().save(storyboard);
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
