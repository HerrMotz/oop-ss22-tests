package ue8.graphobj;

public class Rectangle implements ResizeableGO, MoveableGO {
    /*
     * THIS IS REQUIRED FOR TESTING
     */
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getH() {
        return h;
    }

    public float getW() {
        return w;
    }
    /*
     * END REQUIRED FOR TESTING
     */

    // x and y coordinates of rectangle
    private float x;
    private float y;

    private float w;
    private float h;

    /**
     * Creates Rectangles with width and height greater than zero.
     * @param x x-Coordinate of the rectangle
     * @param y y-Coordinate of the rectangle
     * @param w rectangle's width. Must be bigger than zero.
     * @param h rectangle's height. Must be bigger than zero.
     */
    public Rectangle(float x, float y, float w, float h) {
        if (w <= 0 || h <= 0) throw new IllegalArgumentException("Die Breite und Höhe dürfen nicht kleiner gleich Null sein.");
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void setColor(int x) {
        System.out.println(this);
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public void hide() {
        System.out.println(this);
    }

    @Override
    public void move(float dx, float dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    @Override
    public void resize(float factor) {
        this.w *= factor;
        this.h *= factor;
    }

    @Override
    public String toString() {
        return "task1.Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}
