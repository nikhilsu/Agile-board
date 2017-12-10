package com.prorg.dao;

import com.prorg.helper.QueryStatus;
import com.prorg.model.Storyboard;

import java.util.List;

public interface StoryboardDao {
    List<Storyboard> list();
    QueryStatus save(Storyboard storyboard);
}
