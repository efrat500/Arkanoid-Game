//ID:206475907

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * This class initializes the game and runs it.
 */

public class GameLevel implements Animation {
    //The gui
    static final int SURFACE_WIDTH = 800;
    static final int SURFACE_HEIGHT = 600;

    //The ribs of the shapes
    static final int RIBBED_RECTANGLE = 20;
    static final int PADDLE_WIDTH = 150;
    static final int PADDLE_HEIGHT = 10;

    static final int RADIUS = 4;
    static final int COUNTER_SCORE = 100;

    //Start point
    static final int POINT_PADDLE_START = 570;


    static final int MILLI_SECOND = 1000;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter counterBlock;
    private Counter counterBall;
    private Counter counterScore;
    private ScoreTrackingListener scoreTrackingListener;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * constructor.
     * @param levelInfo the level info
     * @param keyboardSensor the keyboard
     * @param animationRunner the animation runner
     * @param gui1 the gui
     * @param score the score
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor keyboardSensor,
                    AnimationRunner animationRunner, GUI gui1, int score) {
        this.sprites = new SpriteCollection();
        this.keyboard = keyboardSensor;
        this.runner = animationRunner;
        this.levelInformation = levelInfo;
        this.counterBlock = new Counter(0);
        this.counterBall = new Counter(0);
        this.counterScore = new Counter(score);
        this.environment = new GameEnvironment();
        this.gui = gui1;
        this.runner = new AnimationRunner(gui);
        this.keyboard = gui.getKeyboardSensor();
        this.scoreTrackingListener = new ScoreTrackingListener(this.counterScore);

    }

    @Override
    public boolean shouldStop() {
        if (this.counterBlock.getValue() == 0) {
            return this.running;
        } else {
            return !this.running;
        }
    }

    /**
     * This function return true if there is more blocks and balls (the game needs to continue), false if not.
     * @return true if there is more blocks and balls, false if not
     */
    public boolean theGameContinue() {
       return (this.counterBlock.getValue() > 0 && this.counterBall.getValue() > 0);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
       //if there are not blocks in the game
        if (this.counterBlock.getValue() == 0) {
            this.counterScore.increase(COUNTER_SCORE);
            DrawSurface drawSurface = gui.getDrawSurface();
            this.sprites.drawAllOn(drawSurface);
            gui.show(drawSurface);
            this.sprites.notifyAllTimePassed();
            Sleeper sleeper1 = new Sleeper();
            sleeper1.sleepFor(MILLI_SECOND);
            return;
        }
        //if "p" is pressed - the game stopped
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "p", new PauseScreen()));
        }
        //if there are not balls in the game
        if (this.counterBall.getValue() == 0) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space", new GameOver(this.counterScore)));
            gui.close();
            return;
        }
    }

    /**
     * This function return the player score.
     * @return the player score
     */
    public int score() {
        return this.counterScore.getValue();
    }

    /**
     * This function add the the collidable to the game environment.
     * @param c the collidable we want to add to the environment
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * This function add the sprites.
     * @param s the sprite we want to add
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * This function initialize a new game: create Blocks,Ball and the Paddle on the surface.
     */
    public void initialize() {
        this.addSprite(levelInformation.getBackground());
        //the balls in the game
        for (int i  = 0; i < levelInformation.numberOfBalls(); i++) {
            counterBall.increase(1);
            Ball ball = new Ball(400, 569, RADIUS, Color.BLACK, environment);
            ball.addToGame(this);
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
        }
        Point p = new Point(400 - (this.levelInformation.paddleWidth() / 2), POINT_PADDLE_START);
        //The paddle
        Rectangle rec = new Rectangle(p, this.levelInformation.paddleWidth(), PADDLE_HEIGHT);
        Paddle paddle = new Paddle(this.keyboard, Color.YELLOW, rec, this.levelInformation.paddleSpeed());
        paddle.addToGame(this);
        List<Block> blocks = new ArrayList<>();
        //The rectangles in the frame
        Block b1 = new Block(new Rectangle(new Point(20, 20), SURFACE_WIDTH, RIBBED_RECTANGLE), Color.GRAY);
        blocks.add(b1);
        Block b2 = new Block(new Rectangle(new Point(0, RIBBED_RECTANGLE),
                RIBBED_RECTANGLE, SURFACE_HEIGHT - RIBBED_RECTANGLE), Color.GRAY);
        blocks.add(b2);
        Block b3 = new Block(new Rectangle(new Point(SURFACE_WIDTH - RIBBED_RECTANGLE,
                RIBBED_RECTANGLE), RIBBED_RECTANGLE, SURFACE_HEIGHT - RIBBED_RECTANGLE), Color.GRAY);
        blocks.add(b3);
        BallRemover ballRemover = new BallRemover(this, this.counterBall);
        //the death block
        Block b4 = new Block(new Rectangle(new Point(0, SURFACE_HEIGHT),
                SURFACE_WIDTH, RIBBED_RECTANGLE), Color.GRAY);
        blocks.add(b4);
        b4.addHitListener(ballRemover);
        BlockRemover blockRemover = new BlockRemover(this, this.counterBlock);
        //add the blocks to the game
        for (int i = 0; i < this.levelInformation.blocks().size(); i++) {
            Block b = this.levelInformation.blocks().get(i);
            b.addToGame(this);
            b.addHitListener(blockRemover);
            b.addHitListener(this.scoreTrackingListener);
            this.counterBlock.increase(1);
        }
        //the score indicator
        Rectangle rec1 = new Rectangle(new Point(0, 0), SURFACE_WIDTH, RIBBED_RECTANGLE);
        ScoreIndicator scoreIndicator = new ScoreIndicator(rec1, Color.WHITE, counterScore, this.levelInformation);
        scoreIndicator.addToGame(this);
        for (Block b: blocks) {
            b.addToGame(this);
        }
    }


    /**
     * This function runs the game and start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(3, this.sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }

    /**
     * This function remove the collidable.
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * This function remove the sprite.
     * @param s the sprite
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }


}

