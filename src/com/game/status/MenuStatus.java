package com.game.status;

import com.game.main.Game;
import java.awt.Color;
import java.awt.Graphics;

public class MenuStatus extends Status{
    private int time = 5;

    public MenuStatus(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawString("The Game", 100, game.HEIGHT /2);
        g.drawString(time + " sec", 100, 100);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void oneSecondTick() {
        if(time < 1){
            game.changeLevel();
        }
        time--;
    }

    @Override
    public void halfSecondTick() {
        
    }
    
}
