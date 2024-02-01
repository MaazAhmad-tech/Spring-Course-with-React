package com.springcourse.learnspringframework.depInjectionExercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
//@Qualifier("MongoDbDataServiceQualifier")
@Primary
@Repository //We can use @Repository annotation to specify that this class is connecting to the Database
public class MongoDbDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[]{11, 22, 33, 44, 55};
    }
}
