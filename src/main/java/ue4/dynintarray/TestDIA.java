package ue4.dynintarray;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestDIA {
    static Random random;

    static int zufallsZahl() {
        return random.nextInt();
    }

    @BeforeAll
    static void init() {
        random = new Random();
    }

    void testVonSchaefer(DynIntArray dynIntArray) {
        dynIntArray.add(4);
        dynIntArray.add(8);
        dynIntArray.add(10);
        dynIntArray.add(1);

        System.out.println("\n\nErste Ausgabe:");

        // erste Ausgabe
        dynIntArray.print();
        assertEquals(4, dynIntArray.getElementAt(0));
        assertEquals(8, dynIntArray.getElementAt(1));
        assertEquals(10, dynIntArray.getElementAt(2));
        assertEquals(1, dynIntArray.getElementAt(3));

        dynIntArray.setElementAt(0, 0);
        dynIntArray.add(5);
        dynIntArray.setElementAt(2, dynIntArray.getElementAt(2) + 10);

        System.out.println("\n\nZweite Ausgabe:");

        // zweite Ausgabe
        dynIntArray.print();
        assertEquals(0, dynIntArray.getElementAt(0));
        assertEquals(8, dynIntArray.getElementAt(1));
        assertEquals(20, dynIntArray.getElementAt(2));
        assertEquals(1, dynIntArray.getElementAt(3));
        assertEquals(5, dynIntArray.getElementAt(4));
    }

    @Test
    void testArray() {
        testVonSchaefer(new DIAarray());
    }

    @Test
    void testList() {
        testVonSchaefer(new DIAlist());
    }
}
