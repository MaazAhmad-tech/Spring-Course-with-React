package com.springcourse.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        //repository.insert(new Course(3, "Learn Spring Boot", "in28minutes"));
        //repository.deleteById(3);
        System.out.println(repository.selectById(1));
        System.out.println(repository.selectById(2));
    }
}
