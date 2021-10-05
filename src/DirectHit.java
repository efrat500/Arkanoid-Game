//ID:206475907

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represent the first level in the game.
 */
public class DirectHit implements LevelInformation {
    static final int MAX_SPEED = 5;
    static final int SPEED_PADDLE = 6;
    static final int WIDTH_PADDLE = 100;

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Random rand = new Random();
        List<Velocity> velocities = new ArrayList<>();
        //The ball should go up
        int angle = 360;
        int speed = rand.nextInt(MAX_SPEED) + 1;
        Velocity v1 = Velocity.fromAngleAndSpeed(angle, speed);
        velocities.add(v1);
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Sprite sprite = new BackgroundDirectHit();
        return sprite;
    }

    @Override
    public List<Block> blocks() {
        List<Block> listOfBlock = new ArrayList<>();
        //the red block
        Block block = new Block(new Rectangle(new Point(380, 130), 40, 40), Color.RED);
        listOfBlock.add(block);
        return listOfBlock;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
