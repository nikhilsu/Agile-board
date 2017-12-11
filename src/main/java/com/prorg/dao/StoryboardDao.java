package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.Storyboard;

import java.util.List;

public interface StoryboardDao {
    List<Storyboard> list();
    Response save(Storyboard storyboard);
    Response findById(int storyboardId);
    Response deleteById(int storyboardId);
    Response update(Storyboard storyboard);
}
