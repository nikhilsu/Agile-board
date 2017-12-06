package main.java.com.prorg.service.impl;

import com.prorg.dao.UserDao;
import com.prorg.helper.Password;
import com.prorg.model.User;
import com.prorg.model.Project;
import com.prorg.service.UserService;
import main.java.com.prorg.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public boolean createUser(String firstName, String lastName, String email, String password, String confirmPassword) {
        if (!password.equals(confirmPassword))
            return false;
        String salt = passwordHash.getNextSalt();
        String password_hash = passwordHash.hash(password, salt);
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setSalt(salt);
        user.setPassword(password_hash);
        return userDao.save(user);
    }

    @Override
    public boolean createProject(String title, String description, String createdBy){
        if(title.isEmpty() || description.isEmpty()){
            return false;
        }
        Project addProject= new Project();
        addProject.

    }

    @Override
    public boolean loginUser(String email, String password) {
        User userByEmail = userDao.findByEmail(email);
        return passwordHash.isExpectedPassword(password, userByEmail.getSalt(), userByEmail.getPassword());
    }
}
