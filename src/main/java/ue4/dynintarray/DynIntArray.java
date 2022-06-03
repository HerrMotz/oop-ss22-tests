package ue4.dynintarray;

/**
 * Die Klasse DynIntArray soll eine dynamische Reihung darstellen (Index beginnt bei 0).
 * Man kann neue Elemente anhängen (die Reihung wächst), Elemente von einer Indexposition
 * aus lesen und schreiben (existiert die Position nicht, wird 0 zurückgegeben
 * beziehungsweise nichts getan), sich die Elementzahl zurückgegeben lassen und die
 * Reihung anzeigen.
 *
 * Erstellen Sie zwei Unterklassen von DynIntArray, die alle fünf angegebenen Methoden
 * überschreiben. Die eine Klasse soll DIAarray heißen und eine dynamische Reihung mit
 * Hilfe einer Reihung (Array) simulieren. Die andere Klasse soll DIAlist heißen und die
 * dynamische Reihung mit Hilfe einer einfachverketteten Liste modellieren. Beie Klassen
 * müssen so ausgelegt sein, dass sie für beliebig große Daten verwendet werden können
 * Implementieren Sie die zugrundeliegenden Algorithmen selbst, verwenden Sie keine
 * vordefinierten Klassen wie LinkedList und ArrayList.
 *
 * Quelle: Aufgabenstellung vom 21. Mai 21, Prof. Dr. Wolfram Amme
 *                                          Dr. Sven Sickert
 *                                          M.Sc.André Schäfer
 *
 * @author Daniel Motz
 * @version 1.0
 */

class DynIntArray {
    void add(int e) { }
    void setElementAt(int i, int e) { }
    int getElementAt(int i) { return 0; }
    int getElementCount() { return 0; }
    void print() {}
}
