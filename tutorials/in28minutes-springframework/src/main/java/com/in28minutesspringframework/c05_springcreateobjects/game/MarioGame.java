package com.in28minutesspringframework.c05_springcreateobjects.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {

    public void left(){
        System.out.println("go back");
    }
    public void right(){
        System.out.println("accelerate");
    }
    public void up(){
        System.out.println("jump");
    }
    public void down(){
        System.out.println("go to hole");
    }
}