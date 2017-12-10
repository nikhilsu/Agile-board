package com.prorg.service;

import com.prorg.helper.QueryStatus;

public interface StoryboardService {
    QueryStatus createStoryboard(String title, String description, int createdBy);
}
