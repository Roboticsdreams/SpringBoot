package com.in28minutesspringframework.c05_springcreateobjects;

import com.in28minutesspringframework.c05_springcreateobjects.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutesspringframework.c05_springcreateobjects.game")
public class AppGamingSpringBeanWithComponentScan {
    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (AppGamingSpringBeanWithComponentScan.class)) {

            context.getBean(GameRunner.class).run();

        }
    }
}
