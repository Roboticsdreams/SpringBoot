package com.in28minutesspringframework.c06_dependencyinjectiontypes;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class CBYourBusiness {

    CBDependency1 dependency1;

    CBDependency2 dependency2;

    //@Autowired
    public CBYourBusiness(CBDependency1 dependency1, CBDependency2 dependency2) {
        super();
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using "+dependency1 + " and " +dependency2;
    }
}

@Component
class CBDependency1 {

}

@Component
class CBDependency2 {

}

@Configuration
@ComponentScan
public class ConstructorBasedDepInjection {
    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (ConstructorBasedDepInjection.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(CBYourBusiness.class));
        }
    }
}
