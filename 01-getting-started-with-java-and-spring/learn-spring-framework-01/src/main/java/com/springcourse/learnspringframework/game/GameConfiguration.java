package com.springcourse.learnspringframework.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public GamingConsole game(){
        PackmanGame game = new PackmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        GameRunner gameRunner = new GameRunner(game);
        return gameRunner;
    }



}
