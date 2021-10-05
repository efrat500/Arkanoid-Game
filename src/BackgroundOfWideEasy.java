// ID 207013491
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class responsible on the background of the second level - WideEasy.
 */
public class BackgroundOfWideEasy implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        // fill the drawSurface with white color
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        // draw the big circle
        d.setColor(new Color(240, 230, 140));
        d.fillCircle(150, 160, 70);
        // draw the lines that out from the circles
        int x = 0;
        for (int i = 0; i < 80; i++) {
            d.setColor(new Color(240, 230, 140));
            d.drawLine(160 , 160 , 20 + x, 280);
            x = x + 8;
        }
        // draw the middle circle
        d.setColor(new Color(255, 215, 0));
        d.fillCircle(150, 160, 60);
        // draw the small circle
        d.setColor(Color.yellow);
        d.fillCircle(150, 160, 50);
    }

    @Override
    public void timePassed() { }
}
