package com.in28minutesspringframework.c04_loosecoupling_springlevel2.game;

import com.in28minutesspringframework.c04_loosecoupling_springlevel2.game.GamingConsole;

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