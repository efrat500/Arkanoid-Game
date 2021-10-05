//ID:206475907

import java.util.ArrayList;
import java.util.List;

/**
 * This class create a rectangle in the surface.
 */
public class Rectangle {

    private Point point;
    private int width;
    private int height;

    /**
     * constructor.
     * @param upperLeft the left vertex from the top of the rectangle.
     * @param width the rectangle width.
     * @param height the rectangle height.
     */
    public Rectangle(Point upperLeft, int width, int height) {
        this.point = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * constructor.
     * @param upperLeft the left vertex from the top of the rectangle.
     * @param width the rectangle width.
     * @param height the rectangle height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this(upperLeft, (int) width, (int) height);
    }

    /**
     *This function returns a (possibly empty) List of intersection points with the specified line.
     * @param line the line that interaction or not interaction with the rectangle
     * @return a List of intersection points with the specified line, or null if there are not interaction point.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> listOfPoint = new ArrayList<>();
        //Divide the rectangle into four sides
        Point p1 = new Point(point.getX(), point.getY() + height);
        Point p2 = new Point(point.getX() + width, point.getY());
        Point p3 = new Point(point.getX() + width, point.getY() + height);
        Line l1 = new Line(point, p2);
        Line l2 = new Line(point, p1);
        Line l3 = new Line(p2, p3);
        Line l4 = new Line(p1, p3);
        //If the first line of the rectangle has an interaction point with the line
        if (l1.isIntersecting(line)) {
            Point listOfPoint1 = l1.intersectionWith(line);
            listOfPoint.add(listOfPoint1);
            //If the second line of the rectangle has an interaction point with the line
        }
        if (l2.isIntersecting(line)) {
            Point listOfPoint2 = l2.intersectionWith(line);
            listOfPoint.add(listOfPoint2);
            //If the third line of the rectangle has an interactions point with the line
        }
        if (l3.isIntersecting(line)) {
            Point listOfPoint3 = l3.intersectionWith(line);
            listOfPoint.add(listOfPoint3);
            //If the fourth line of the rectangle has an interactions point with the line
        }
        if (l4.isIntersecting(line)) {
            Point listOfPoint4 = l4.intersectionWith(line);
            listOfPoint.add(listOfPoint4);
            //if there are not interaction point
        }
        if (listOfPoint.size() == 0) {
            return null;
        } else {
            return listOfPoint;
        }
    }

    /**
     * Return the width of the rectangle.
     * @return the rectangle width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     * @return the rectangle height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.point;
    }
}
