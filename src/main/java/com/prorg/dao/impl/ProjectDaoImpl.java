package com.prorg.dao.impl;

import com.prorg.dao.ProjectDao;
import com.prorg.dao.UserDao;
import com.prorg.model.Project;
import com.prorg.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> list() {
        return getCurrentSession().createQuery("from Project").getResultList();
    }

    @Override
    public boolean save(Project project) {
        try {
            getCurrentSession().save(project);
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
