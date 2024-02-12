package com.in28minutesspringframework.c3_loosecoupling_springlevel1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppHelloworldSpring {
    public static void main(String[] args) {
        //1.Launch a Spring Context
        try (var context =
                     new AnnotationConfigApplicationContext(
                             HelloworldConfiguration.class))
        {
            //2.Configure the things that we want to spring to manage
            // HelloworldConfiguration - @Configuration
            // name - @Bean

            //3.Retrieving Bean managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("address"));
            System.out.println(context.getBean("newaddress"));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2methodcall"));
            System.out.println(context.getBean("person3parameters"));
            System.out.println(context.getBean("person4qualifier"));
            //3.1 retrieving beans using name and custom names
            //3.2 retrieving beans using type of class name
            //3.3 creating new beans using existing beans
        }
    }
}
