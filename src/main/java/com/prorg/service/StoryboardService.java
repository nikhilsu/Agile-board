package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.Storyboard;
import com.prorg.model.User;

import java.util.ArrayList;
import java.util.List;

public interface StoryboardService {
    Response<Integer> createStoryboard(String title, String description, User createdBy);
    Response<Storyboard> getStoryboardById(int storyboardId) throws Exception;
    Response updateUsersWhoHaveAccessToStoryboard(int storyboardId, ArrayList<User> usersWhoHaveAccess) throws Exception;
    Response<List<Storyboard>> getStoryboardGivenItsCreator(User creator) throws Exception;
}
