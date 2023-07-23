package utilities;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 */
public class Point {
    /**
     * The Point class represents a point in two-dimensional space.
     */
    private static final int MAX_X = 1000000;
    private static final int MIN_X = 0;
    private static final int MAX_Y = 2000;
    private static final int MIN_Y = 0;
    private double x;
    private double y;
    /**
     Constructs and initializes a point with the specified x and y coordinates.
     @param x the x-coordinate of the point
     @param y the y-coordinate of the point
     */
    public Point(double x, double y) {
        if (!(this.setX(x))) {
            this.x = 0;
        }
        if (!(this.setY(y))) {
            this.y = 0;
        }

    }
    /**
     * Constructs and initializes a point at the origin (0,0).
     */
    public Point() {
        this(0.0, 0.0);
    }
    /**
     * Copy constructor
     */
    public Point(Point other) {
        if (other == null) {
            other = new Point(0, 0);
        }
        this.setX(other.x);
        this.setY(other.y);
    }
    /**
     * Returns the x-coordinate of the point.
     */
    public double getX() {
        return x;
    }
    /**
     * Sets the x-coordinate of the point to the specified value.
     * @param x
     * @return True if succeed
     */
    public boolean setX(double x) {
        if (x > MAX_X || x < MIN_X) {
            return false;
        }
        this.x = x;
        return true;

    }
    /**
     * Returns the y-coordinate of the point.
     */
    public double getY() {
        return y;
    }
    /**
     * Sets the y-coordinate of the point to the specified value.
     * @param y
     * @return True if succeed
     */
    public boolean setY(double y) {
        if (y > MAX_Y || y < MIN_Y) {
            return false;
        }
        this.y = y;
        return true;
    }
    /**
     * Returns a string representation of the point in the format "(x,y)".
     * @return a string representation of the point
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
