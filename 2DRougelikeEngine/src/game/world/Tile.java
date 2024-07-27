package game.world;

import physical.entity.Entity;
import physical.item.Item;
import system.DisplayChar;

import java.awt.*;
import java.util.ArrayList;

public class Tile {
    public ArrayList<Item> items;
    public GridEntity gridEntity = null;
    public boolean collision = false;
    public String name;
    public int tileID;
    public DisplayChar disChar;

    public int gridX;
    public int gridY;

    public Tile(boolean collision){
        this.collision = collision;
    }


    public static Tile newTile(int id){
        Tile toRet = null;
        Color tDisCol = null;
        char tDisChar = 0;
        switch (id){
            case 0:
                //Grass
                toRet = new Tile(false);
                toRet.tileID = id;
                toRet.name = "Ground";
                tDisCol = new Color(80, 48, 11, 255);
                tDisChar = '█';
                break;
            case 1:
                //Stone
                toRet = new Tile(false);
                toRet.tileID = id;
                toRet.name = "Stone";
                tDisCol = new Color(147, 147, 147, 255);
                tDisChar = '█';
                break;
            case 2:
                break;
        }
        toRet.disChar = new DisplayChar(tDisCol,tDisChar);
        return toRet;
    }

}