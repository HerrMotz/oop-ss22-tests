package ue5;

public class PickUp extends Auto {
    /**
     * Fassungsvermögen f
     */
    protected int f;
    protected int ladung;

    /**
     * Erzeugt PickUp mit Kennzeichen und Fassungsvermögen
     * @param kennzeichen Das Kennzeichen des Fahrzeugs
     * @param fassungsVermoegen Wie viel die Ladefläche des PickUps laden kann
     */
    PickUp(String kennzeichen, int fassungsVermoegen) {
        super(kennzeichen, true);
        f = fassungsVermoegen;
    }


    /**
     * Erzeugt PickUp mit Standardkennzeichen und Fassungsvermögen
     * @param fassungsVermoegen Wie viel die Ladefläche des PickUps laden kann
     */
    PickUp(int fassungsVermoegen) {
        super(true);
        f = fassungsVermoegen;
    }

    int getLadung() {
        return ladung;
    }

    boolean beladen(int ladung) {
        if (ladung < 0) {
            return false;
        }

        if (this.ladung + ladung <= f) {
            System.out.println("Der PickUp wurde mit " + ladung + " beladen.");
            this.ladung += ladung;
            return true;
        }
        return false;
    }

    void entladen(int ladung) {
        // Diese Probe steht nicht in der Aufgabenstellung,
        // aber mir wurde schon eine Party mit 0 Personen bemängelt.

        ladung = Math.abs(ladung); // Sonst könnte man mit negativer Eingabe den PickUp über die Kapazität hinaus beladen.
        if (this.ladung - ladung >= 0) { // Sonst könnte man das Fahrzeug auf einen negativen Ladestand entladen
            System.out.println("Der Inhalt der Ladefläche wurde um " + ladung + " verringert.");
            this.ladung -= ladung;
        } else { // entladen mit genau der Ladung
            entladen();
        }
    }

    void entladen() {
        entladen(getLadung());
    }

    void bereiteWaschenVor() {
        super.bereiteWaschenVor();
        entladen();
    }

    @Override
    public String toString() {
        return "PickUp{" +
                "kennzeichen=" + kennzeichen +
                ", kilometerstand=" + kilometerstand +
                ", sitzplaetze=" + sitzplaetze +
                ", antenneAusgefahren=" + antenneAusgefahren +
                ", f=" + f +
                ", ladung=" + ladung +
                '}';
    }
}

