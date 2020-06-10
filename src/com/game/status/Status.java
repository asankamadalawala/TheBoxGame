package com.game.status;

import com.game.main.Game;
import java.awt.Graphics;

public abstract class Status {
    protected Game game;

    public Status(Game game) {
        this.game = game;
    }
    
    
    
    public abstract void render(Graphics g);
    
    public abstract void tick();
    
    public abstract void oneSecondTick();
    
    public abstract void halfSecondTick();
}
