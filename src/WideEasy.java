//ID:206475907

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *This class the second level in the game.
 */
public class WideEasy implements LevelInformation {

    static final int MAX_SPEED = 4;
    static final int SPEED_PADDLE = 6;
    static final int WIDTH_PADDLE = 600;
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        //the ball in one side
        int angle = 10;
        int size = numberOfBalls() / 2;
        for (int i = 0; i < size; i++) {
            Velocity v1 = Velocity.fromAngleAndSpeed(180 + angle, MAX_SPEED);
            angle += 10;
            velocities.add(v1);
        }
        //the ball in the second side
        angle = 0;
        for (int i = 0; i < size; i++) {
            Velocity v1 = Velocity.fromAngleAndSpeed(130 + angle, MAX_SPEED);
            angle += 10;
            velocities.add(v1);
        }
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
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        Sprite sprite = new BackgroundWideEasy();
        return sprite;
    }

    @Override
    public List<Block> blocks() {
        List<Block> listOfBlock = new ArrayList<>();
        int y = 270;
        double width = 51;
        Color color = null;
        //the block in different colors
        for (int i = 0; i < 15; i++) {
            if (i < 2) {
                color = Color.RED;
            } else if (i < 4) {
                color = Color.ORANGE;
            } else if (i < 6) {
                color = Color.YELLOW;
            } else if (i < 9) {
                color = Color.GREEN;
            } else if (i < 11) {
                color = Color.blue;
            } else if (i < 13) {
                color = Color.PINK;
            } else {
                color = Color.CYAN;
            }
            Rectangle rec = new Rectangle(new Point(20 + (i * width), y), width, 20);
            Block b = new Block(rec, color);
            listOfBlock.add(b);
        }
        return listOfBlock;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
