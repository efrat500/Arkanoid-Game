//ID:206475907

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.BLACK;

/**
 * This class represent a block on the surface.
 */

public class Block implements Collidable, Sprite, HitNotifier {
    static final double EPSILON = 0.001;
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;


    /**
     * constructor.
     *
     * @param r the rectangle
     * @param c the color of the block
     */
    public Block(Rectangle r, Color c) {
        this.rectangle = r;
        this.color = c;
        this.hitListeners = new ArrayList<>();
    }
    /**
     * This function return the collision shape of the object.
     * @return the collision shape of the object.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * This function draws the blocks on the surface.
     *
     * @param surface the surface on which we draw the blocks
     */
    public void drawOn(DrawSurface surface) {
        //Set the color of the rectangle
        surface.setColor(getColor());
        surface.fillRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        //Draws the black frame of the rectangle
        surface.setColor(BLACK);
        surface.drawRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * This function returns the color of the block.
     * @return the color of the block
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * This function notify all listeners about a hit event.
     * @param hitter the ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new
                ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
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
        //The vertices of the block
        Point point = rectangle.getUpperLeft();
        Point p1 = new Point(point.getX(), point.getY() + rectangle.getHeight());
        Point p2 = new Point(point.getX() + rectangle.getWidth(), point.getY());
        Point p3 = new Point(point.getX() + rectangle.getWidth(), point.getY() + rectangle.getHeight());
        //The ribs of the block
        Line upLine = new Line(point, p2);
        Line leftLine = new Line(point, p1);
        Line rightLine = new Line(p2, p3);
        Line downLine = new Line(p1, p3);
        //The collision point of the ball with the block. Epsilon to "expand" the point to identify all collisions
        double x = collisionPoint.getX() - EPSILON;
        double x1 = collisionPoint.getX() + EPSILON;
        double y = collisionPoint.getY() - EPSILON;
        double y1 = collisionPoint.getY() + EPSILON;
        Point point1 = new Point(x, y);
        Point point2 = new Point(x1, y1);
        Line line = new Line(point1, point2);
        //If the collision of the ball is with the ribs parallel to the y axis
        if ((upLine.isIntersecting(line) || downLine.isIntersecting(line))) {
            currentVelocity.setDy((-1) * currentVelocity.getDy());
            //this.removeFromGame(this.g);
            this.notifyHit(hitter);
        }
        //If the collision of the ball is with the ribs parallel to the x axis
        if (leftLine.isIntersecting(line) || rightLine.isIntersecting(line)) {
            currentVelocity.setDx((-1) * currentVelocity.getDx());
            //this.removeFromGame(this.g);
            this.notifyHit(hitter);
        }
        return  currentVelocity;
    }

    /**
     *  This function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * This function add the block to the game.
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * This function remove the block from the game.
     * @param game this game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * This function add the block to the hit listeners.
     * @param hl the hit listeners
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * This function remove the block from the hit listeners.
     * @param hl the hit listeners
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
