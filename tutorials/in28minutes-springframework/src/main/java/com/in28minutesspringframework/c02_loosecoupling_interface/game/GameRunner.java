package com.in28minutesspringframework.c02_loosecoupling_interface.game;

public class GameRunner {
    GamingConsole game;
    public  GameRunner(GamingConsole game){
        this.game = game;
    }

    public void run(){
        System.out.println("Running game:"+game);
        game.left();
        game.right();
        game.up();
        game.down();
    }
}
