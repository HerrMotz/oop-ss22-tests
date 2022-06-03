package ue4.koenigreich;

/**
 * In einem gesellschaftlich etwas unterentwickelten
 * Land soll das Finanz- und Steuerwesen auf EDV
 * umgestellt werden. Die verschiedenen
 * Bevölkerungsgruppen sind in den Klassen modelliert.
 *
 * Quelle: Aufgabenstellung vom 21. Mai 21, Prof. Dr. Wolfram Amme
 *                                          Dr. Sven Sickert
 *                                          M.Sc.André Schäfer
 *
 * @author Daniel Motz
 * @version 1.0
 */

public class Main {
    /**
     * Demonstrationsprogramm.
     *
     * @param args Kommandozeilenparameter
     */
    public static void main (String[] args) {
        // siehe auch src/test/java/TaskOneRules
        // das hier ist mehr zur Demo

        Leibeigener leibeigener = new Leibeigener();
        leibeigener.setEinkommen(12);
        System.out.println(leibeigener.steuer());

        Adel adel = new Adel();
        adel.setEinkommen(0);
        // koenigreich.Adel muss auch ohne Einkommen steuern zahlen
        System.out.println(adel.steuer());

        Koenig koenig = new Koenig();
        koenig.setEinkommen(-20);
        System.out.println(koenig.steuer());
    }
}