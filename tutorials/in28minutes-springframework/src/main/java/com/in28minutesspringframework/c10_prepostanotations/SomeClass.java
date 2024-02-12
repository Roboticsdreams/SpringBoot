package com.in28minutesspringframework.c10_prepostanotations;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SomeClass {
    private SomeDependency someDependency;

    public  SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependencies are ready");
    }

    @PreDestroy
    public void cleanup() {
        someDependency.getPreDestroy();
    }
    @PostConstruct
    public void postinitialize() {
        someDependency.getPostReady();
    }
}
