package com.in28minutesspringframework.c07_exercises;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RealworldSpringContextExercise {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(RealworldSpringContextExercise.class)) {
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
