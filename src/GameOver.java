//ID:206475906


import biuoop.DrawSurface;

/**
 * This class represent that the game is over, and the player lost in the game.
 */
public class GameOver implements Animation {
    private boolean stop;
    private Counter score;

    /**
     * constructor.
     * @param score the score
     */
    public GameOver(Counter score) {

        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        int x = this.score.getValue();
        //the game over screen
        d.drawText(50, d.getHeight() / 2, "Game Over. Your score is " + Integer.toString(x), 50);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
