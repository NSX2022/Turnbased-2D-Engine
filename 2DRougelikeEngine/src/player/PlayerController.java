package player;

import game.GamePanel;
import game.world.Grid;
import game.world.Tile;
import physical.entity.Entity;

import java.awt.event.KeyEvent;

public class PlayerController {
    public Entity playerBody;
    public Grid currentGrid;

    public GamePanel gp;

    public boolean canDo(int actionCode){
        //TODO
        Tile moveTo = new Tile(false,null);
        switch (actionCode){
            //0-9 keys
            case KeyEvent.VK_0:
                //System.out.println("pressed 0");
                break;
            case KeyEvent.VK_1:
                break;
            case KeyEvent.VK_2:
                break;
            case KeyEvent.VK_3:
                break;
            case KeyEvent.VK_4:
                break;
            case KeyEvent.VK_5:
                break;
            case KeyEvent.VK_6:
                break;
            case KeyEvent.VK_7:
                break;
            case KeyEvent.VK_8:
                break;
            case KeyEvent.VK_9:
                break;
            case KeyEvent.VK_W:
                moveTo = currentGrid.tiles[playerBody.row][playerBody.col-1];
                if(moveTo == null || moveTo.hasSolid()){
                    return false;
                }
                break;
            case KeyEvent.VK_A:
                moveTo = currentGrid.tiles[playerBody.row-1][playerBody.col];
                if(moveTo == null || moveTo.hasSolid()){
                    return false;
                }
                break;
            case KeyEvent.VK_S:
                moveTo = currentGrid.tiles[playerBody.row][playerBody.col+1];
                if(moveTo == null || moveTo.hasSolid()){
                    return false;
                }
                break;
            case KeyEvent.VK_D:
                moveTo = currentGrid.tiles[playerBody.row + 1][playerBody.col];
                if(moveTo == null || moveTo.hasSolid()){
                    return false;
                }
                break;
        }
        return true;
    }

    public void processInput(int keyCode){
        if(canDo(keyCode)){
            //TODO: do things here
        }

        gp.keyH.storedCode = -9999;
    }
}
