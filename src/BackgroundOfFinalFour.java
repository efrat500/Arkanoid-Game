// ID 207013491
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class responsible on the background of the fourth level - FinalFour.
 */
public class BackgroundOfFinalFour implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        // fill the drawSurface with blue color
        d.setColor(new Color(30, 144, 255));
        d.fillRectangle(0, 0, 800, 600);
        // draw the lines that out from the first cloud
        int x = 0;
        for (int i = 0; i < 10; i++) {
            d.setColor(Color.white);
            d.drawLine(90 + x, 400 , 60 + x, 600);
            x = x + 10;
        }
        drawCirclesLeft(d);
        // draw the lines that out from the second cloud
        int y = 0;
        for (int i = 0; i < 10; i++) {
            d.setColor(Color.white);
            d.drawLine(610 + y, 500 , 590 + y, 600);
            y = y + 10;
        }
        drawCirclesRight(d);
    }

    /**
     * draw the circles in the left side.
     * @param d the draw surface.
     */
    public void drawCirclesLeft(DrawSurface d) {
        // draw the two circles in color of gray that similar to white
        d.setColor(new Color(211, 211, 211));
        d.fillCircle(80, 400, 25);
        d.setColor(new Color(211, 211, 211));
        d.fillCircle(100, 420, 25);
        // draw the circle in color of light gray
        d.setColor(new Color(192, 192, 192));
        d.fillCircle(120, 390, 30);
        // draw the two circles in color of gray
        d.setColor(new Color(169, 169, 169));
        d.fillCircle(130, 420, 20);
        d.setColor(new Color(169, 169, 169));
        d.fillCircle(155, 400, 35);
    }

    /**
     * draw the circles in the right side.
     * @param d the draw surface.
     */
    public void drawCirclesRight(DrawSurface d) {
        // draw the two circles in color of gray that similar to white
        d.setColor(new Color(211, 211, 211));
        d.fillCircle(600, 500, 25);
        d.setColor(new Color(211, 211, 211));
        d.fillCircle(620, 530, 25);
        // draw the circle in color of light gray
        d.setColor(new Color(192, 192, 192));
        d.fillCircle(640, 490, 30);
        // draw the two circles in color of gray
        d.setColor(new Color(169, 169, 169));
        d.fillCircle(650, 520, 20);
        d.setColor(new Color(169, 169, 169));
        d.fillCircle(675, 500, 35);
    }
    @Override
    public void timePassed() { }
}
