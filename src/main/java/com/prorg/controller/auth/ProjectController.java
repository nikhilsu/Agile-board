package main.java.com.prorg.controller.auth;

import com.prorg.service.UserService;
import com.prorg.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/addProject")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAddProjectForm() {
        return "addProjectForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addProject(HttpServletRequest request, Model model) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String createdBy = request.getParameter("dummyUser");
        boolean saveSuccess = projectService.createProject(title, description, createdBy);
        model. addAttribute("message", saveSuccess ? "Success" : "Failed");

        return "index";
    }
}
