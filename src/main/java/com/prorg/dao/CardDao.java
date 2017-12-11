package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.Card;

public interface CardDao {
    Response save(Card card);
}
