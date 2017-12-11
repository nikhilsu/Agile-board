package com.prorg.controller;

import com.prorg.helper.Constants;
import com.prorg.helper.result.Response;
import com.prorg.model.User;
import com.prorg.service.StoryboardService;
import com.prorg.service.UserService;
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
    private UserService userService;

    @Autowired
    public StoryboardController(StoryboardService storyboardService, UserService userService) {
        this.storyboardService = storyboardService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showAddStoryboardForm(HttpSession session) {
        if (isUserLoggedIn(session))
            return Constants.RedirectPage.STORY_BOARD_FORM;
        else
            return Constants.RedirectPage.INDEX;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addStoryboard(HttpServletRequest request, HttpSession session, Model model) throws Exception {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        if (isUserLoggedIn(session)) {
            int createdById = (int) session.getAttribute(Constants.SessionKeys.LOGGED_IN_USER);
            Response response = userService.getUserById(createdById);
            // TODO: Add of check for response failure.
            User createdByUser = (User) response.data();
            Response save = storyboardService.createStoryboard(title, description, createdByUser);
            model.addAttribute(Constants.ModelAttributes.MESSAGE, save.isSuccessful() ? "Success" : "Failed");
        }
        return Constants.RedirectPage.INDEX;
    }

    private boolean isUserLoggedIn(HttpSession session) {
        return session.getAttribute(Constants.SessionKeys.LOGGED_IN_USER) != null;
    }
}
