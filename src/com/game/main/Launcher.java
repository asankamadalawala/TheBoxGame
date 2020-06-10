package com.game.main;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("The Game!", 640, 360);
        game.start();
    }
}
