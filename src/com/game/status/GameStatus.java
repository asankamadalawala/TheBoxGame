package com.game.status;

import com.game.creature.Creature;
import com.game.creature.Enemy;
import com.game.creature.EnemyBoss;
import com.game.creature.Handler;
import com.game.creature.Player;
import com.game.display.Stats;
import com.game.main.Game;
import java.awt.Graphics;

public class GameStatus extends Status{
    
    private Stats stats;
    private Creature player;
    private Creature[] enemies;
    private Handler handler;
    
    private int enemyCount = 5;
    private double gameTime;
    private int time;

    public GameStatus(Game game, int enemyCount) {
        super(game);
        this.enemyCount = enemyCount;
        gameTime = 60;
        time = 100;
        init();
    }
    
    public void init(){
        stats = new Stats();
        
        handler = new Handler();
        player = new Player(game.WIDTH / 5,game.HEIGHT / 2,20,20,game);
        player.setName("player");
        enemies = new Enemy[enemyCount];
        for (int i = 0; i < enemies.length ; i++) {
            enemies[i] = new Enemy(20,20,game);
            enemies[i].setName("enemy");
        }
        
        enemies[enemies.length -1] = new EnemyBoss(20,20, game, player);
        enemies[enemies.length -1].setName("enemy");
        
        
        handler.add(player);
        handler.add(enemies);
    }

    @Override
    public void render(Graphics g) {
        handler.render(g);
        stats.render(g);
    }

    @Override
    public void tick() {
        handler.tick();
        stats.setHealth(player.getHealth());
        stats.setTime(time);
        if (time <= 0 || player.getHealth() <= 0) {
            game.changeLevel();
        }
    }

    @Override
    public void oneSecondTick() {
        gameTime -= 1;
        time = (int) Math.round(gameTime / 60 * 100);
    }

    @Override
    public void halfSecondTick() {
        
    }
    
}
