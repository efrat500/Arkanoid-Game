//ID:206475907
import biuoop.DrawSurface;
import java.awt.Color;
import static java.awt.Color.BLACK;

/**
 * This class responsible to the score indicator that shows the score in the game.
 */
public class ScoreIndicator implements Sprite  {
    static final int SCORE_PLACE = 300;
    static final int SCORE_FRONT = 14;
    static final int SCORE_PLACE_2 = 17;


    private Rectangle rectangle;
    private Color color;
    private Counter scoreCounter;
    private LevelInformation levelInformation;

    /**
     /**
     * constructor.
     * @param rec the rectangle
     * @param color the color of the rectangle
     * @param scoreCounter the counter that counter the score
     * @param levelInformation the level information
     */
    public ScoreIndicator(Rectangle rec, Color color, Counter scoreCounter, LevelInformation levelInformation) {
        this.rectangle = rec;
        this.color = color;
        this.scoreCounter = scoreCounter;
        this.levelInformation = levelInformation;
    }

    /**
     * This function draw the sprite to the screen.
     * @param d the draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        //Set the color of the rectangle
        d.setColor(this.color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        //Draws the black frame of the rectangle
        d.setColor(BLACK);
        d.drawRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.drawText(SCORE_PLACE, SCORE_PLACE_2, "Score:"
                + Integer.toString(this.scoreCounter.getValue()), SCORE_FRONT);
        d.drawText(600, SCORE_PLACE_2, "Level Name:" + this.levelInformation.levelName(), SCORE_FRONT);

    }

    /**
     * This function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * This function add this score indicator to the game.
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
