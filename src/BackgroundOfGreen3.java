// ID 207013491
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class responsible on the background of the third level - Green3.
 */
public class BackgroundOfGreen3 implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        // fill the drawSurface with green color
        d.setColor(new Color(0, 128, 0));
        d.fillRectangle(0, 0, 800, 600);
        drawCircles(d);
        drawRectangle(d);
        int xOfSmallRect = 70, width = 12;
        int yOfSmellRect = 428, height = 30;
        // draw the small white rectangles int the big rectangle
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.setColor(Color.white);
                d.fillRectangle(xOfSmallRect + ((width * j) + (10 * j)), yOfSmellRect, width, height);
            }
            yOfSmellRect = yOfSmellRect + height + 10;
        }
    }

    /**
     * draw the circles in background.
     * @param d the draw surface.
     */
    public void drawCircles(DrawSurface d) {
        // draw the big circle
        d.setColor(new Color(189, 183, 107));
        d.fillCircle(120, 190, 15);
        // draw the middle circle
        d.setColor(new Color(255, 99, 71));
        d.fillCircle(120, 190, 10);
        // draw the small circle
        d.setColor(Color.white);
        d.fillCircle(120, 190, 5);
    }

    /**
     * draw the rectangles in background.
     * @param d the draw surface.
     */
    public void drawRectangle(DrawSurface d) {
        // draw the small rectangle
        d.setColor(new Color(61, 61, 41));
        d.fillRectangle(115, 205, 10, 150);
        // draw the middle rectangle
        d.setColor(new Color(61, 61, 41));
        d.fillRectangle(100, 355, 40, 65);
        // draw the big rectangle
        d.setColor(new Color(61, 61, 41));
        d.fillRectangle(60, 420, 120, 180);
    }
    @Override
    public void timePassed() {

    }
}
