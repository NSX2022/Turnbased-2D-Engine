package game.world;

import game.Description;
import system.DisplayChar;

import java.util.ArrayList;

public class GridEntity {

    //Walls, altars, statues, etc

    public double health = 999999999;
    public ArrayList<String> features;
    public DisplayChar disChar;
    public int row;
    public int col;
    public boolean collision = false;
    public Description description;
}
