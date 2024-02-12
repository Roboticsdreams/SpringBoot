package com.in28minutesspringframework.c13_stereotypeannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class RealworldSpringContext {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(RealworldSpringContext.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
