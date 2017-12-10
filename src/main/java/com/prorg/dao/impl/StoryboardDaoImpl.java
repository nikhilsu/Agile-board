package com.prorg.dao.impl;

import com.prorg.dao.StoryboardDao;
import com.prorg.helper.QueryStatus;
import com.prorg.model.Storyboard;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoryboardDaoImpl extends BaseDaoImpl implements StoryboardDao {

    @Autowired
    public StoryboardDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Storyboard> list() {
        return getCurrentSession().createQuery("from Storyboard").getResultList();
    }

    @Override
    public QueryStatus save(Storyboard storyboard) {
        return super.save(storyboard);
    }
}
