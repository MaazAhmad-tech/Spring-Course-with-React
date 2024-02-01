package com.springcourse.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        //repository.insert(new Course(3, "Learn Spring Boot", "in28minutes"));
        //repository.deleteById(3);
        System.out.println(repository.selectById(1));
        System.out.println(repository.selectById(2));
    }
}
