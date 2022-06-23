package ue6.figure;

public class Rectangle extends Figure implements MobileObjekt {
    // Task Sentence 1
    private Float h;
    private Float w;

    /**
     * Task Sentence 2.
     * Constructor, which initialises the values height and width of the rectangle with 0f.
     */
    Rectangle() {
        super();
        this.h = 0f;
        this.w = 0f;
    }

    /**
     * Task Sentence 3.
     * Create new Rectangle with x- and y-coordinate, height and width
     * @param xCoordinate The top left x-Coordinate of the rectangle
     * @param yCoordinate The top left y-Coordinate of the rectangle
     * @param h height of the rectangle. may not be negative
     * @param w width of the rectangle. may not be negative
     */
    public Rectangle(Float xCoordinate, Float yCoordinate, Float h, Float w) {
        // Sentence 3. Uses parent constructor
        super(xCoordinate, yCoordinate);
        // Sentence 3. Sets height and width
        if (h < 0 || w < 0) {
            throw new IllegalArgumentException("Width and Height must be greater or equal to 0.");
        }
        this.h = h;
        this.w = w;
    }

    /**
     * Return the height of the rectangle
     * @return The rectangle's height
     */
    public Float getH() {
        return h;
    }

    /**
     * Return the width of the rectangle
     * @return The rectangle's width
     */
    public Float getW() {
        return w;
    }

    private Boolean alignedRectangles(Float x1, Float y1, Float h1, Float w1, Float x2, Float y2, Float h2, Float w2) {
        if ((x1 < x2 && x2 < x1 + w1) || (x2 < x1 && x1 < x2 + w2) || (x1.equals(x2) && w1.equals(w2))) {
            return (y1 + h1 == y2) || (y2 + h2 == y1);
        }
        return false;
    }


    /**
     * Compares this rectangle to the given rectangle
     * @param r The rectangle to compare with
     * @return in which relation the rectangles are to each other. instantiating compareState also prints to console by default.
     */
    public compareState compare(Rectangle r) {
        Float x1 = getX();
        Float y1 = getY();
        Float h1 = getH();
        Float w1 = getW();

        Float x2 = r.getX();
        Float y2 = r.getY();
        Float h2 = r.getH();
        Float w2 = r.getW();

        // SAME, the rectangles are identical
        if (x1.equals(x2) && y1.equals(y2) && w1.equals(w2) && h1.equals(h2))
            return new compareState(compareState.SAME);

        // CONTAINED, all points of one rectangle are contained by the other
        if ((x1 <= x2 && y1 <= y2 && x1 + w1 >= x2 + w2 && y1 + h1 >= y2 + h2) ||
            (x2 <= x1 && y2 <= y1 && x2 + w2 >= x1 + w1 && y2 + h2 >= y1 + h1))
            return new compareState(compareState.CONTAINED);

        // DISJOINT, the intersection of the rectangles is empty
        if (x1 > x2 + w2 || x2 > x1 + w1 || y1 > y2 + h2 || y2 > y1 + h1)
            return new compareState(compareState.DISJOINT);

        // ALIGNED, the intersection of the rectangles forms a line
        if (alignedRectangles(x1, y1, h1, w1, x2, y2, h2, w2) ||
            alignedRectangles(y1, x1, w1, h1, y2, x2, w2, h2))
            return new compareState(compareState.ALIGNED);

        // default
        return new compareState((char) 0);
    }

    /**
     * Task Sentence 6.
     * Moves a rectangle absolute to the coordinate system
     *
     * @param x x-Coordinate of rectangle
     * @param y y-Coordinate of rectangle
     * @return whether the operation succeeded
     */
    @Override
    public Boolean move(Float x, Float y) {
        this.x = x;
        this.y = y;
        return true;
    }

    /**
     * Helper function to verify that height and width are numbers and not special values
     * @return whether height and width are not infinite and not NaN. Is true when neither width nor height are NaN or infinite
     */
    private Boolean verifyHeightAndWidthNotInfOrNan() {
        return !w.isNaN() && !w.isInfinite() && !h.isNaN() && !h.isInfinite();
    }

    /**
     * Task Sentence 6.
     * Stretch the rectangle's current size by the given factor
     * DOES NOT THROW AN ERROR if stretch factor is smaller than 1, just returns false.
     * DOES NOT THROW AN ERROR if height or width are inf or NaN.
     *
     * @param factor stretch factor, must be greater or equal to 1
     * @return whether the operation succeeded
     */
    @Override
    public Boolean increase(Float factor) {
        // Rechteck Formel A = a*b
        // A*factor = a*b*factor
        // <-> A*factor = (1/2a*b)*2factor
        // <-> A*factor = (a*(factor/2)*b*(factor/2))
        if (verifyHeightAndWidthNotInfOrNan() && factor >= 1) {
            w *= factor;
            h *= factor;
            return true;
        }
        return false;
    }

    /**
     * Task Sentence 6.
     * Squeeze the rectangle's current size by the given factor
     * DOES NOT THROW AN ERROR if stretch factor is not in (0;1], just returns false.
     * DOES NOT THROW AN ERROR if height or width are inf or NaN.
     *
     * @param factor squeeze factor, must be greater than 0 and smaller or equal to 1
     * @return whether the operation succeeded
     */
    @Override
    public Boolean decrease(Float factor) {
        if (verifyHeightAndWidthNotInfOrNan() && 0 < factor && factor <= 1) {
            w *= factor;
            h *= factor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", height=" + h +
                ", width=" + w +
                '}';
    }
}
