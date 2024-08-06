package physical.item;

import system.DisplayChar;

public class Item {
    public int temp;
    public int meltingPoint;
    public int freezingPoint;
    public double worth;
    public boolean stackable;
    public double weight;
    public int itemId;

    public String name;
    public DisplayChar disChar;

    //for when on a grid
    //set to -1 if in an inventory
    public int row = -1;
    public int col = -1;
}
