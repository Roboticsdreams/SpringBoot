package com.in28minutesspringframework.c05_springcreateobjects.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {
    public void left(){
        System.out.println("go back");
    }
    public void right(){
        System.out.println("shoot a bullet");
    }
    public void up(){
        System.out.println("up");
    }
    public void down(){
        System.out.println("sit-down");
    }
}
