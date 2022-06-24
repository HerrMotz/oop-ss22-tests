package ue7;

import java.util.LinkedList;

public class StringMengeImpl extends AbstrakteStringMenge {
    LinkedList<String> list = new LinkedList<>();

    /**
     * Fügt den übergebenen String der Menge hinzu, wenn er noch nicht darin vorkommt
     *
     * @param s der hinzuzufügende String
     */
    @Override
    public void add(String s) {
        if (!contains(s))
            list.add(s);
    }

    /**
     * Entfernt den übergebenen String aus der Menge, wenn er vorhanden ist
     *
     * @param s der zu entfernende String
     */
    @Override
    public void remove(String s) {
        list.remove(s);
    }

    /**
     * Gibt true zurück, wenn der übergebene String in der Menge ist, ansonsten false
     *
     * @param s der zu suchende String
     * @return true wenn gefunden, false wenn nicht gefunden
     */
    @Override
    public boolean contains(String s) {
        return list.contains(s);
    }

    /**
     * Liefert die Anzahl der Elemente der Menge zurück
     *
     * @return Anzahl der Elemente der Menge
     */
    @Override
    public int getSize() {
        return list.size();
    }

    /**
     * Liefert ein String-Array zurück, welches alle Elemente der Menge enthält
     * @return Array mit allen Elementen der Menge
     */
    @Override
    public String[] getElements() {
        return list.toArray(new String[0]);
    }
}
