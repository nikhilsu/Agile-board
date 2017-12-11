package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.User;

public interface StoryboardService {
    Response createStoryboard(String title, String description, User createdBy);
}
