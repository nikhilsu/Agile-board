package com.prorg.service;

import com.prorg.helper.result.Response;
import com.prorg.model.Storyboard;

public interface SwimlaneService {
    Response createSwimlane(String name, Storyboard itsStoryBoard);
}
