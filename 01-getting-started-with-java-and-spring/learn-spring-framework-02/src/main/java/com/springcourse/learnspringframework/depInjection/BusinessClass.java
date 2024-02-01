package com.springcourse.learnspringframework.depInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessClass {


    //There are 3 types of dependency Injection
    //1: Field Injection
    //2: Setter Injection
    //3: Constructor Injection (Recommended by Spring dev team)

    //Field Injection
    //@Autowired
    public Dependency1 dependency1;
    //@Autowired
    public Dependency2 dependency2;

    //Setter Injection
    /*@Autowired
    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }*/

    //Constructor Injection
    @Autowired
    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    @Override
    public String toString() {
        return "Using: " + dependency1 + " and "+ dependency2 ;
    }
}
