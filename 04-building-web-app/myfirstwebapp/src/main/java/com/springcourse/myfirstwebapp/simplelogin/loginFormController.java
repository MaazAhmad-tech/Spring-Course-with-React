package com.springcourse.myfirstwebapp.simplelogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class loginFormController {

    private AuthenticationService authenticationService;

    public loginFormController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //@GetMapping("/loginPage")
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET) //used GET method here
    public String getLoginPage()
    {
        return "simpleLoginForm";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.POST) //used POST method here
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String password, ModelMap model)
    {

        //Authentication (for simplicity we can use hardcoded auth for now)
        //name = Maaz
        //password = Maaz
        //If user is authenticated we redirect to welcome page
        if(authenticationService.authenticate(name, password))
        {
            model.put("name", name);
            return "welcome";
        }
        else{
            model.put("errorMessage", "Invalid Credentials. Please try again!");
            //else we redirect the user to login page again with error message populated
            return "simpleLoginForm";
        }




    }
}
