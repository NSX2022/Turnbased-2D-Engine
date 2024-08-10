package physical.item;

import game.Description;
import system.DisplayChar;

public class Item {
    public int temp;
    public int meltingPoint;
    public int freezingPoint;
    public double worth;
    public boolean stackable;
    public double weight;
    public int itemId;

    //visual
    public String name;
    public DisplayChar disChar = new DisplayChar(null,null);
    public Description description;


    //for when on a grid
    //set to -1 if in an inventory
    public int row = -1;
    public int col = -1;
}
