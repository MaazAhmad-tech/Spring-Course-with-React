package com.springcourse.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class loginController {

    //Initializing a logger
    private Logger log = (Logger) LoggerFactory.getLogger(getClass());
    //http://localhost:8080/login?name=Maaz
    @GetMapping("/login")
    public String getLoginPage(@RequestParam String name, ModelMap model)
    {
        log.debug("Request param is: " + name);
        model.put("name", name);
        return "login";
    }
}
