package com.prorg.controller.auth;

import com.prorg.helper.Constants;
import com.prorg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(Constants.Route.REGISTER)
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm() {
        return Constants.RedirectPage.REGISTRATION_FORM;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model model) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        boolean saveSuccess = userService.createUser(firstName, lastName, email, password, confirmPassword);
        model. addAttribute(Constants.ModelAttributes.MESSAGE, saveSuccess ? "Success" : "Failed");

        return Constants.RedirectPage.INDEX;
    }
}
