package physical.entity;

import physical.entity.biology.*;
import system.DisplayChar;

import java.util.ArrayList;

public class Entity {
    public ArrayList<String> effects;
    public Body body;
    public String name;
    //from -5 to 5. 0 is neutral
    public int moodLvl = 0;
    public DisplayChar disChar;

    public int row;
    public int col;

    public Inventory inventory;


}