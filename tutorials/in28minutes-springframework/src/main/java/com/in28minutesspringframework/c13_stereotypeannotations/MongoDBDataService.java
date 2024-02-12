package com.in28minutesspringframework.c13_stereotypeannotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MongoDBDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] {1,2,3,4,5};
    }
}
