package com.in28minutesspringframework.c05_springcreateobjects.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacManGameQualifier")
public class PacManGame implements GamingConsole {
    public void left(){
        System.out.println("left");
    }
    public void right(){
        System.out.println("right");
    }
    public void up(){
        System.out.println("up");
    }
    public void down(){
        System.out.println("down");
    }
}