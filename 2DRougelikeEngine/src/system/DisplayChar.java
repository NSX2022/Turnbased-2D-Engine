package system;

import java.awt.*;

public class DisplayChar {
    public char[] toDisplay = new char[99];
    public Color color;
    public int frame = 0;

    public DisplayChar(Color color, char[] c){
        this.color = color;
        toDisplay = c;
    }

    public int largest()
    {
        int max = 0;

        for (int i = 0; i < toDisplay.length; i++){
            if (toDisplay[i] != 0) {
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

    public Color getGrayscale(){
        int val;

        //the average of all colors, producing a gray color
        val = color.getBlue() + color.getGreen() + color.getRed();
        val /= 3;

        return new Color(val,val,val);
    }
}
