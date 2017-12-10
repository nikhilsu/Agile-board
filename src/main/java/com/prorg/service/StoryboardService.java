package com.prorg.service;

import com.prorg.helper.QueryStatus;
import com.prorg.model.User;

public interface StoryboardService {
    QueryStatus createStoryboard(String title, String description, User createdBy);
}
