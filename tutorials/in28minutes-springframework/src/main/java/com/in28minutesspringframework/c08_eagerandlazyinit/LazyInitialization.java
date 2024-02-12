package com.in28minutesspringframework.c08_eagerandlazyinit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class LazyInitialization {
    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (LazyInitialization.class)) {

            System.out.println("Initialization of context is completed");
            context.getBean(ClassB.class).doSomething();
        }
    }
}