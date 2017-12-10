package com.prorg.dao.impl;

import com.prorg.dao.UserDao;
import com.prorg.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> list() {
        return getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    public boolean save(User user) {
        return super.save(user);
    }

    @Override
    public User findByEmail(String email) {
        Query query = getCurrentSession().createQuery("from User where email = :email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }
}
