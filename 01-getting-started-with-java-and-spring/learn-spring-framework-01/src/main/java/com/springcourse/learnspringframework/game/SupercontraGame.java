package com.springcourse.learnspringframework.game;

public class SupercontraGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("Jump");

    }

    @Override
    public void down() {
        System.out.println("Sit down");

    }

    @Override
    public void left() {
        System.out.println("go back");

    }

    @Override
    public void right() {
        System.out.println("Shoot a bullet");

    }


}
