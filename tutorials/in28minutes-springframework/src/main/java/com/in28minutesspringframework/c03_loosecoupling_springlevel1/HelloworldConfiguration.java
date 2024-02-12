package com.in28minutesspringframework.c3_loosecoupling_springlevel1;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Address (String street, String city) {};
record Person (String name, int age, Address address) {};

@Configuration
public class HelloworldConfiguration {

    @Bean
    public String name() {
        return "rathinam";
    }

    @Bean
    public int age(){
        return 15;
    }

    @Bean
    @Primary
    public Address address() {
        return new Address("street1", "london");
    }

    @Bean(name="newaddress")
    @Qualifier("addressqualifier")
    public Address address1() {
        return new Address("street2", "usa");
    }

    @Bean
    public Person person() {
        return new Person("Ravi",20, new Address("ram street","chennai"));
    }

    @Bean
    public Person person2methodcall() {
        return new Person(name(),age(),address());
    }

    @Bean
    public Person person3parameters(String name, int age, Address newaddress) {
        return new Person(name,age,newaddress);
    }

    @Bean
    public Person person4qualifier(String name, int age, @Qualifier("addressqualifier") Address newaddress) {
        return new Person(name,age,newaddress);
    }

}

