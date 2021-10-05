//ID:206475907

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *This class represent the third level in the game.
 */
public class Green3 implements LevelInformation {

    //The gui
    static final int SURFACE_WIDTH = 800;


    //The ribs of the shapes
    static final int RIBBED_RECTANGLE = 20;
    static final int START_OF_REC = 150;

    static final int MAX_REC_IN_LINE = 12;
    static final int NUMBER_OF_REC_LINE = 5;
    static final int REC_WIDTH = 50;
    static final int MAX_SPEED = 3;
    static final int SPEED_PADDLE = 6;
    static final int WIDTH_PADDLE = 100;
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity v1 = Velocity.fromAngleAndSpeed(150, MAX_SPEED);
        velocities.add(v1);
        Velocity v2 = Velocity.fromAngleAndSpeed(210, MAX_SPEED);
        velocities.add(v2);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return SPEED_PADDLE;
    }

    @Override
    public int paddleWidth() {
        return WIDTH_PADDLE;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Sprite sprite = new BackgroundGreen3();
        return sprite;
    }

    @Override
    public List<Block> blocks() {
        List<Block> listOfBlock = new ArrayList<>();
        //the array of the blocks colors
        Color[] arrayOfColor = new Color[]{Color.RED, Color.GREEN, Color.CYAN, Color.PINK, Color.ORANGE, Color.YELLOW};
        for (int i = 0; i < NUMBER_OF_REC_LINE; i++) {
            for (int j = 0; j < MAX_REC_IN_LINE - i; j++) {
                //for each loop create one block in the surface
                Rectangle rec = new Rectangle(new Point(SURFACE_WIDTH - RIBBED_RECTANGLE - REC_WIDTH
                        - (REC_WIDTH * j), START_OF_REC + (i + 1) * RIBBED_RECTANGLE), REC_WIDTH, RIBBED_RECTANGLE);
                //Each line has different colored blocks
                Block b = new Block(rec, arrayOfColor[i]);
                listOfBlock.add(b);
            }
        }
        return listOfBlock;
    }

    @Override
        public int numberOfBlocksToRemove() {
            return blocks().size();
        }
}
