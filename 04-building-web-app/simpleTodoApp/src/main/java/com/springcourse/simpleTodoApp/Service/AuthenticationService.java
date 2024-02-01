package com.springcourse.simpleTodoApp.Service;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isUsernameValid = username.equalsIgnoreCase("Maaz");
        boolean isPasswordValid = password.equals("Maaz");

        return isUsernameValid && isPasswordValid;
    }
}
