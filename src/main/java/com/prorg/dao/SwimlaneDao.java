package com.prorg.dao;

import com.prorg.helper.result.Response;
import com.prorg.model.Swimlane;

public interface SwimlaneDao {
    Response save(Swimlane swimlane);
    Response findById(int swimlaneId);
    Response deleteById(int swimlaneId);
    Response update(Swimlane swimlane);
}
