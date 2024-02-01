package com.springcourse.simpleTodoApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConiguration {

    //LDAP or Database

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {
        UserDetails user1 = createNewUser("Maaz");
        UserDetails user2 = createNewUser("Ahmad");
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    private UserDetails createNewUser(String username) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        return User.builder().passwordEncoder(passwordEncoder)
                .username(username)
                .password(username)
                .roles("USER", "ADMIIN")
                .build();
    }
}
