package com.prorg.dao.impl;

import com.prorg.dao.CardDao;
import com.prorg.helper.result.Response;
import com.prorg.model.Card;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CardDaoImpl extends BaseDaoImpl implements CardDao {

    public CardDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Response save(Card card) {
        return super.save(card);
    }
}
