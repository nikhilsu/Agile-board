package com.prorg.controller.auth;

import com.prorg.service.StoryboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/addStoryboard")
public class StoryboardController {

    private StoryboardService storyboardService;
    @Autowired
    public StoryboardController(StoryboardService storyboardService) {
        this.storyboardService = storyboardService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String showAddStoryboardForm() {
        return "addStoryboardForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addStoryboard(HttpServletRequest request, Model model) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
//        String createdBy = request.getParameter("dummyUser");
        String createdBy="Rohit";
        boolean saveSuccess = storyboardService.createStoryboard(title, description, createdBy);
        model. addAttribute("message", saveSuccess ? "Success" : "Failed");

        return "index";
    }
}
