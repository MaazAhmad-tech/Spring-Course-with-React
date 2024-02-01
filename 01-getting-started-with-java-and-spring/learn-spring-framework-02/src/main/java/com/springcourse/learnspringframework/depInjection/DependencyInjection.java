package com.springcourse.learnspringframework.depInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.springcourse.learnspringframework.depInjection")
public class DependencyInjection {



    //There are 3 types of dependency Injection
    //1: Field Injection
    //2: Setter Injection
    //3: Constructor Injection (Recommended by Spring dev team)

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext
                (DependencyInjection.class)){

            Arrays.stream(context.getBeanDefinitionNames()).forEach(
                    System.out::println
            );

            System.out.println(context.getBean(BusinessClass.class));

        }
    }

}
