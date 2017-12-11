package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.Swimlane;

public interface CardService {
    Response createCard(String title, String description, Swimlane itsSwimlane);
}
