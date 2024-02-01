package com.springcourse.simpleTodoApp.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(names = "name")
public class WelcomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET) //used GET method here
    public String gotoWelcomePage(ModelMap model)
    {
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    public String getLoggedInUsername()
    {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }
}
