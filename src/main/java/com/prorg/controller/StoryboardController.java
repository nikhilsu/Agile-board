package com.prorg.controller;

import com.prorg.helper.Constants;
import com.prorg.helper.result.Response;
import com.prorg.model.User;
import com.prorg.service.StoryboardService;
import com.prorg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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
    public String showAddStoryboardForm() {
        return Constants.RedirectPage.STORY_BOARD_FORM;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addStoryboard(HttpServletRequest request, HttpSession session, Model model) throws Exception {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int createdById = (int) session.getAttribute(Constants.SessionKeys.LOGGED_IN_USER);
        Response response = userService.getUserById(createdById);
        // TODO: Add of check for response failure.
        User createdByUser = (User) response.data();
        Response save = storyboardService.createStoryboard(title, description, createdByUser);
        model.addAttribute(Constants.ModelAttributes.MESSAGE, save.isSuccessful() ? "Success" : "Failed");
        return Constants.RedirectPage.INDEX;
    }

    @RequestMapping(value = Constants.Route.UPDATE_USERS_OF_STORYBOARD, method = RequestMethod.POST)
    public String updateUsersWhoCanAccessStoryboard(HttpServletRequest request, @PathVariable("id") int storyboardId, Model model) throws Exception {
        ArrayList<User> usersWhoHaveAccess = new ArrayList<>();
        for (String userId : request.getParameterValues("usersWhoHaveAccess")) {
            Response getUser = userService.getUserById(Integer.valueOf(userId));
            if (getUser.isSuccessful()) {
                User user = (User) getUser.data();
                usersWhoHaveAccess.add(user);
            }
        }
        Response updateAssignedUsersOfCard = storyboardService.updateUsersWhoHaveAccessToStoryboard(storyboardId, usersWhoHaveAccess);

        model.addAttribute(Constants.ModelAttributes.MESSAGE, updateAssignedUsersOfCard.isSuccessful() ? "Success" : "Failed");
        return Constants.RedirectPage.INDEX;
    }
}
