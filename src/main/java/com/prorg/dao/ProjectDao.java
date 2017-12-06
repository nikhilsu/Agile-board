package com.prorg.dao;

import com.prorg.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> list();
    boolean save(Project project);
}
