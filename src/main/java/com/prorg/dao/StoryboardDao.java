package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.Storyboard;

import java.util.List;

public interface StoryboardDao {
    List<Storyboard> list();
    Response save(Storyboard storyboard);
}
