package system;

import java.awt.*;

public class DisplayChar {
    public char toDisplay;
    public Color color;

    public Color getGrayscale(){
        int val;

        //the average of all colors, producing a gray color
        val = color.getBlue() + color.getGreen() + color.getRed();
        val /= 3;

        return new Color(val,val,val);
    }
}
