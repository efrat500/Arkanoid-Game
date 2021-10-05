// ID 207013491
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class is responsible to display screen that draw on him "You Win! Your score is X"
 * when the player is winning.
 */
public class YouWin implements Animation {
    // field
    private KeyboardSensor keyboard;
    private boolean stop = false;
    private Counter counterOfscore;

    /**
     * Constructor - create a new YouWin screen.
     * @param k is keyboard.
     * @param counterOfscore the score of the player.
     */
    public YouWin(KeyboardSensor k, Counter counterOfscore) {
        this.keyboard = k;
        this.counterOfscore = counterOfscore;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // draw on the screen that the game is paused
        d.drawText(220, d.getHeight() / 2, "You Win! Your score is " + this.counterOfscore.toString(), 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
