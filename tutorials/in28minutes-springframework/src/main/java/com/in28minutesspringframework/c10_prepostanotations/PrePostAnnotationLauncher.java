package com.in28minutesspringframework.c10_prepostanotations;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PrePostAnnotationLauncher {
    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (PrePostAnnotationLauncher.class)) {

        }
    }
}