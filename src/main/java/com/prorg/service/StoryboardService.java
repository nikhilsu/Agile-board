package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.User;

import java.util.ArrayList;

public interface StoryboardService {
    Response createStoryboard(String title, String description, User createdBy);
    Response getStoryboardById(int storyboardId) throws Exception;
    Response updateUsersWhoHaveAccessToStoryboard(int storyboardId, ArrayList<User> usersWhoHaveAccess) throws Exception;
    Response getStoryboardGivenItsCreator(User creator) throws Exception;
}
