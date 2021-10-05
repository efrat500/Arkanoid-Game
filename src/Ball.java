//ID:206475907

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * class that represent a ball on a surface.
 */
public class Ball implements Sprite {
    private Point point;
    private int r;
    private Color color;
    private Velocity v = new Velocity(0, 0);
    private GameEnvironment gameEnvironment;

    /**
     * constructor.
     * @param center the ball center point.
     * @param r the ball radius.
     * @param color the ball color.
     * @param gameEnvironment the game environment of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.point = center;
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * constructor.
     * @param x the x of the ball center point.
     * @param y the y of the ball center point.
     * @param r the ball radius.
     * @param color the ball color.
     * @param gameEnvironment the game environment of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this(new Point(x, y), r, color, gameEnvironment);
    }

    /**
     * x accessor.
     *
     * @return the x value of the center point.
     */
    public int getX() {
        return (int) this.point.getX();
    }

    /**
     * y accessor.
     *
     * @return the y value of the center point.
     */
    public int getY() {
        return (int) this.point.getY();
    }

    /**
     * get the ball size.
     *
     * @return the ball radius.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * get the ball color.
     *
     * @return the ball color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface the surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.drawCircle(getX(), getY(), getSize());
        surface.setColor(Color.WHITE);
        surface.fillCircle(getX(), getY(), getSize());
    }

    /**
     * set the ball Velocity using x and y.
     *
     * @param dx the x of the ball Velocity.
     * @param dy the y of the ball Velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * get the ball Velocity.
     *
     * @return the ball Velocity.
     */
    public Velocity getVelocity() {
        return v;
    }

    /**
     * set the ball Velocity.
     *
     * @param velocity the Velocity of the ball movement.
     */
    public void setVelocity(Velocity velocity) {
        this.v = velocity;
    }


    /**
     *  move one step and update the velocity according to the surface borders.
     *
     */
    public void moveOneStep() {
        //The next point the ball is supposed to be
        double x = v.applyToPoint(point).getX() + v.getDx();
        double y = v.applyToPoint(point).getY() + v.getDy();
        Point p = new Point(x, y);
        Line line = new Line(point, p);
        //no collision
        CollisionInfo ci = gameEnvironment.getClosestCollision(line);
        if (ci == null) {
            point = this.getVelocity().applyToPoint(point);
            //collision
        } else {
           setVelocity(ci.collisionObject().hit(this, ci.collisionPoint(), getVelocity()));
        }
    }
    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * This function add the ball to the game.
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * This function remove the ball from the game.
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

}

