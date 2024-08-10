package physical.item;

import game.Description;
import system.DisplayChar;

import java.util.ArrayList;

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
    public int gridX = -1;
    public int gridY = -1;

    //Item library
    public static Item newItem(int itemId){
        Item toRet = null;

        switch (itemId){
            case 0:

                break;
        }

        return toRet;
    }
}
