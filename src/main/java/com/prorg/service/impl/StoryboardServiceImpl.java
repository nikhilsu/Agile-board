package com.prorg.service.impl;

import com.prorg.helper.QueryStatus;
import com.prorg.model.Storyboard;
import com.prorg.dao.StoryboardDao;
import com.prorg.service.StoryboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StoryboardServiceImpl implements StoryboardService {

    private final StoryboardDao storyboardDao;

    @Autowired
    public StoryboardServiceImpl(StoryboardDao storyboardDao) {
        this.storyboardDao = storyboardDao;
    }


    @Override
    public QueryStatus createStoryboard(String title, String description, int createdBy){
        if(title.isEmpty())
            return QueryStatus.Failure();
        Storyboard addStoryboard = new Storyboard();
        addStoryboard.setTitle(title);
        addStoryboard.setDescription(description);
        addStoryboard.setUserId(createdBy);
        return storyboardDao.save(addStoryboard);
    }
}
