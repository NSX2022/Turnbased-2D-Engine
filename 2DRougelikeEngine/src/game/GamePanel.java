package game;

import game.world.*;
import game.*;
import system.*;
import system.sound.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    //random gen
    public Random rand;
    public long seed;

    //System
    public final int SCREEN_WIDTH = 1600;
    public final int SCREEN_HEIGHT = 960;
    public KeyHandler keyH = new KeyHandler(this);
    public SoundHandler music = new SoundHandler();
    public SoundHandler sfx = new SoundHandler();
    //fps and rendering
    private final int FPS = 60;
    public int latestFPS;
    Graphics2D g2;
    Thread gameThread;
    BufferedImage tempScreen;

    //Grid
    public final int tileSize = 16;
    public World world;

    //GameState
    public int gameState;
    public final int TITLE_STATE = 0;
    public final int PLAY_STATE = 1;
    public final int MENU_STATE = 2;
    public final int WIN_STATE = 3;
    public final int DEATH_STATE = 4;

    //GameType
    public int gameType = -1;
    public final int WORLD_TYPE = 0;
    public final int SINGLE_GRID_TYPE = 1;

    //Factions
    public int maxFactions = 1024;
    public Faction[] factions = new Faction[maxFactions];

    public GamePanel(){
        this.setVisible(false);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        gameState = 0;
        this.addKeyListener(keyH);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        tempScreen = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        this.setVisible(true);

        gameState = TITLE_STATE;
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        int seconds = 0;
        int totalSeconds = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) { //delta >= 1
                update();
                drawToTempScreen();
                drawToScreen();
                delta = 0;
                drawCount++;
            }
            if (timer >= 1000000000) {
                //System.out.println("FPS: " + drawCount);
                latestFPS = drawCount;
                drawCount = 0;
                timer = 0;
                if (FPS >= 60) {
                    if (gameState == PLAY_STATE) {
                        seconds++;
                    }
                    totalSeconds++;
                }
            }
        }
    }

    private void update() {

    }

    public void newGame(){
        rand = new Random();
        seed = rand.nextLong();
        rand.setSeed(seed);
        world = new World(this);
        world.genWorld();
        
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void drawToTempScreen(){
        //debug
        long drawStart = 0;
        if(keyH.checkDrawTime){
            drawStart = System.nanoTime();
        }
    }

    public void drawToScreen() {
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
        g.dispose();
    }

    //Music
    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic() {

        music.stop();
    }
    public void playSE(int i) {

        sfx.setFile(i);
        sfx.play();
    }
    public void stopSE() {

        sfx.stop();
    }

    //TODO
    public void nextTurn() {

    }
}
