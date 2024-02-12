package com.in28minutesspringframework.c08_eagerandlazyinit;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some Initialization Logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do Something");
    }


}