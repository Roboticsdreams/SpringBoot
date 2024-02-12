package com.in28minutesspringframework.c12_xmlconfiguration;

import com.in28minutesspringframework.c05_springcreateobjects.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Arrays;

public  class XMLConfigurationLauncher {
    public static void main(String[] args) {
        try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            context.getBean(GameRunner.class).run();
        }
    }
}
