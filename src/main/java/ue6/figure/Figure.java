package ue6.figure;

abstract class Figure {
    // Satz 1: Zugriff auf Punkte soll von außerhalb der Klasse nicht möglich sein
    // kann nicht private sein, weil sonst Rectangle nicht den Konstruktor der Oberklasse aufrufen kann
    // daher protected x,y
    protected Float x;
    protected Float y;

    /**
     * Standardkonstruktor (Satz 2)
     */
    Figure() {
        x = 0f;
        y = 0f;
    }

    /**
     * Überladener Konstruktur, Satz 3
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    Figure(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gibt die x-Koordinate der Figur zurück, Satz 4
     * @return x-Koordinate der Figur
     */
    public Float getX() {
        return x;
    }

    /**
     * Gibt die y-Koordinate der Figur zurück, Satz 4
     * @return y-Koordinate der Figur
     */
    public Float getY() {
        return y;
    }

    /**
     * Gibt die die x- und y-Koordinate des als String zurück
     * @return String-Representation der Figure
     */
    @Override
    public String toString() {
        return "Figure{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Prints the x- and y-coordinate on screen, Satz 5
     */
    public void print() {
        System.out.println(this);
    }
}
