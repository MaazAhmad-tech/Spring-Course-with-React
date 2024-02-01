package com.springcourse.learnspringframework.depInjectionExercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("MySqlDataServiceQualifier")
public class MySqlDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
