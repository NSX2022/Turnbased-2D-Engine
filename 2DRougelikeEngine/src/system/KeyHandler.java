package system;

import game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {

    GamePanel gp;

    public boolean checkDrawTime = false;

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
        if(code == KeyEvent.VK_ESCAPE){
            //TODO: Save and exit
            System.exit(0);
        }else if(code == KeyEvent.VK_ENTER){
            //Store users gameplay action and then the user goes to the next turn and confirms action by pressing enter
            gp.nextTurn();
            System.out.println("pressed ENTER");
        }
        //TODO: Do player action
        //use gp.nextTurn(); if the action is a gameplay action
    }
}
