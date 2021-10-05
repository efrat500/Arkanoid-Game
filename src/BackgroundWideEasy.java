///ID:206475907

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class responsible for the background of the second level - Wide Easy.
 */
public class BackgroundWideEasy implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        Color color = new Color(184, 134, 11);
        //The lines that represent the sun's rays
        int xPoint = 0;
        for (int i = 0; i < 110; i++) {
            d.setColor(color);
            d.drawLine(180, 150, 700 - xPoint, 270);
            xPoint += 7;
        }
        //the sun
        d.setColor(color);
        d.fillCircle(150, 150, 60);
        Color color1 = new Color(255, 215, 0);
        d.setColor(color1);
        d.fillCircle(150, 150, 50);
        d.setColor(Color.YELLOW);
        d.fillCircle(150, 150, 40);


    }

    @Override
    public void timePassed() {

    }
}
