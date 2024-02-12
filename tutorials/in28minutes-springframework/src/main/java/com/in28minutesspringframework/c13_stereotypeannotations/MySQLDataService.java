package com.in28minutesspringframework.c13_stereotypeannotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("MySQLQualifier")
public class MySQLDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] {2,4,6,8,10};
    }
}
