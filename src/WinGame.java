//ID:206475907

import biuoop.DrawSurface;

/**
 * This class represent that the gamer wins.
 */
public class WinGame implements Animation {
    private boolean stop;
    private Counter score;

    /**
     * constructor.
     * @param s the score
     */
    public WinGame(Counter s) {
        this.stop = false;
        this.score = s;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        int x = this.score.getValue();
        //the player wins
        d.drawText(50, d.getHeight() / 2, "You Win! Your score is " + Integer.toString(x), 50);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
