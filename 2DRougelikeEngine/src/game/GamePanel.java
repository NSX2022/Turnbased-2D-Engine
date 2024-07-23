package game;

import game.world.World;
import system.sound.SoundHandler;

import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    public Random rand;
    public long seed;
    public World world;

    public SoundHandler sound;

    //Grid
    final int tileSize = 16;

    //GameState
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int winState = 3;
    public int gameType = -1;


    public GamePanel(){
        rand = new Random();
        seed = rand.nextLong();
        rand = new Random(seed);
        world = new World(this);
    }

    @Override
    public void run() {

    }

    public void setupGame(){

    }
    public void startGameThread(){

    }

    //TODO
    public void nextTurn() {

    }
}
