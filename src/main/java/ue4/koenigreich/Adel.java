package ue4.koenigreich;

public class Adel extends Einwohner {
    @Override
    public int steuer() {
        /*
        4. Für Angehörige des Adels beträgt die Steuer mindestens 20 Gulden
         */
        return Math.max(super.steuer(), 20);
    }
}
