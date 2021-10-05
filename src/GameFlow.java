//ID:206475907

import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * This class represent the game with all it levels, ans run it.
 */
public class GameFlow {

    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    private Counter c;

    /**
     * constructor.
     * @param counter the counter
     * @param ar animation runner
     * @param ks keyboard
     * @param gui1 gui
     */
    public GameFlow(Counter counter, AnimationRunner ar, KeyboardSensor ks, GUI gui1) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui1;
        this.c = counter;
    }

    /**
     * This function runs all the levels in the game.
     * @param levels the levels in the game
     */
    public void runLevels(List<LevelInformation> levels) {
        //the score
        int counter = this.c.getValue();

        //loop that runs all the levels
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.gui, counter);

            level.initialize();

            //while there are still balls and blocks
            while (level.theGameContinue()) {
                level.run();
            }

            //update the score
            counter = level.score();
            this.c = new Counter(counter);
        }
        //if the player won
        KeyPressStoppableAnimation keyPressStoppableAnimation = new KeyPressStoppableAnimation(this.keyboardSensor,
                "space", new WinGame(this.c));
        this.animationRunner.run(keyPressStoppableAnimation);
        gui.close();
    }
}
