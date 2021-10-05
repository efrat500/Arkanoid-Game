//ID:206475907

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the last level in the game.
 */
public class FinalFour implements LevelInformation {
    static final int MAX_SPEED = 4;
    static final int SPEED_PADDLE = 6;
    static final int WIDTH_PADDLE = 100;

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        //the velocity and their angle of the three balls
        Velocity v1 = Velocity.fromAngleAndSpeed(175, MAX_SPEED);
        velocities.add(v1);
        Velocity v2 = Velocity.fromAngleAndSpeed(180, MAX_SPEED);
        velocities.add(v2);
        Velocity v3 = Velocity.fromAngleAndSpeed(185, MAX_SPEED);
        velocities.add(v3);
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Sprite sprite = new BackgroundFinalFour();
        return sprite;
    }

    @Override
    public List<Block> blocks() {
        List<Block> listOfBlock = new ArrayList<>();
        //the array of the blocks colors
        Color[] arrayOfColor = new Color[]{Color.RED, Color.GREEN, Color.CYAN, Color.PINK,
                Color.LIGHT_GRAY, Color.WHITE, Color.YELLOW};
        //the loop of the blocks
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                //Each line has different colored blocks
                Block b = new Block(new Rectangle(new Point(20 + (j * 51), 100 + (i * 20)), 51, 20),
                        arrayOfColor[i]);
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
