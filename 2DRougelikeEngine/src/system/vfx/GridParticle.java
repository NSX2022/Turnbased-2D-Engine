package system.vfx;

import system.DisplayChar;

public class GridParticle {
    public DisplayChar disChar;
    public int frame = 0;

    public int gridX;
    public int gridY;
    public int turnsLeft = 0;

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
}
