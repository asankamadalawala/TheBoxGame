package com.game.main;

import com.game.creature.Creature;
import com.game.creature.Handler;
import com.game.display.Display;
import com.game.display.Stats;
import com.game.input.KeyManager;
import com.game.status.GameStatus;
import com.game.status.MenuStatus;
import com.game.status.Status;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    public final int WIDTH, HEIGHT;

    private Display display;
    private Stats stats;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private Status curStatus;
    private int curLevel = -1;
    private GameStatus[] games;
    private MenuStatus mainMenu;
    private MenuStatus levelMenu;

    private KeyManager keyManager;

    public Game(String title, int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, WIDTH, HEIGHT);
        display.getCanvas().addKeyListener(keyManager);

        games = new GameStatus[5];
        games[0] = new GameStatus(this, 5);
        games[1] = new GameStatus(this, 8);
        games[2] = new GameStatus(this, 12);
        games[3] = new GameStatus(this, 15);
        games[4] = new GameStatus(this, 20);
        
        mainMenu = new MenuStatus(this);
        levelMenu = new MenuStatus(this);

//        curStatus = games[curLevel];
        curStatus = mainMenu;
    }
    
    public void changeLevel(){
        curLevel++;
        curStatus = games[curLevel];
        
    }

    private void tick() {
        keyManager.tick();
        curStatus.tick();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, WIDTH, HEIGHT);
        //Draw Here!

        curStatus.render(g);

        //End Drawing!
        bs.show();
        g.dispose();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    @Override
    public void run() {

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
//                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
                curStatus.oneSecondTick();
            }
        }

        stop();

    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
