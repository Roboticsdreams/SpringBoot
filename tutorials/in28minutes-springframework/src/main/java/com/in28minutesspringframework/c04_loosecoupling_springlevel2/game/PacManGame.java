package com.in28minutesspringframework.c04_loosecoupling_springlevel2.game;

public class PacManGame  implements GamingConsole {
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