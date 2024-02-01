package com.springcourse.learnspringframework.depInjectionExercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class BusinessClassServiceRunner {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(BusinessClassServiceRunner.class)){

            System.out.println(context.getBean(BusinessClassService.class).findMax());
            //System.out.println(context.getBean(MySqlDataService.class).retrieveData());
        }
    }
}
