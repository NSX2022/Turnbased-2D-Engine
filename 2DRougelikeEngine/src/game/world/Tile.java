package game.world;

import game.Description;
import game.GamePanel;
import physical.entity.Entity;
import physical.item.Item;
import system.DisplayChar;
import system.vfx.GridParticle;

import java.awt.*;
import java.util.ArrayList;

public class Tile {
    //stuff on the tile
    public ArrayList<Item> items;
    public GridEntity gridEntity = null;
    public Entity entity = null;
    public GridParticle gridParticle = null;

    //when to show particle tick
    public boolean particleTick;

    public boolean collision = false;
    public String name;
    public int tileID;
    public DisplayChar disChar = new DisplayChar(null,null);
    public int frame = 0;

    public int gridX;
    public int gridY;

    public Description description;

    GamePanel gamePanel;

    public ArrayList<String> tags;

    public Tile(boolean collision, GamePanel gp){
        this.collision = collision;
        gamePanel = gp;
    }


    public static Tile newTile(int id, GamePanel gp){
        Tile toRet = null;
        Color tDisCol = null;
        char[] tDisChar = new char[99];

        switch (id){
            case -4:
                //nextGridUP
                toRet = new Tile(false, gp);
                toRet.tileID = id;
                toRet.name = "Right";
                tDisCol = new Color(255, 255, 255);
                tDisChar[0] = '�';
                toRet.tags.add("nextRIGHT");
                break;
            case -3:
                //nextGridLEFT
                toRet = new Tile(false, gp);
                toRet.tileID = id;
                toRet.name = "Left";
                tDisCol = new Color(255, 255, 255);
                tDisChar[0] = '�';
                toRet.tags.add("nextLEFT");
                break;
            case -2:
                //nextGridDOWN
                toRet = new Tile(false, gp);
                toRet.tileID = id;
                toRet.name = "Down";
                tDisCol = new Color(255, 255, 255);
                tDisChar[0] = '�';
                toRet.tags.add("nextDOWN");
                break;
            case -1:
                //nextGridUP
                toRet = new Tile(false, gp);
                toRet.tileID = id;
                toRet.name = "Up";
                tDisCol = new Color(255, 255, 255);
                tDisChar[0] = '�';
                toRet.tags.add("nextUP");
                break;
            case 0:
                //Ground
                toRet = new Tile(false, gp);
                toRet.tileID = id;
                toRet.name = "Ground";
                tDisCol = new Color(80, 48, 11, 255);
                tDisChar[0] = '█';
                //tDisChar[0] = 'g';
                break;
            case 1:
                //Stone
                toRet = new Tile(false, gp);
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

    public boolean hasSolid(){
        if(collision){
            return true;
        }
        if(gridEntity != null && !gridEntity.collision){
            return true;
        }
        if(this.entity != null && this.entity.faction.hostile.contains(gamePanel.playerController.playerBody.faction)){
            return true;
        }
        return false;
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
                        g.drawString(String.valueOf(disChar.toDisplay[frame]), gridX * GamePanel.tileSize + GamePanel.CHAR_OFFSET_X, gridY * GamePanel.tileSize + GamePanel.CHAR_OFFSET_Y);
                    }
                }else{
                    g.setColor(gridEntity.disChar.color);
                    g.drawString(String.valueOf(gridEntity.disChar.toDisplay[gridEntity.frame]), gridX * GamePanel.tileSize + GamePanel.CHAR_OFFSET_X, gridY * GamePanel.tileSize + GamePanel.CHAR_OFFSET_Y);
                }
            }else{
                g.setColor(items.getFirst().disChar.color);
                g.drawString(String.valueOf(items.getFirst().disChar.toDisplay[0]), gridX * GamePanel.tileSize + GamePanel.CHAR_OFFSET_X, gridY * GamePanel.tileSize + GamePanel.CHAR_OFFSET_Y);
            }
        }else{
            g.setColor(entity.disChar.color);
            g.drawString(String.valueOf(entity.disChar.toDisplay[entity.frame]), gridX * GamePanel.tileSize + GamePanel.CHAR_OFFSET_X, gridY * GamePanel.tileSize + GamePanel.CHAR_OFFSET_Y);
        }

        if(gridParticle != null && particleTick){
            g.setColor(gridParticle.disChar.color);
            g.drawString(String.valueOf(gridParticle.disChar.toDisplay[gridParticle.frame]), gridX * GamePanel.tileSize + GamePanel.CHAR_OFFSET_X, gridY * GamePanel.tileSize + GamePanel.CHAR_OFFSET_Y);
        }
    }

}