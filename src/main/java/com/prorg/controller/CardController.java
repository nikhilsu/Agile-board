package com.prorg.controller;

import com.prorg.helper.Constants;
import com.prorg.helper.result.Response;
import com.prorg.model.Swimlane;
import com.prorg.model.User;
import com.prorg.service.CardService;
import com.prorg.service.SwimlaneService;
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
public class CardController {

    private CardService cardService;
    private SwimlaneService swimlaneService;
    private UserService userService;

    @Autowired
    public CardController(CardService cardService, SwimlaneService swimlaneService, UserService userService) {
        this.cardService = cardService;
        this.swimlaneService = swimlaneService;
        this.userService = userService;
    }

    @RequestMapping(value = Constants.Route.ADD_CARD, method = RequestMethod.POST)
    public String addCardToSwimlane(HttpServletRequest request, HttpSession session, Model model) throws Exception {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int swimlaneId = Integer.valueOf(request.getParameter("swimlaneId"));
        int cardCreatorId = (int) session.getAttribute(Constants.SessionKeys.LOGGED_IN_USER);
        Response userById = userService.getUserById(cardCreatorId);
        // TODO: Check if user is null
        User creator = (User) userById.data();
        Response response = swimlaneService.getSwimlaneById(swimlaneId);
        Swimlane swimlane = (Swimlane) response.data();
        Response cardCreation = cardService.createCard(name, description, swimlane, creator);

        model.addAttribute(Constants.ModelAttributes.MESSAGE, cardCreation.isSuccessful() ? "Success" : "Failed");
        return Constants.RedirectPage.INDEX;
    }

    @RequestMapping(value = Constants.Route.UPDATE_USERS_OF_CARD, method = RequestMethod.POST)
    public String updateAssignedUsersOfCard(HttpServletRequest request, HttpSession session, @PathVariable("id") int cardId, Model model) throws Exception {
        ArrayList<User> assignedUsers = new ArrayList<>();
        for(String userId : request.getParameterValues("assignedUsers")) {
            Response getUser = userService.getUserById(Integer.valueOf(userId));
            if (getUser.isSuccessful()) {
                User user = (User) getUser.data();
                assignedUsers.add(user);
            }
        }
        Response updateAssignedUsersOfCard = cardService.updateAssignedUsersOfCard(cardId, assignedUsers);

        model.addAttribute(Constants.ModelAttributes.MESSAGE, updateAssignedUsersOfCard.isSuccessful() ? "Success" : "Failed");
        return Constants.RedirectPage.INDEX;
    }
}

