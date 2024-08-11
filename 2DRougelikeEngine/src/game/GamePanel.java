package game;

import game.world.*;
import game.*;
import physical.entity.Entity;
import physical.entity.Inventory;
import player.PlayerController;
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
    public static final int tileSize = 16;
    public static Font gameFont = new Font("URW Gothic", Font.PLAIN, tileSize);
    public World world;
    public final static int CHAR_OFFSET_X = tileSize*10;
    public final static int CHAR_OFFSET_Y = tileSize*2;

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
    //low priority or cut later
    public int maxFactions = 1024;
    public Faction[] factions = new Faction[maxFactions];

    //Gameplay
    public boolean playerTurn = true;
    public PlayerController playerController = new PlayerController();


    public GamePanel(){
        this.setVisible(false);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        gameState = 0;
        this.addKeyListener(keyH);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        tempScreen = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D)tempScreen.getGraphics();

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
        //KEEP UPDATE LOOP CLEAN

    }

    public void newGame(){
        rand = new Random();
        seed = rand.nextLong();
        rand.setSeed(seed);
        world = new World(this);
        world.genWorld();

        Entity player = new Entity();
        player.col = Grid.cols/2;
        player.row = Grid.rows/2;
        player.name = "newPlayer";
        player.disChar.toDisplay = new char[]{'@'};
        player.disChar.color = new Color(255, 0, 213);
        player.hp = 10;
        player.armor = 0;
        player.dodge = 2;
        player.hasAI = false;
        player.inventory = new Inventory();
        player.speed = 100;
        player.maxHP = 10;

        world.grids[2][2].tiles[Grid.rows/2][Grid.cols/2].entity = player;
        playerController.currentGrid = world.grids[2][2];
        playerController.playerBody = player;
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
        playerController.currentGrid.draw(g2);

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
        if (playerTurn) {

        } else {

        }
    }
}
