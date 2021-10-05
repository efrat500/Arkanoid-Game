//ID:206475907

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class create the paddle in the surface.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Color color;
    private Rectangle rec;
    private int velocityOfPaddle;
    static final int REC_RIB = 22;
    static final int SURFACE_WIDTH = 800;
    static final int REC_PARTITION = 5;
    static final double EPSILON = 0.001;

    /**
     * constructor.
     * @param keyboard the keyboard that makes the paddle move
     * @param color the color of the paddle
     * @param rec the shape of the paddle - rectangle
     * @param v the velocity of the paddle
     */
    public Paddle(KeyboardSensor keyboard, Color color, Rectangle rec, int v) {
        this.keyboard = keyboard;
        this.color = color;
        this.rec = rec;
        this.velocityOfPaddle = v;
    }

    /**
     * This function causes the paddle to move to the left.
     */
    public void moveLeft() {
        rec = new Rectangle(new Point(rec.getUpperLeft().getX() - this.velocityOfPaddle, rec.getUpperLeft().getY()),
                rec.getWidth(), rec.getHeight());
    }

    /**
     * This function causes the paddle to move to the right.
     */
    public void moveRight() {
        rec = new Rectangle(new Point(rec.getUpperLeft().getX() + this.velocityOfPaddle, rec.getUpperLeft().getY()),
                rec.getWidth(), rec.getHeight());
    }
    /**
     * This function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        //the paddle move left
        if ((keyboard.isPressed(KeyboardSensor.LEFT_KEY)) && (rec.getUpperLeft().getX() > REC_RIB)) {
            moveLeft();
        }
        //the paddle move right
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)
                && (rec.getUpperLeft().getX() + rec.getWidth()) < (SURFACE_WIDTH - REC_RIB)) {
            moveRight();
        }
    }
    /**
     * This function draws the sprite to the screen.
     * @param d the draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) rec.getUpperLeft().getX(), (int) rec.getUpperLeft().getY(),
                (int) rec.getWidth(), (int) rec.getHeight());
        //The frame of the paddle
        d.setColor(Color.BLACK);
        d.drawRectangle((int) rec.getUpperLeft().getX(),
                (int) rec.getUpperLeft().getY(), (int) rec.getWidth(), (int) rec.getHeight());
    }
    /**
     *  This function return the collision shape of the object.
     * @return the collision shape of the object.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rec;
    }

    /**
     *This function divided the line of the paddle to 5 partition.
     * @return array list with the line of the rectangle.
     */
    public java.util.List<Line> arrayOfPaddleLine() {
        List<Line> listOfLine = new ArrayList<>();
        double partOfWidth = rec.getWidth() / REC_PARTITION;
        double y = rec.getUpperLeft().getY();
        Point point1 = rec.getUpperLeft();
        Point point2 = new Point(rec.getUpperLeft().getX() + partOfWidth, y);
        Point point3 = new Point(point2.getX() + partOfWidth, y);
        Point point4 = new Point(point3.getX() + partOfWidth, y);
        Point point5 = new Point(point4.getX() + partOfWidth, y);
        Point point6 = new Point(point5.getX() + partOfWidth, y);
        //Each division is one line
        Line line1 = new Line(point1, point2);
        listOfLine.add(line1);
        Line line2 = new Line(point2, point3);
        listOfLine.add(line2);
        Line line3 = new Line(point3, point4);
        listOfLine.add(line3);
        Line line4 = new Line(point4, point5);
        listOfLine.add(line4);
        Line line5 = new Line(point5, point6);
        listOfLine.add(line5);
        return listOfLine;
    }


    /**
     * This function return an array of the lines in the paddle that are parallel to the X axis.
     * @return array of the lines paddle.
     */
    public java.util.List<Line> arrayOfPaddleLine2() {
        List<Line> listOfPoint = new ArrayList<>();
        Point point1 = rec.getUpperLeft();
        Point point2 = new Point(rec.getUpperLeft().getX(), rec.getUpperLeft().getY() + rec.getHeight());
        Point point3 = new Point(rec.getUpperLeft().getX() + rec.getWidth(),
                rec.getUpperLeft().getY());
        Point point4 = new Point(rec.getUpperLeft().getX() + rec.getWidth(),
                rec.getUpperLeft().getY() + rec.getHeight());
        Line line = new Line(point1, point2);
        listOfPoint.add(line);
        Line line1 = new Line(point3, point4);
        listOfPoint.add(line1);
        return listOfPoint;
    }
    /**
     * This function gives a new velocity after the hit
     *  (based on the force the object inflicted on us).
     *
     * @param collisionPoint the collision point between the ball and the object
     * @param currentVelocity the velocity of the ball before the collision
     * @param hitter the ball hitter
     * @return the new velocity after the collision
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //the collision point of the ball with the paddle
        double p1 = collisionPoint.getX() - EPSILON;
        double p3 = collisionPoint.getX() + EPSILON;
        double p2 = collisionPoint.getY() - EPSILON;
        double p4 = collisionPoint.getY() + EPSILON;
        Line line = new Line(new Point(p1, p2), new Point(p3, p4));
        List<Line> lineOfPaddle = arrayOfPaddleLine();
        List<Line> lineOfPaddle2 = arrayOfPaddleLine2();
        //Calculate the velocity of collision by the Pythagoras
        double v = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        //If the collision is in the first part
        if (line.isIntersecting(lineOfPaddle.get(0)) || line.isIntersecting(lineOfPaddle2.get(0))) {
            currentVelocity = Velocity.fromAngleAndSpeed(300, v);
            //If the collision is in the second part
        } else if (line.isIntersecting(lineOfPaddle.get(1))) {
            currentVelocity = Velocity.fromAngleAndSpeed(330, v);
            //If the collision is in the third part
        } else if (line.isIntersecting(lineOfPaddle.get(2))) {
            currentVelocity.setDy((-1) * currentVelocity.getDy());
            //If the collision is in the fourth part
        } else if (line.isIntersecting(lineOfPaddle.get(3))) {
            currentVelocity = Velocity.fromAngleAndSpeed(30, v);
            //If the collision is in the fifth part
        } else if (line.isIntersecting(lineOfPaddle.get(4)) || line.isIntersecting(lineOfPaddle2.get(1))) {
            currentVelocity = Velocity.fromAngleAndSpeed(60, v);
        }
            return currentVelocity;
        }

    /**
     * Add this paddle to the game.
     * @param g the game
     */
      public void addToGame(GameLevel g) {
          g.addSprite(this);
          g.addCollidable(this);
      }
}
