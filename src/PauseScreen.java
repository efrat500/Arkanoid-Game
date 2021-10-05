//ID:206475907

import biuoop.DrawSurface;

/**
 *This class represent that the game paused.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        //the game paused
        d.drawText(20, d.getHeight() / 2, "paused -- press space to continue", 50);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
