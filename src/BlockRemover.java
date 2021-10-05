//ID:206475907

/**
 * A BlockRemover is in charge of removing blocks from the game,
 * as well as keeping count of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     * @param game the game
     * @param removedBlocks the counter that count the number of blocks that remain
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the block
     * @param hitter the ball
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}

