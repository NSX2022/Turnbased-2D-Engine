package game.world;

import game.Description;
import game.GamePanel;
import physical.entity.Entity;
import physical.item.Item;
import system.DisplayChar;

import java.awt.*;
import java.util.ArrayList;

public class Tile {
    //stuff on the tile
    public ArrayList<Item> items;
    public GridEntity gridEntity = null;
    public Entity entity = null;

    public boolean collision = false;
    public String name;
    public int tileID;
    public DisplayChar disChar = new DisplayChar(null,null);
    public int frame = 0;

    public int gridX;
    public int gridY;

    public Description description;

    public ArrayList<String> tags;

    public Tile(boolean collision){
        this.collision = collision;
    }


    public static Tile newTile(int id){
        Tile toRet = null;
        Color tDisCol = null;
        char[] tDisChar = new char[99];

        switch (id){
            case -4:
                //nextGridUP
                toRet = new Tile(false);
                toRet.tileID = id;
                toRet.name = "Right";
                tDisCol = new Color(1,1,1);
                tDisChar[0] = '�';
                toRet.tags.add("nextGridRIGHT");
                break;
            case -3:
                //nextGridLEFT
                toRet = new Tile(false);
                toRet.tileID = id;
                toRet.name = "Left";
                tDisCol = new Color(1,1,1);
                tDisChar[0] = '�';
                toRet.tags.add("nextGridLEFT");
                break;
            case -2:
                //nextGridDOWN
                toRet = new Tile(false);
                toRet.tileID = id;
                toRet.name = "Down";
                tDisCol = new Color(1,1,1);
                tDisChar[0] = '�';
                toRet.tags.add("nextGridDOWN");
                break;
            case -1:
                //nextGridUP
                toRet = new Tile(false);
                toRet.tileID = id;
                toRet.name = "Up";
                tDisCol = new Color(1,1,1);
                tDisChar[0] = '�';
                toRet.tags.add("nextGridUP");
                break;
            case 0:
                //Grass
                toRet = new Tile(false);
                toRet.tileID = id;
                toRet.name = "Ground";
                tDisCol = new Color(80, 48, 11, 255);
                //tDisChar[0] = '█';
                tDisChar[0] = 'g';
                break;
            case 1:
                //Stone
                toRet = new Tile(false);
                toRet.tileID = id;
                toRet.name = "Stone";
                tDisCol = new Color(147, 147, 147, 255);
                tDisChar[0] = '█';
                break;
            case 2:
                break;
        }
        toRet.disChar = new DisplayChar(tDisCol,tDisChar);
        return toRet;
    }

    public void draw(Graphics g){
        //in order, from the farthest back to foreground
        //Tile char --> Item (highest in stack is drawn) --> GridEntity --> Entity

        g.setFont(GamePanel.gameFont);

        if(entity == null){
            if(items == null || items.isEmpty()){
                if(gridEntity == null){
                    if(this.disChar != null){
                        g.setColor(disChar.color);
                        g.drawString(String.valueOf(disChar.toDisplay[frame]), gridX * GamePanel.tileSize, gridY * GamePanel.tileSize);
                    }
                }else{

                }
            }else{
                g.setColor(items.getFirst().disChar.color);
                g.drawString(String.valueOf(items.getFirst().disChar.toDisplay[0]), gridX * GamePanel.tileSize, gridY * GamePanel.tileSize);
            }
        }else{
            g.setColor(entity.disChar.color);
            g.drawString(String.valueOf(entity.disChar.toDisplay[entity.frame]), gridX * GamePanel.tileSize, gridY * GamePanel.tileSize);
        }
    }

}