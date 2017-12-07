package com.prorg.dao;

import com.prorg.model.Storyboard;

import java.util.List;

public interface StoryboardDao {
    List<Storyboard> list();
    boolean save(Storyboard storyboard);
}
