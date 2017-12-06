package main.java.com.prorg.service;

import com.prorg.model.User;

import java.util.List;

public interface ProjectService {
    boolean createProject(String title, String description, String createdBy);
}
