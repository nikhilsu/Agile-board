package com.prorg.controller;

import com.prorg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showLandingPage(ModelMap model) {
        model.addAttribute("message", "Hello, this is the landing page. Here are all the users in the system");
        model.addAttribute("users", userService.list());
        return "index";
    }
}
