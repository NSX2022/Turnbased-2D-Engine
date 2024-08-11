package system.vfx;

import system.DisplayChar;

import java.awt.image.BufferedImage;

public class Particle {
    public double fadeTime;
    public int horzAxisOffset;
    public int vertAxisOffset;
    public DisplayChar disChar;
    public int size;
    public int gravity;
    public int frame = 0;

    public int screenX;
    public int screenY;
    public int xVel;
    public int yVel;

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

    public void nextTick(){

    }
}
