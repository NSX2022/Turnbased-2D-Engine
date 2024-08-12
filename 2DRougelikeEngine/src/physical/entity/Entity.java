package physical.entity;

import game.world.Faction;
import game.world.Tile;
import system.DisplayChar;

import java.util.ArrayList;

public class Entity {

    //e.g poisoned, cursed
    public ArrayList<String> effects = new ArrayList<>();

    //e.g infernal, humanoid
    public ArrayList<String> tags = new ArrayList<>();

    public ArrayList<Injury> injuries = new ArrayList<>();
    public ArrayList<Disease> diseases = new ArrayList<>();

    public String name;

    //AI
    public boolean hasAI = false;
    public Faction faction;

    //animation
    public DisplayChar disChar = new DisplayChar(null,null);

    public int row;
    public int col;

    //Stats
    public int maxHP;
    public int hp;
    public int dodge;
    public int armor;

    //Average speed is 100, higher numbers are slower, 0 is time stop. All speed is relative to the player. Speed comes from items and limbs.
    public int speed;
    public int turnPoints;

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

    //TODO
    public void nextTurn() {
        //System.out.println(name + " took its turn");
        if(hasAI){

        }
    }
}