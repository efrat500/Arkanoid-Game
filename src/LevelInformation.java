//ID:206475907

import java.util.List;

/**
 * This interface represent the function that responsible to each level (from the four levels) in the game.
 */
public interface LevelInformation {
    /**
     * return the num of balls in the level.
     * @return the num of balls
     */
    int numberOfBalls();

    /**
     * This function responsible on the initial velocity of each ball.
     * @return list of velocity
     */
    List<Velocity> initialBallVelocities();

    /**
     * This function return the paddle speed.
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * This function return the paddle width.
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * This function return the level name.
     * @return the level name.
     */
    String levelName();

    /**
     * This function returns a sprite with the background of the level.
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * This function returns the blocks that make up this level.
     * @return the blocks that make up this level.
     */
    List<Block> blocks();

    /**
     * This function returns the number of blocks that should be removed.
     * @return the number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
}
