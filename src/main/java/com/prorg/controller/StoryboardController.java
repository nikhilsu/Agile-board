package com.prorg.controller;

import com.prorg.helper.Constants;
import com.prorg.service.StoryboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Constants.Route.ADD_STORYBOARD)
public class StoryboardController {

    private StoryboardService storyboardService;
    @Autowired
    public StoryboardController(StoryboardService storyboardService) {
        this.storyboardService = storyboardService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String showAddStoryboardForm() {
        return Constants.RedirectPage.STORY_BOARD_FORM;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addStoryboard(HttpServletRequest request, HttpSession session, Model model) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int createdBy = (int) session.getAttribute(Constants.User.LOGGED_IN_USER_SESSION_KEY);
        boolean saveSuccess = storyboardService.createStoryboard(title, description, createdBy);
        model. addAttribute(Constants.ModelAttributes.MESSAGE, saveSuccess ? "Success" : "Failed");

        return Constants.RedirectPage.INDEX;
    }
}
