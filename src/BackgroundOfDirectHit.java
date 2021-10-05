// ID 207013491
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class responsible on the background of the first level - DirectHit.
 */
public class BackgroundOfDirectHit implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        // fill the drawSurface with black color
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        drawCircls(d);
        drawLins(d);
    }

    /**
     * draw the circles in background.
     * @param d the draw surface.
     */
    public void drawCircls(DrawSurface d) {
        // draw the small circle
        d.setColor(new Color(3, 3, 168));
        d.drawCircle(400, 160, 60);
        // draw the middle circle
        d.setColor(new Color(3, 3, 168));
        d.drawCircle(400, 160, 90);
        // draw the big circle
        d.setColor(new Color(3, 3, 168));
        d.drawCircle(400, 160, 120);
    }

    /**
     * draw the lines in background.
     * @param d the draw surface.
     */
    public void drawLins(DrawSurface d) {
        // draw the up line
        d.setColor(new Color(3, 3, 168));
        d.drawLine(400, 20, 400, 140);
        // draw the down line
        d.setColor(new Color(3, 3, 168));
        d.drawLine(400, 190, 400, 310);
        // draw the left line
        d.setColor(new Color(3, 3, 168));
        d.drawLine(260, 160, 380, 160);
        // draw the right line
        d.setColor(new Color(3, 3, 168));
        d.drawLine(420, 160, 545, 160);
    }
    @Override
    public void timePassed() { }
}
