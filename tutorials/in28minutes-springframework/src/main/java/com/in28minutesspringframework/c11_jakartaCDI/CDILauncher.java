package com.in28minutesspringframework.c11_jakartaCDI;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CDILauncher {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(CDILauncher.class)) {
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
