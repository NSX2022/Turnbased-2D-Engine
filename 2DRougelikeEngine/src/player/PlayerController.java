package player;

import game.GamePanel;
import game.world.Grid;
import game.world.Tile;
import physical.entity.Entity;

import java.awt.event.KeyEvent;

public class PlayerController {
    public Entity playerBody;
    public Grid currentGrid;

    GamePanel gp;

    public boolean canDo(int actionCode){
        //TODO
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

                break;
            case KeyEvent.VK_A:

                break;
            case KeyEvent.VK_S:

                break;
            case KeyEvent.VK_D:
                Tile moveTo = currentGrid.tiles[playerBody.row + 1][playerBody.col];
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
