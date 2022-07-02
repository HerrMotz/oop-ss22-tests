package ue8.tetrapack;

public class Dose extends Behaeltnis {
    private double hoehe;
    private double radius;

    public Dose(double radius, double hoehe) {
        this.hoehe = hoehe;
        this.radius = radius;
    }

    @Override
    void println() {
        System.out.println(this);
    }

    private double flaeche() {
        return Math.PI * radius * radius;
    }

    @Override
    double volumen() {
        return flaeche() * hoehe;
    }

    @Override
    public String toString() {
        return "Dose mit Fläche " +
                String.format("%.2f", flaeche()) +
                " FE und Höhe " + String.format("%.2f", hoehe) +
                " LE";
    }
}
