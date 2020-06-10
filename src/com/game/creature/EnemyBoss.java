package com.game.creature;

import com.game.main.Game;
import java.awt.Color;
import java.awt.Graphics;

public class EnemyBoss extends Enemy{
    
    private Creature player;
    private int offSet = 10;

    public EnemyBoss(int width, int height, Game game, Creature player) {
        super(width, height, game);
        this.player = player;
        speed=1;
        x=(game.WIDTH / 5) * 4;
        y=game.HEIGHT / 2;
    }
    
    public void move(){
        if(player.getX() + offSet < x + offSet){
            x-=speed;
        }else{
            x+=speed;
        }
        
        if(player.getY() + offSet < y + offSet){
            y-=speed;
        }else{
            y+=speed;
        }
    }
    
    @Override
    public void tick(){
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
    
}
