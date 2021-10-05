//ID:206475907

import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will appear on the screen for seconds,
 * before it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private int countForm;
    private SpriteCollection gameScreen;
    private boolean stop;
    private Sleeper sleeper;
    static final int SURFACE_WIDTH = 800;
    static final int SURFACE_HEIGHT = 600;

    /**
     * constructor.
     * @param countFrom the seconds
     * @param gameScreen the game screen
     */
    public CountdownAnimation(int countFrom, SpriteCollection gameScreen) {
        this.countForm = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.sleeper = new Sleeper();
    }

    /**
     * This function responsible on the one frame.
     * @param count the count form
     * @param drawSurface the surface
     */
    public void firstFrame(int count, DrawSurface drawSurface) {
        if (count > 0) {
            String s = Integer.toString(count);
            drawSurface.drawText(SURFACE_WIDTH / 2, SURFACE_HEIGHT / 2, s, 32);
            //if the game is about to begin
        } else if (count == 0) {
            String s1 = "GO";
            drawSurface.drawText((SURFACE_WIDTH / 2) - 20, SURFACE_HEIGHT / 2, s1, 32);
        }
        //if this is not the first frame
        if (count != 3) {
            sleeper.sleepFor((long) (1000));
        }
        //update the countForm
        this.countForm--;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.WHITE);
        firstFrame(countForm, d);
        //if the game started
        if (countForm <= -2) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
