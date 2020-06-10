package com.game.creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Handler {
    private ArrayList<Creature> creatures;

    public Handler() {
        creatures = new ArrayList<Creature>();
    }
    
    
    public void add(Creature creature){
        creatures.add(creature);
    }
    
    public void add(Creature[] creature){
        for (Creature cre : creature) {
            add(cre);
        }
    }
    
    public void tick(){
        for (Creature creature : creatures) {
            creature.tick();
        }
        
        checkCollisions();
    }
    
    public void render(Graphics g){
        for (Creature creature : creatures) {
            creature.render(g);
        }
    }
    
    public void checkCollisions(){
        Rectangle player = creatures.get(0).getBonds();
        
        for (Creature creature : creatures) {
            if(!creature.getName().equals("player")){
                Rectangle enemy = creature.getBonds();
                
                if(player.intersects(enemy)){
                    creatures.get(0).damage(creature.damageSize);
                }
            }
        }
    }
}
