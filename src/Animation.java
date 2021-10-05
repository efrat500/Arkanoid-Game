//ID:206475907

import biuoop.DrawSurface;

/**
 * This interface represent the function that responsible on the animations in the game.
 */

public interface Animation {
    /**
     * This function does one frame in the game.
     * @param d the draw surface
     */
    void doOneFrame(DrawSurface d);

    /**
     * This function represent that the game should stop.
     * @return true if the game should stop, false if not.
     */
    boolean shouldStop();
}
