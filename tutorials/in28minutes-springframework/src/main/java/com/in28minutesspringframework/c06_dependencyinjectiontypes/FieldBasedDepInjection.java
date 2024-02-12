package com.in28minutesspringframework.c06_dependencyinjectiontypes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class FBYourBusiness {
    @Autowired
    CBDependency1 dependency1;
    @Autowired
    CBDependency2 dependency2;

    public String toString(){
        return "Using "+dependency1 + " and " +dependency2;
    }
}

@Component
class FBDependency1 {

}

@Component
class FBDependency2 {

}

@Configuration
@ComponentScan
public class FieldBasedDepInjection {
    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (FieldBasedDepInjection.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(FBYourBusiness.class));
        }
    }
}
