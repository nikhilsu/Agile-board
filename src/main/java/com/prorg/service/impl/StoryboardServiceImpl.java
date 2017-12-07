package com.prorg.service.impl;

import com.prorg.model.Storyboard;
import com.prorg.model.User;
import com.prorg.dao.ProjectDao;
import com.prorg.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }


    @Override
    public boolean createProject(String title, String description, String createdBy){
        if(title.isEmpty() || description.isEmpty()){
            return false;
        }
        Project addProject= new Project();
        addProject.setTitle(title);
        addProject.setDescription(description);
        addProject.setUser_id(createdBy);
        return projectDao.save(addProject);

    }

}
