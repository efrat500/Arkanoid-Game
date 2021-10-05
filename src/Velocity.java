//ID:206475907

/**
 * This class represent the velocity of the ball on the surface.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     *
     * @param dx the velocity on x axis
     * @param dy the velocity on y axis
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * calculate the velocity by size and angle.
     *
     * @param angle the angle of the velocity
     * @param speed the size of the velocity
     * @return the ball velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double b = Math.toRadians(angle);
        double dx = speed * Math.sin(b);
        double dy = (-1) * speed * Math.cos(b);
        return new Velocity(dx, dy);
    }

    /**
     * Take a point (the center of the ball before the moving) with position (x,y)
     * and return a new point (the center of the ball after the moving) with position (x+dx, y+dy).
     *
     * @param p the current point
     * @return the center point of the ball after moving
     */
    public Point applyToPoint(Point p) {
        double x = p.getX() + dx;
        double y = p.getY() + dy;
        return new Point(x, y);
    }

    /**
     * return the velocity in x axis.
     *
     * @return velocity in x axis
     */
    public double getDx() {
        return dx;
    }

    /**
     * update the velocity in x axis.
     *
     * @param dxVelocity the current velocity in x axis
     */
    public void setDx(double dxVelocity) {
        this.dx = dxVelocity;
    }

    /**
     * return the velocity in y axis.
     *
     * @return velocity in y axis
     */
    public double getDy() {
        return dy;
    }

    /**
     * update the velocity in y axis.
     *
     * @param dyVelocity the current velocity in y axis
     */
    public void setDy(double dyVelocity) {
        this.dy = dyVelocity;
    }
}