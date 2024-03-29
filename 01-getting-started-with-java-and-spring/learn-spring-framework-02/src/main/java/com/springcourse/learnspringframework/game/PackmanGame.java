package com.springcourse.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PackmanGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("Packman goes up");

    }

    @Override
    public void down() {
        System.out.println("Packman goes down");

    }

    @Override
    public void left() {
        System.out.println("Packman goes left");

    }

    @Override
    public void right() {
        System.out.println("Packman goes right");
    }

}
