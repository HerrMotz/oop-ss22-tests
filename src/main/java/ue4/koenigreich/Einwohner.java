package ue4.koenigreich;

/**
 * Oberklasse für alle sozialen Schichten.
 *
 * Der Einwohner hat ein Jahreseinkommen in Höhe
 * von "einkommen" in Gulden.
 *
 * Die Methoden zuVersteuerndesEinkommen() und steuer()
 * sollen für den koenigreich.Einwohner die Werte nach folgenden
 * Vorschriften liefern
 *
 * 1. Sofern dieses Gesetz nichts Gegenteiliges aussagt
 *    hat jeder koenigreich.Einwohner sein gesamtes Jahreseinkommen
 *    zu versteuern.
 *
 * 2. Jeder koenigreich.Einwohner hat 10% seines zu versteuernden
 *    Einkommens als Steuer zu entrichten. Der Steuer
 *    betrag wird auf ganze Gulden abgerundet, jedoch
 *    beträgt die Steuer mindestens einen Gulden.
 *
 * 3. Der König zahl auch für sein steuerpflichtiges
 *    Einkommen keine Steuern.
 *
 * 4. Für Angehörige des Adels beträgt die Steuer
 *    mindestens 20 Gulden.
 *
 * 5. Bei Leibeigenen sind 12 Gulden des
 *    Jahreseinkommens steuerfrei.
 *
 * die zweite Regel darf nur an einer Stelle implementiert
 * sein.
 *
 * Quelle: Aufgabenstellung vom 21. Mai 21, Prof. Dr. Wolfram Amme
 *                                          Dr. Sven Sickert
 *                                          M.Sc.André Schäfer
 *
 * @author Daniel Motz
 * @version 1.0
 */

public class Einwohner {
    /*
     * Im Widerspruch zum Klassendiagramm habe ich hier
     * für einkommen protected genommen.
     * setEinkommen würde andernfalls auch Sinn ergeben
     * aber wir sollen auch Kapselung verwenden.
     *
     * private geht hier nicht, weil die Vererbung sonst
     * nicht funktionieren würde
     */
    protected int einkommen;

    /*
     * Grundregel 2, Steuersatz
     */
    protected float steuersatz = 0.1f;

    int zuVersteuerndesEinkommen() {
        /*
        1. Sofern dieses Gesetz nichts Gegenteiliges aussagt, hat jeder koenigreich.Einwohner sein
        gesamtes Jahreseinkommen zu versteuern: einkommen
         */
        return einkommen;
    }

    public int steuer() {
        /*
        Steuerbetrag wird auf ganze Gulden abgerundet: Math.floor
        Steuer beträgt mindestens einen Gulden: Math.max(x, 1)
        Jeder koenigreich.Einwohner hat 10 % seines zu verst. Einkommens als Steuer zu entrichten: * steuersatz
         */
        return Math.max((int)Math.floor((zuVersteuerndesEinkommen() * steuersatz)), 1);
    }

    public void setEinkommen(int einkommen) {
        this.einkommen = einkommen;
    }
}
