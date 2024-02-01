package com.springcourse.myfirstwebapp.simplelogin;

import org.springframework.stereotype.Component;
@Component
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isUsernameValid = username.equalsIgnoreCase("Maaz");
        boolean isPasswordValid = password.equals("Maaz");

        return isUsernameValid && isPasswordValid;
    }
}
