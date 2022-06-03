package ue4.dynintarray;

import java.util.Arrays;

/**
 * Implementation eines dynamischen Arrays in einem statischen Array.
 * Kopiert das Array bei Knappheit in ein größeres.
 * Löschen ist nicht implementiert, weil es nicht gefordert war.
 *
 * @author Daniel Motz
 * @version 1.0
 */

class DIAarray extends DynIntArray {
    private int[] data = new int[0];
    void add(int e) {
        data = Arrays.copyOf(data, data.length+1);
        data[data.length-1] = e;
    }
    void setElementAt(int i, int e)
    {
        if (0 <= i && i < data.length) {
            data[i] = e;
        }
    }
    int getElementAt(int i) {
        if (0 <= i && i < data.length) {
            return data[i];
        }
        return 0;
    }
    int getElementCount() {
        return data.length;
    }
    void print() {
        System.out.println(Arrays.toString(data));
    }
}
