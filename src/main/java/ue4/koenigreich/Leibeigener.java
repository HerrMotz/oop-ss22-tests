package ue4.koenigreich;

public class Leibeigener extends Bauer {
    @Override
    int zuVersteuerndesEinkommen() {
        /*
        5. Bei Leibeigenen sind 12 Gulden des Jahreseinkommens (einkommen) steuerfrei
        D.h. es gehen vom zu versteuernden Einkommen 12 Gulden ab.
         */
        return einkommen - 12;
    }
}
