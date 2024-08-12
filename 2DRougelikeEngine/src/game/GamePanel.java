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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

import static game.world.Grid.cols;
import static game.world.Grid.rows;

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

    //Factions stored in World

    //Gameplay
    public boolean playerTurn = true;
    public PlayerController playerController = new PlayerController();
    public static boolean LOADING = false;

    //governs speed
    public int pointsPerTurn = 1000;


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
            if(seconds % 2 == 0){
                //TODO: grid particle tick, and nextFrame for other objects
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

        Entity player = new Entity();
        player.col = cols/2;
        player.row = rows/2;
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

        world = new World(this);
        world.genWorld();

        world.grids[2][2][0].tiles[rows/2][cols/2].entity = player;
        playerController.currentGrid = world.grids[2][2][0];
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
        if(/*gameState == PLAY_STATE*/true) {
            playerController.currentGrid.draw(g2);
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

    //possibly complete
    public void nextTurn() {
        //local variable to track turn points for each entity
        Map<Entity, Integer> entityPoints = new HashMap<>();

        // Initialize the map with current turnPoints
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                Tile tile = playerController.currentGrid.tiles[i][j];
                if (tile.entity != null){
                    Entity entity = tile.entity;
                    int currentPoints = entity.turnPoints + entity.speed;
                    entityPoints.put(entity, currentPoints);
                }
            }
        }

        // Step 2: Process turns based on accumulated points
        List<Map.Entry<Entity, Integer>> sortedEntities = new ArrayList<>(entityPoints.entrySet());
        sortedEntities.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())); //Higher points first

        for(Map.Entry<Entity, Integer> entry : sortedEntities){
            Entity entity = entry.getKey();
            int points = entry.getValue();
            if (points >= pointsPerTurn) {
                if(entity == playerController.playerBody){
                    //player's turn
                    playerTurn = true;
                    entity.turnPoints = points - pointsPerTurn; //reset but keep remainder
                    //System.out.println("player turn processed");
                } else {
                    //another entities turn
                    playerTurn = false;
                    entity.nextTurn();
                    //Update the entity's turn points
                    entity.turnPoints = points - pointsPerTurn; //reset but keep remainder
                    //System.out.println("repeat method");
                    nextTurn();
                }
            }else{
                entity.turnPoints = points;
                if(entity == playerController.playerBody){
                    nextTurn();
                }
            }
            //System.out.println(entity.name);
        }
        //System.out.println("finish method");
    }
}
