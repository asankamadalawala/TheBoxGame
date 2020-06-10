package com.game.display;

import com.game.main.Entity;
import java.awt.Color;
import java.awt.Graphics;

public class Stats extends Entity{

    private int health = 0;
    private int time=0;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(10, 10, 104, 10);
        g.setColor(Color.red);
        g.fillRect(12, 12, health, 6);
        
        g.setColor(Color.green);
        g.fillRect(10, 30, 104, 10);
        g.setColor(Color.blue);
        g.fillRect(12, 32, time, 6);
        
//        g.drawString("Time left: " + time + "Sce", 10, 50);
    }

}
