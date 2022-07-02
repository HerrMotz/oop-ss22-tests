package ue8.tetrapack;

public class Tetrapack extends Behaeltnis {
    private double hoehe;
    private double laenge;
    private double breite;

    public Tetrapack(double hoehe, double laenge, double breite) {
        this.hoehe = hoehe;
        this.laenge = laenge;
        this.breite = breite;
    }

    @Override
    void println() {
        System.out.println(this);
    }

    @Override
    double volumen() {
        return hoehe * laenge * breite;
    }

    @Override
    public String toString() {
        return "Tetrapack mit Kanten " +
                String.format("%.2f", hoehe) +
                " LE, " + String.format("%.2f", breite) +
                " LE, " + String.format("%.2f", laenge) +
                " LE";
    }
}
