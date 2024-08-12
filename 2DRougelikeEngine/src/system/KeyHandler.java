package system;

import game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {

    GamePanel gp;

    public boolean checkDrawTime = false;
    public int storedCode = -9999;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        //TODO: Store users gameplay action and then the user goes to the next turn and confirms action by pressing enter

        if(code == KeyEvent.VK_ESCAPE){
            //TODO: Save and exit
            System.exit(0);
        }else if(gp.gameState == gp.PLAY_STATE){
            if(code == KeyEvent.VK_ENTER && storedCode != -9999) {
                gp.nextTurn();
            }else{
                if(storedCode != -9999) {
                    storedCode = code;
                    gp.playerController.processInput(code);
                }else{
                    System.out.println("Player did not choose input");
                }
            }
            //System.out.println("pressed ENTER");
        }
    }
}
