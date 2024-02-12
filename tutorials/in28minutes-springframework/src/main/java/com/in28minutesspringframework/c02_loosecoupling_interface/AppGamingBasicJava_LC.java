package com.in28minutesspringframework.c2_loosecoupling_interface;

import com.in28minutesspringframework.c2_loosecoupling_interface.game.GameRunner;
import com.in28minutesspringframework.c2_loosecoupling_interface.game.PacManGame;

public class AppGamingBasicJava_LC {
    public static void main(String[] args) {
        // var game= new MarioGame();
        //var game = new SuperContraGame();
        //1.Object creation
        var game = new PacManGame();
        //2. Object create + wiring of dependency
        //Game is the dependency for GameRunner class
        var gamerRunner = new GameRunner(game);
        gamerRunner.run();
    }
}
