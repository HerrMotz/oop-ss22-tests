package ue5;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auto {
    protected Kennzeichen kennzeichen;
    protected int kilometerstand;
    protected int sitzplaetze = 5;
    protected Boolean antenneAusgefahren = false;

    static class Kennzeichen {
        private String verwaltungsBezirk;
        private String erkennungsNummerBst;
        private String erkennungsNummer;

        /**
         * Erstellt deutsche Euro-Kennzeichen und prüft ihre formelle Validität
         * @param kennzeichen Das Kennzeichen im Format: Unterscheidungszeichen Minus Erkennungsnummer
         * verwaltungsBezirk Kürzel des Verwaltungsbezirks in dem das Auto zugelassen ist (ist nicht mehr zwingend das Unterscheidungszeichen vom Verwaltungsbezirk)
         * erkennungsNummerBst Buchstabenteil der Erkennungsnummer des Kennzeichens
         * erkennungsNummer Nummernteil der Erkennungsnummer des Kennzeichens (könnte eigentlich Integer sein, aber Aufgabenstellung erfordert, dass bestimmte Anzahl an führenden Nullen möglich sein sollen, J-AA 01)
         */
        Kennzeichen(String kennzeichen) {
            kennzeichen = kennzeichen.toUpperCase(Locale.ROOT);
            Matcher matcher = Pattern.compile("(\\w{1,3})-(\\w{1,2}) (\\d{1,4})")
                                     .matcher(kennzeichen);
            if (!matcher.find()) {
                throw new IllegalArgumentException("Eingabe ist kein gültiges Kennzeichen");
            }

            verwaltungsBezirk = matcher.group(1);
            erkennungsNummerBst = matcher.group(2);
            erkennungsNummer = matcher.group(3);
        }

        private Kennzeichen(String verwaltungsBezirk, String erkennungsNummerBst, String erkennungsNummer) {
            this.verwaltungsBezirk = verwaltungsBezirk;
            this.erkennungsNummerBst = erkennungsNummerBst;
            this.erkennungsNummer = erkennungsNummer;
        }

        @Override
        public String toString() {
            return  verwaltungsBezirk + '-' + erkennungsNummerBst + ' ' + erkennungsNummer;
        }
    }

    /**
     * Erzeugt Autos mit Kennzeichen und 2 oder 5 Sitzplätzen
     * @param kennzeichen Kennzeichen des Fahrzeugs
     * @param zweisitzer Ob das Auto ein Zweisitzer ist oder nicht
     */
    Auto (String kennzeichen, Boolean zweisitzer) {
        if (zweisitzer) {
            sitzplaetze = 2;
        }
        this.kennzeichen = new Kennzeichen(kennzeichen);
    }


    /**
     * Erzeugt Auto mit Standardkennzeichen J-AA 01 und 2 oder 5 Sitzplätzen
     * @param zweisitzer Ob das Auto ein Zweisitzer ist oder nicht
     */
    Auto (Boolean zweisitzer) {
        if (zweisitzer) {
            sitzplaetze = 2;
        }
        this.kennzeichen = new Kennzeichen("J", "AA", "01");
    }

    /**
     * Erzeugt Auto mit Kennzeichen und 5 Sitzplätzen
     * @param kennzeichen Das Kennzeichen des Autos
     */
    Auto (String kennzeichen) {
        this.kennzeichen = new Kennzeichen(kennzeichen);
    }

    /**
     * Erzeugt Auto mit Standardkennzeichen J-AA 01 und 5 Sitzplätzen
     */
    Auto () {
        this.kennzeichen = new Kennzeichen("J", "AA", "01");
    }

    String getKennzeichen() {
        return kennzeichen.toString();
    }

    int getKilometerstand() {
        return kilometerstand;
    }

    int getSitzplaetze() {
        return sitzplaetze;
    }

    void fahre(int kilometer) {
        System.out.println("Das Auto hat eine Strecke " + kilometer + " km zurückgelegt");
        kilometerstand += kilometer;
    }

    void fahreAntenneAus() {
        System.out.println("Die Antenne wird ausgefahren.");
        antenneAusgefahren = true;
    }

    void fahreAntenneEin() {
        System.out.println("Die Antenne wird eingefahren");
        antenneAusgefahren = false;
    }

    void bereiteWaschenVor() {
        fahreAntenneEin();
    }

    void wasche() {
        bereiteWaschenVor();
        System.out.println("Das Auto wird gewaschen");
    }

    @Override
    public String toString() {
        return "Auto{" +
                "kennzeichen=" + kennzeichen +
                ", kilometerstand=" + kilometerstand +
                ", sitzplaetze=" + sitzplaetze +
                ", antenneAusgefahren=" + antenneAusgefahren +
                '}';
    }
}
