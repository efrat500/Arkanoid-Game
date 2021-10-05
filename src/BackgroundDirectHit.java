//ID:206475907

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class responsible for the background of the first level - Direct Hit.
 */
public class BackgroundDirectHit implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //the background
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        //the blue circles on the surface
        int x = 0;
        for (int i = 0; i < 3; i++) {
            d.setColor(Color.blue);
            d.drawCircle(400, 150, 70 + x);
            x += 25;
        }
        //the blue lines on the circles
        d.setColor(Color.blue);
        d.drawLine(425, 150, 530, 150);
        d.drawLine(270, 150, 375, 150);
        d.drawLine(400, 20, 400, 125);
        d.drawLine(400, 175, 400, 280);
    }

    @Override
    public void timePassed() {

    }
}
