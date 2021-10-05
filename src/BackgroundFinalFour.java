//ID: 206475907

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class responsible for the background of the last level - Final Four.
 */
public class BackgroundFinalFour implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //the background
        Color color = new Color(51, 153, 255);
        d.setColor(color);
        d.fillRectangle(0,  0, 800, 600);
        Color color1 = new Color(224, 224, 224);
        //the lines that represent the "rain"
        int xPoint = 0;
        for (int i = 0; i < 10; i++) {
            d.setColor(color1);
            d.drawLine(100 + xPoint, 400, 80 + xPoint, 600);
            xPoint += 9;

        }
        //the lines that represent the "rain"
        int yPoint = 0;
        for (int i = 0; i < 10; i++) {
            d.setColor(color1);
            d.drawLine(650 + yPoint, 500, 630 + yPoint, 600);
            yPoint += 7;

        }
        //The circles that make up the clouds
        Color color2 = new Color(192, 192, 192);
        Color color3 = new Color(160, 160, 160);
        d.setColor(color1);
        d.fillCircle(95, 400, 20);
        d.fillCircle(115, 420, 20);
        d.fillCircle(640, 500, 20);
        d.fillCircle(660, 530, 25);
        d.setColor(color2);
        d.fillCircle(130, 390, 25);
        d.fillCircle(670, 510, 25);
        d.setColor(color3);
        d.fillCircle(160, 400, 25);
        d.fillCircle(140, 420, 15);
        d.fillCircle(680, 530, 15);
        d.fillCircle(700, 520, 25);
    }

    @Override
    public void timePassed() {

    }
}
