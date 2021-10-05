//ID:206475907

/**
 * This interface represent the function that all the object called collidable need to implement.
 */

public interface Collidable {

    /**
     *  This function return the collision shape of the object.
     * @return the collision shape of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * This function gives a new velocity after the hit
     *  (based on the force the object inflicted on us).
     *
     * @param hitter the ball hitter
     * @param collisionPoint the collision point between the ball and the object
     * @param currentVelocity the velocity of the ball before the collision
     * @return the new velocity after the collision
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
