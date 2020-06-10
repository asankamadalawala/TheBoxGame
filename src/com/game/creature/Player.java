package com.game.creature;

import com.game.main.Game;
import java.awt.Color;
import java.awt.Graphics;

public class Player extends Creature {

    public Player(int x, int y, int width, int height, Game game) {
        super(x, y, width, height, game);
    }

    public void move() {
        if (game.getKeyManager().left) {
            x -= speed;
        }

        if (game.getKeyManager().right) {
            x += speed;
        }

        if (game.getKeyManager().up) {
            y -= speed;
        }

        if (game.getKeyManager().down) {
            y += speed;
        }

        if (x < 0) {
            x = 0;
        }

        if (x + width > game.WIDTH) {
            x = game.WIDTH - width;
        }

        if (y < 0) {
            y = 0;
        }

        if (y + height > game.HEIGHT) {
            y = game.HEIGHT - height;
        }
    }

    @Override
    public void tick() {

        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);
    }

}
