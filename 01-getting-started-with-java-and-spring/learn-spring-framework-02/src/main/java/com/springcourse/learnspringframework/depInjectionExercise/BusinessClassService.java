package com.springcourse.learnspringframework.depInjectionExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service //We can use @Service annotation to specify that this class contains business logic
public class BusinessClassService {

    public DataService dataService;
    @Autowired
    public BusinessClassService(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
