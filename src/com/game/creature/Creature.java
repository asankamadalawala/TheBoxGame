package com.game.creature;

import com.game.main.Entity;
import com.game.main.Game;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Creature extends Entity{
    protected int speed = 5;
    protected int x, y, width, height;
    protected Game game;
    protected String name;
    protected int health;
    protected int damageSize;

    public Creature(int x, int y, int width, int height, Game game) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        health = 100;
        damageSize = 1;
    }
    
    public Rectangle getBonds(){
        return new Rectangle(x, y, width, height);
    }

    public void damage(int damageSize){
        if(health > 0){
            health -= damageSize;
        }
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}
