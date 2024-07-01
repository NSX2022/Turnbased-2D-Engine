package game;

import game.world.World;

import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    public Random rand;
    public long seed;
    public World world;

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
