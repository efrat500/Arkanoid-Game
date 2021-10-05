//ID:206475907

import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;


/**
 * This class initializes and runs the game.
 */
public class Ass6Game {


    /**
     * This main function that runs the game.
     *
     * @param args .
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        //the levels
        DirectHit directHit = new DirectHit();
        WideEasy wideEasy = new WideEasy();
        Green3 green3 = new Green3();
        FinalFour finalFour = new FinalFour();
        //if there are args
        for (int i = 0; i < args.length; i++) {
            String string = args[i];
            if (string.equals("1")) {
                levels.add(directHit);
            }
            if (string.equals("2")) {
                levels.add(wideEasy);
            }
            if (string.equals("3")) {
                levels.add(green3);
            }
            if (string.equals("4")) {
                levels.add(finalFour);
            }
        }
        //if there are not args
        if (levels.size() == 0) {
            levels.add(directHit);
            levels.add(wideEasy);
            levels.add(green3);
            levels.add(finalFour);
        }
        //the gui
            GUI gui = new GUI("Game", 800, 600);
            AnimationRunner animationRunner = new AnimationRunner(gui);
            biuoop.KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
            Counter counter = new Counter(0);
            GameFlow gameFlow = new GameFlow(counter, animationRunner, keyboardSensor, gui);
            //run the game
            gameFlow.runLevels(levels);
        }

    }


