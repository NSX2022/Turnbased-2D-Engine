package physical.entity;

import system.DisplayChar;

import java.util.ArrayList;

public class Entity {

    public ArrayList<String> effects;
    public ArrayList<String> tags;

    public ArrayList<Injury> injuries;
    public ArrayList<Disease> diseases;

    public String name;

    //AI
    public boolean hasAI = false;

    //animation
    public DisplayChar disChar = new DisplayChar(null,null);

    public int row;
    public int col;

    //Stats
    public int maxHP;
    public int hp;
    public int dodge;
    public int armor;

    //Average speed is 1000, higher numbers are slower, 0 is time stop. All speed is relative to the player. Speed comes from items and limbs.
    public int speed;

    public Inventory inventory;
    public int frame = 0;

    public void useItem(int itemID) {
        switch (itemID){
            case 0:
                break;
            case 1:
                break;
        }
    }

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

    public void nextTurn() {

    }
}