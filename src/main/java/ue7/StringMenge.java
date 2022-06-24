package ue7;

public interface StringMenge {

    /**
     * Fügt den übergebenen String der Menge hinzu, wenn er noch nicht darin vorkommt
     * @param s der hinzuzufügende String
     */
    void add(String s);

    /**
     * Entfernt den übergebenen String aus der Menge, wenn er vorhanden ist
     * @param s der zu entfernende String
     */
    void remove(String s);

    /**
     * Gibt true zurück, wenn der übergebene String in der Menge ist, ansonsten false
     * @param s der zu suchende String
     * @return true wenn gefunden, false wenn nicht gefunden
     */
    boolean contains(String s);

    /**
     * Gibt true zurück, wenn die Menge leer ist
     * @return true wenn leer, sonst false
     */
    boolean isEmpty();

    /**
     * Liefert die Anzahl der Elemente der Menge zurück
     * @return Anzahl der Elemente der Menge
     */
    int getSize();


    /**
     * Liefert ein String-Array zurück, welches alle Elemente der Menge enthält
     * @return Array mit allen Elementen der Menge
     */
    String[] getElements();

    /**
     * Addiert die Länge aller Strings der Menge auf und gibt diese zurück
     * @return Länge aller Strings aufsummiert
     */
    int getCharCount();

    /**
     * Gibt die Elemente der Menge auf dem Bildschirm aus
     */
    void print();

}
