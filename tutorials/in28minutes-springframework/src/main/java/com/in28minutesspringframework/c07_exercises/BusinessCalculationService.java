package com.in28minutesspringframework.c07_exercises;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {
    DataService dataService;

    public BusinessCalculationService(@Qualifier("MySQLQualifier") DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public int findMax() {
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }
}