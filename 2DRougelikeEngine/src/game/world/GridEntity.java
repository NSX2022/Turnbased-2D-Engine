package game.world;

import game.Description;
import system.DisplayChar;

import java.util.ArrayList;

public class GridEntity {

    //Walls, altars, statues, etc

    public double health = 999999999;
    public ArrayList<String> features;
    public DisplayChar disChar = new DisplayChar(null,null);
    public int row;
    public int col;
    public boolean collision = false;
    public boolean isPlant = false;
    public Description description;
    public int frame = 0;
    public int armor = 9999;

    public int largest()
    {
        int max = 0;

        for (int i = 0; i < disChar.toDisplay.length; i++){
            if (disChar.toDisplay[i] != 0) {
                max = i;
            }
        }

        return max;
    }

    public void nextFrame() {
        if(frame < largest()) {
            frame++;
        }else{
            frame = 0;
        }
    }
}
