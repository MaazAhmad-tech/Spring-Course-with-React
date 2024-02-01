package com.springcourse.springboot.learnspringboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String sayHelloWorld()
    {
        return "Hello World!";
    }
}
