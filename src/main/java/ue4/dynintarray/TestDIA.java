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

    @Test
    void testVonSchaefer() {
        for (int i = 0; i < 2; i++) {
            DynIntArray da = null;
            if (i == 0) { da = new DIAarray(); }
            else if (i == 1) { da = new DIAlist(); }
            da.add(4);
            da.add(8);
            da.add(10);
            da.add(1);

            // erste Ausgabe
            da.print();
            assertEquals(4, da.getElementAt(0));
            assertEquals(8, da.getElementAt(1));
            assertEquals(10, da.getElementAt(2));
            assertEquals(1, da.getElementAt(3));

            da.setElementAt(0, 0);
            da.add(5);
            da.setElementAt(2, da.getElementAt(2) + 10);

            // zweite Ausgabe
            da.print();
            assertEquals(0, da.getElementAt(0));
            assertEquals(8, da.getElementAt(1));
            assertEquals(20, da.getElementAt(2));
            assertEquals(1, da.getElementAt(3));
            assertEquals(5, da.getElementAt(4));
        }
    }
}
