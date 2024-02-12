package com.in28minutesspringframework.c13_stereotypeannotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
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
