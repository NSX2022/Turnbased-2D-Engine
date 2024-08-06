package physical.entity;

import physical.entity.biology.*;
import system.DisplayChar;

import java.util.ArrayList;

public class Entity {
    public ArrayList<String> effects;
    public ArrayList<String> tags;
    public Body body;
    public String name;
    //from -5 to 5. 0 is neutral
    public int moodLvl = 0;

    //animation
    public DisplayChar disChar;

    public int row;
    public int col;

    //Average speed is 1000, higher numbers are slower, 0 is time stop. All speed is relative to the player. Speed comes from items and limbs.
    public int speed;

    public Inventory inventory;

    public void useItem(int itemID) {
        switch (itemID){
            case 0:
                break;
        }
    }

    public void nextTurn() {

    }
}