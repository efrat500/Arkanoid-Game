//ID:206475907

/**
 * This class update this counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    static final int INCREASE_SCORE = 5;
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the block
     * @param hitter the ball
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(INCREASE_SCORE);
    }
}
