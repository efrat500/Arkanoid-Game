//ID:206475907

/**
 *This class represent rhe collisionInfo by the collision point and the collision object.
 */

public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor.
     * @param p the collision point
     * @param object the object of the collisionInfo
     */
    public CollisionInfo(Point p, Collidable object) {
        this.collisionPoint = p;
        this.collisionObject = object;
    }

    /**
     * This function return the point at which the collision occurs.
     * @return the collision point.
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * This function return the collidable object involved in the collision.
     * @return the object involved in the collision.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}
