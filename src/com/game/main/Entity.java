package com.game.main;

import java.awt.Graphics;

public abstract class Entity {
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}
