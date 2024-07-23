package physical.item;

import system.DisplayChar;

public class Item {
    public int temp;
    public int meltingPoint;
    public int freezingPoint;
    public double worth;
    public boolean canStack;
    public double weight;

    public String name;
    public DisplayChar disChar;

    //for when on a grid
    //set to -1 if in inventory
    public int row = -1;
    public int col = -1;
}
