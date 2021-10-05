//ID:206475907

import java.util.List;

/**
 * class that represent a line on a surface.
 */
public class Line {
    static final double EPSILON = 0.0001;
    private Point p1;
    private Point p2;

    /**
     * constructor.
     *
     * @param start first point on the line
     * @param end   last point on the line
     */
    public Line(Point start, Point end) {
        this.p1 = start;
        this.p2 = end;
    }

    /**
     * constructor.
     * @param x x of one point
     * @param y y of one point
     * @param x1 x of second point
     * @param y1 y of second point
     */
    public Line(double x, double y, double x1, double y1) {
        this.p1 = new Point(x, y);
        this.p2 = new Point(x1, y1);
    }


    /**
     * Return the length of the line.
     *
     * @return the length of the line
     */
    public double length() {
        return p1.distance(p2);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return the value of the middle point on the line
     */
    public Point middle() {
        double x = (start().getX() + end().getX()) / 2;
        double y = (start().getY() + end().getY()) / 2;
        return new Point(x, y);
    }


    /**
     * return the first point on the line.
     *
     * @return first point on the line
     */
    public Point start() {
        return p1;
    }


    /**
     * return the last point on the line.
     *
     * @return last point on the line
     */
    public Point end() {
        return p2;
    }

    /**
     * calculate the incline of the line.
     * if the line is parallel to the y axis- return 1 as a default
     *
     * @param point1 first point on the line
     * @param point2 last point on the line
     * @return the incline of the line
     */
    public double incline(Point point1, Point point2) {
        //If the line is parallel to the y axis- return 1 as a default
        if ((point1.getX() - point2.getX()) == 0) {
            return 1;
        }
        return ((point1.getY() - point2.getY()) / (point1.getX() - point2.getX()));
    }

    /**
     * calculate the intersection of the line with y axis.
     *
     * @param point1 first point on the line
     * @param point2 last point on the line
     * @return the cut of the line with axis y
     */
    public double intersectionWithY(Point point1, Point point2) {
        return (point1.getY() - (incline(point1, point2) * point1.getX()));
    }

    /**
     * calculate the intersection point of two lines (this with other line).
     *
     * @param other the other line
     * @return the cut point
     */
    public Point intersectionPoint(Line other) {
        double cutX, cutY;
        //if one line is the continue of the second line
        if ((incline(end(), start()) == incline(other.start(), other.end())) && isIntersectingAndParable(other)) {
            return isIntersectingAndParablePoint(other);
        }
        //this line parallel to y axis
        if ((start().getX() - end().getX() == 0)) {
            cutX = start().getX();
            cutY = ((incline(other.start(), other.end()) * start().getX())
                    + intersectionWithY(other.start(), other.end()));
        //other line parallel to y axis
        } else if (other.start().getX() - other.end().getX() == 0) {
            cutX = other.start().getX();
            cutY = ((incline(start(), end()) * other.start().getX()) + intersectionWithY(start(), end()));
        } else { //other cases
            cutX = (intersectionWithY(start(), end()) - intersectionWithY(other.start(), other.end()))
                    / (incline(other.start(), other.end()) - (incline(start(), end())));
            cutY = ((incline(start(), end()) * intersectionWithY(other.start(), other.end()))
                    - (incline(other.start(), other.end()) * intersectionWithY(start(), end())))
                    / (incline(start(), end()) - incline(other.start(), other.end()));
        }
        return new Point(cutX, cutY);
    }
    /**
     * Checks whether the intersection point is in the two line domain.
     *
     * @param other the other line
     * @return true if is in the two line domain false if not
     */
    public boolean pointIsInDomain(Line other) {
        return intersectionPoint(other).getX() >= Math.min(start().getX(), end().getX()) - EPSILON
                && intersectionPoint(other).getX() >= Math.min(other.start().getX(), other.end().getX()) - EPSILON
                && intersectionPoint(other).getX() <= Math.max(start().getX(), end().getX()) + EPSILON
                && intersectionPoint(other).getX() <= Math.max(other.start().getX(), other.end().getX()) + EPSILON
                && intersectionPoint(other).getY() >= Math.min(start().getY(), end().getY()) - EPSILON
                && intersectionPoint(other).getY() >= Math.min(other.start().getY(), other.end().getY()) - EPSILON
                && intersectionPoint(other).getY() <= Math.max(start().getY(), end().getY()) + EPSILON
                && intersectionPoint(other).getY() <= Math.max(other.start().getY(), other.end().getY()) + EPSILON;
    }

    /**
     * Checks if one line is one point, and if so - returns true if the point is on the other line.
     * If not - return false and the point is not on the other line.
     * @param other the other line
     * @return true if the point is on the other line, false if not.
     */
    public boolean onePointLine(Line other) {
        double x1 = start().getX();
        double y1 = start().getY();
        double x2 = end().getX();
        double y2 = end().getY();
        double otherX1 = other.start().getX();
        double otherY1 = other.start().getY();
        double otherX2 = other.end().getX();
        double otherY2 = other.end().getY();
        // if this line is a point
        if (x1 == x2 && y1 == y2 && pointIsInDomain(other)) {
            return ((incline(other.start(), other.end()) * otherX1)
                    + intersectionWithY(other.start(), other.end()) == otherY1);
        }
        //if other line is a point
        if (otherX1 == otherX2 && otherY1 == otherY2 && pointIsInDomain(other)) {
            return ((incline(start(), end()) * x1)
                    + intersectionWithY(start(), end()) == y1);
        //if the two lines are not a point
        } else {
            return false;
        }
    }

    /**
     * This function is only used if one line is the continue of the second line.
     * This function return the interaction point.
     *
     * @param other the other line
     * @return the interaction point
     */
    public Point isIntersectingAndParablePoint(Line other) {
        double x;
        double y;
        //find the Intersecting Parable Point if exists
        if ((start().getX() == other.start().getX()) && (start().getY() == other.start().getY())) {
            x = start().getX();
            y = start().getY();
        } else if ((start().getX() == other.end().getX()) && (start().getY() == other.end().getY())) {
            x = start().getX();
            y = start().getY();
        } else if ((end().getX() == other.start().getX()) && (end().getY() == other.start().getY())) {
            x = end().getX();
            y = end().getY();
        } else {
            x = end().getX();
            y = end().getY();
        }
        return new Point(x, y);
    }

    /**
     * This function checks if one line is a continuation of the other
     * and has exactly one interaction point between them.
     *
     * @param other the other line
     * @return true if one line is a continuation of the other false if not
     */
    public boolean isIntersectingAndParable(Line other) {
        double maxX1 = Math.max(start().getX(), end().getX());
        double maxY1 = Math.max(start().getY(), end().getY());
        double maxX2 = Math.max(other.start().getX(), other.end().getX());
        double maxY2 = Math.max(other.start().getY(), other.end().getY());
        double minX1 = Math.min(start().getX(), end().getX());
        double minY1 = Math.min(start().getY(), end().getY());
        double minX2 = Math.min(other.start().getX(), other.end().getX());
        double minY2 = Math.min(other.start().getY(), other.end().getY());
        //if the lines have positive incline (this is first)
        if ((incline(p1, p2) >= 0) && (maxX1 == minX2) && (maxY1 == minY2)) {
            return true;
        }
        //if the lines have positive incline (other is first)
        if ((incline(p1, p2) >= 0) && (maxX2 == minX1) && (maxY2 == minY1)) {
            return true;
        }
        //if the lines have negative incline (this is first)
        if ((incline(p1, p2) <= 0) && (maxX1 == minX2) && (minY1 == maxY2)) {
            return true;
        }
        //if the lines have negative incline (other is first)
        return (incline(p1, p2) <= 0) && (maxX2 == minX1) && (minY2 == maxY1);
    }
    /**
     * checks if the lines intersect.
     *
     * @param other the other line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        //if the two line are equal
        if (this.equals(other)) {
            return false;
        }
        //if one of the line is one point
        if (onePointLine(other)) {
            return true;
        }
        //if one line is a continuation of the other and has exactly one cut point between them
        if ((incline(end(), start()) == incline(other.start(), other.end())) && isIntersectingAndParable(other)) {
            return true;
        }
        //If the lines are parallel,are not parallel to y axis ,and one line isn't a continuation of the other
        if (incline(end(), start()) == incline(other.start(), other.end()) && start().getX() != end().getX()
             && other.start().getX() != other.end().getX()) {
            return false;
        }
        //if the lines is parallel to y axis
        if ((p1.getX() - p2.getX() == 0) && (other.start().getX() - other.end().getX() == 0)) {
            return false;
        }
        //if there is interaction point
        return pointIsInDomain(other);
    }

    /**
     * checks the intersection point if the lines intersect.
     *
     * @param other the other line
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (isIntersecting(other)) {
            return (intersectionPoint(other));
        } else {
            return null;
        }
    }

    /**
     * checks if the two lines are equal.
     *
     * @param other the other line
     * @return return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return (other.start().equals(start()) && other.end().equals(end()));
    }

    /**
     * This function returns the closest intersection point between the rectangle and the line.
     * @param rect the rectangle
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line line = new Line(start(), end());
        List<Point>  intersectionPoints =  rect.intersectionPoints(line);
        //if there are not intersection points
        if (intersectionPoints == null) {
            return null;
        } else {
            //check what is the closest intersection point to the start of the line.
            int i = 0;
            Point closePoint = intersectionPoints.get(i);
            double minDistance = start().distance(intersectionPoints.get(i));
            while (++i < rect.intersectionPoints(line).size()) {
                double distance = start().distance(intersectionPoints.get(i));
                minDistance = Math.min(minDistance, distance);
                if (minDistance >= distance) {
                    closePoint = rect.intersectionPoints(line).get(i);
                }
            }
            return closePoint;
        }
    }
}


