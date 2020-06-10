package com.game.creature;

import com.game.main.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemy extends Creature {

    private int moveX = 1;
    private int moveY = 1;
    private Random random;

    public Enemy(int width, int height, Game game) {
        super(0, 0, width, height, game);

        randomLocation();
    }

    private void randomLocation() {
        random = new Random();
        x = random.nextInt(game.WIDTH - width);
        y = random.nextInt(game.HEIGHT - height);

        if (random.nextInt(2) == 0) {
            moveX = -1;
        } else {
            moveX = 1;
        }

        if (random.nextInt(2) == 0) {
            moveY = -1;
        } else {
            moveY = 1;
        }
        
        speed = random.nextInt(5) + 1;
    }

    private void move() {
        if (x + width > game.WIDTH) {
            moveX = -1;
        }

        if (y + height > game.HEIGHT) {
            moveY = -1;
        }

        if (x < 0) {
            moveX = 1;
        }

        if (y < 0) {
            moveY = 1;
        }
        x += moveX * speed;
        y += moveY * speed;
    }

    @Override
    public void tick() {
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
        
//        g.drawOval(x, y, width, height);
    }

}
