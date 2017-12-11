package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.Swimlane;
import com.prorg.model.User;

import java.util.ArrayList;

public interface CardService {
    Response createCard(String title, String description, Swimlane itsSwimlane, User creator);
    Response getCardById(int cardId) throws Exception;
    Response updateAssignedUsersOfCard(int cardId, ArrayList<User> assignedUsers) throws Exception;
}
