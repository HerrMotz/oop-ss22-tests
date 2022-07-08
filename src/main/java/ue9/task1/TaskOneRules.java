package ue9.task1;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TaskOneRules {
    static Random random = new Random();
    static int randomIterations = 1000;
    static int positiveRandom() {
        return Math.abs(random.nextInt(100)) + 1;
    }
    static int wholeRandom() {
        return positiveRandom() * ((positiveRandom() < (positiveRandom()/2)) ? 1 : -1);
    }

    // Helper instances
    ContainsZeroAction containsZeroAction = new ContainsZeroAction();
    ListChecker listChecker = new ListChecker();

    @Test
    void testZeroNonInt() {
        List list = new List();

        list.traverseAndApply(containsZeroAction);
        assertFalse(containsZeroAction.getContainsZero());

        list.add(0f);

        list.traverseAndApply(containsZeroAction);
        assertFalse(containsZeroAction.getContainsZero());

        list.add(1);

        list.traverseAndApply(containsZeroAction);
        assertTrue(containsZeroAction.getContainsZero());
    }

    @Test
    void testZeroInt() {
        List list = new List();

        list.traverseAndApply(containsZeroAction);
        assertFalse(containsZeroAction.getContainsZero());

        list.add(0);

        list.traverseAndApply(containsZeroAction);
        assertFalse(containsZeroAction.getContainsZero());

        list.add(1);

        list.traverseAndApply(containsZeroAction);
        assertTrue(containsZeroAction.getContainsZero());
    }

    @Test
    void positiveSum() {
        List list = new List();

        int sum = 0;

        for (int i = 0; i < randomIterations; i++) {
            int number = wholeRandom();

            if (number > 0) {
                sum += number;
            }

            list.add(number);
        }

        list.add("HALLOOOOOO");

        PosSumAction posSumAction = new PosSumAction();
        list.traverseAndApply(posSumAction);
        assertEquals(sum, posSumAction.getSumOfPositiveInts());
    }
}
