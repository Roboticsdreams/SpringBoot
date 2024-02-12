package com.in28minutesspringframework.c01_tightcoupling;

import com.in28minutesspringframework.c01_tightcoupling.game.GameRunner;
import com.in28minutesspringframework.c01_tightcoupling.game.SuperContraGame;

public class AppGamingBasicJava_TC {
    public static void main(String[] args) {
        var game = new SuperContraGame();
        var gamerRunner = new GameRunner(game);
        gamerRunner.run();
    }
}
