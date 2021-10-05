//ID:206475907

/**
 * A BallRemover is in charge of removing balls from the game,
 * as well as keeping count of the number of balls that remain.
 */

public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor.
     * @param game the game
     * @param removedBalls the counter that count the number of balls that remain
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the block
     * @param hitter the ball
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
