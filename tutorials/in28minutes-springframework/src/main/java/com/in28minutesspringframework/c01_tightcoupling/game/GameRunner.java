package com.in28minutesspringframework.c1_tightcoupling.game;

public class GameRunner {
    SuperContraGame game;
    public  GameRunner(SuperContraGame game){
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
