package com.prorg.controller;

import com.prorg.helper.Constants;
import com.prorg.helper.result.Response;
import com.prorg.model.Storyboard;
import com.prorg.model.Swimlane;
import com.prorg.service.CardService;
import com.prorg.service.SwimlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(Constants.Route.ADD_SWIMLANE)
public class CardController {

    private CardService cardService;
    private SwimlaneService swimlaneService;

    @Autowired
    public CardController(CardService cardService, SwimlaneService swimlaneService) {
        this.cardService = cardService;
        this.swimlaneService = swimlaneService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCardToSwimlane(HttpServletRequest request, Model model) throws Exception {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int swimlaneId = Integer.valueOf(request.getParameter("swimlaneId"));

        Response response = swimlaneService.getSwimlaneById(swimlaneId);
        Swimlane swimlane = (Swimlane) response.data();
        Response cardCreation = cardService.createCard(name, description, swimlane);

        model.addAttribute(Constants.ModelAttributes.MESSAGE, cardCreation.isSuccessful() ? "Success" : "Failed");
        return Constants.RedirectPage.INDEX;
    }
}

