package com.springcourse.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//record was introduced in Java - 16
//It has automatic constructors and toString methods implemented
record Person(String name, int age, Address address){};
record Address(String firstLine, String city){};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Maaz";
    }

    @Bean
    public int age(){
        return 24;
    }

    @Bean
    public Person person(){
        return new Person("John Doe", 30, new Address("LalBagh", "Delhi"));
    }

    //We can also use a custom bean name using @Bean(name = "customName")

    @Bean(name = "AddressBean")
    public Address address(){
        return new Address("221B Baker Street", "London");
    }

    @Bean(name = "PersonBean2")
    public Person person2(String name, int age, Address address){
        return new Person(name, age, address);
    }
}
