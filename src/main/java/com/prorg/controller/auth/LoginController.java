package com.prorg.controller.auth;

import com.prorg.helper.Constants;
import com.prorg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = Constants.Route.LOGIN, method = RequestMethod.GET)
    public String showLoginForm() {
        return Constants.RedirectPage.LOGIN_FORM;
    }

    @RequestMapping(value = Constants.Route.LOGIN, method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int userId = userService.loginUser(email, password);
        String messageOnRedirectPage;
        if (userId != -1) {
            messageOnRedirectPage = "Login Successful";
            session.setAttribute(Constants.User.LOGGED_IN_USER_SESSION_KEY, userId);
        }
        else
            messageOnRedirectPage = "Login Failed";
        model.addAttribute(Constants.ModelAttributes.MESSAGE, messageOnRedirectPage);
        return Constants.RedirectPage.INDEX;
    }

    @RequestMapping(value = Constants.Route.LOGOUT)
    public String logout(HttpSession session) {
        session.removeAttribute(Constants.User.LOGGED_IN_USER_SESSION_KEY);
        return Constants.RedirectPage.INDEX;
    }
}
