package com.in28minutesspringframework.c06_dependencyinjectiontypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SBYourBusiness {
    SBDependency1 dependency1;
    SBDependency2 dependency2;

    @Autowired
    public void setDependency1(SBDependency1 dependency1) {
        this.dependency1 = dependency1;
    }

    @Autowired
    public void setDependency2(SBDependency2 dependency2) {
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using "+dependency1 + " and " +dependency2;
    }
}

@Component
class SBDependency1 {

}

@Component
class SBDependency2 {

}

@Configuration
@ComponentScan
public class SetterBasedDepInjection {
    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (SetterBasedDepInjection.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(SBYourBusiness.class));
        }
    }
}
