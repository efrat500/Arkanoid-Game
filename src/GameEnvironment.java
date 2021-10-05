//ID:2064750907

import java.util.ArrayList;
import java.util.List;

/**
 * This class create the collidable in the game environment and check the collision between them and the balls.
 */

public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }
    /**
     *This function add the given collidable to the environment.
     * @param c the collidble we want to add
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * This function remove the collidable from the game.
     * @param c the collidable
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }
    /**
     * This function returns the information about the closest collision that is going to occur.
     * @param trajectory the line where the ball moves
     * @return If this object will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //If the object will not collide with any of the collidables, it will remain null
        CollisionInfo closetCollisionInfo = null;
        double minDistance = 0;
        //This loop runs on the collidables and checks for the closest collision
        for (Collidable c : collidables) {
            Point point = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (point != null) {
                //in the first time
                if (closetCollisionInfo == null) {
                    closetCollisionInfo = new CollisionInfo(point, c);
                    minDistance = trajectory.start().distance(closetCollisionInfo.collisionPoint());
                }
                //Checks the minimum distance to know what the first collision is
                double distance = trajectory.start().distance(point);
                minDistance = Math.min(minDistance, distance);
                if (distance <= minDistance) {
                    closetCollisionInfo = new CollisionInfo(point, c);
                }
            }
        }
        return closetCollisionInfo;
    }
}
