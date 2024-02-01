package com.springcourse.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private GamingConsole game;

    public GameRunner(@Qualifier("SupercontraGameQuaifier") GamingConsole game){
        this.game = game;
    }

    public void run() {
        System.out.println("Running the game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }

}
