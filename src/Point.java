//ID:206475907

/**
 * This class represent point on the surface.
 */
public class Point {

    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x the x value
     * @param y the y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distance - return the distance of this point to the other point.
     *
     * @param other - the other point to distance
     * @return the distance between the points
     */
    public double distance(Point other) {
        if (other == null) {
            return -1;
        }
        double x2 = other.getX();
        double y2 = other.getY();
        return Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)));
    }

    /**
     * equals - return true is the points are equal, false otherwise.
     *
     * @param other the other point to equals with
     * @return true if x and y are equals
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return (x == other.getX() && y == other.getY());
    }

    /**
     * get the x value of the point.
     *
     * @return the x value of the point
     */
    public double getX() {
        return this.x;
    }

    /**
     * get the y value of the point.
     *
     * @return the y value of the point
     */
    public double getY() {
        return this.y;
    }
}
