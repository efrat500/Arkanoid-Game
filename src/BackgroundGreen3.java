//ID:206475907

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class responsible for the background of the third level - Green 3.
 */
public class BackgroundGreen3 implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        // the background
        Color color = new Color(0, 150, 0);
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);
        //the big gray rectangle
        Color color1 = new Color(64, 64, 64);
        d.setColor(color1);
        d.fillRectangle(50, 420, 100, 180);

        //the small white rectangles on the big rectangle
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.setColor(Color.WHITE);
                d.fillRectangle(55 + (j * 20), 430 + (i * 40), 10, 30);
            }
        }
        //more rectangles in the background
        Color color2 = new Color(96, 96, 96);
        d.setColor(color2);
        d.fillRectangle(80, 350, 40, 70);
        Color color3 = new Color(64, 64, 64);
        d.setColor(color3);
        d.fillRectangle(93, 200, 14, 150);

        //the circle
        d.setColor(Color.ORANGE);
        d.fillCircle(100, 185, 15);
        d.setColor(Color.RED);
        d.fillCircle(100, 185, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(100, 185, 5);
    }

    @Override
    public void timePassed() {

    }
}
