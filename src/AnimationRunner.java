//ID:206475907
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * This class runs the animation.
 */

public class AnimationRunner {
    static final int FRAME_PER_SECOND = 60;
    static final int MILLI_SECOND = 1000;
    private GUI gui;

    /**
     * constructor.
     * @param gui the gui.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
    }

    /**
     * This function runs the animation.
     * @param animation the animation
     */
    public void run(Animation animation) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        int framesPerSecond = FRAME_PER_SECOND;
        int millisecondsPerFrame = MILLI_SECOND / framesPerSecond;
        //An endless loop that runs the game
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
