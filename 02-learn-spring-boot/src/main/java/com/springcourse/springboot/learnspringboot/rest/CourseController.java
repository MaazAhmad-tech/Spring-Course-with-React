package com.springcourse.springboot.learnspringboot.rest;

import com.springcourse.springboot.learnspringboot.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> retrieveAllCourses()
    {
        return Arrays.asList(
                new Course(1, "learn SpringBoot", "in28Minutes"),
                new Course(2, "learn AWS", "in28Minutes"),
                new Course(3, "learn Azure", "in28Minutes")
        );
    }
}
