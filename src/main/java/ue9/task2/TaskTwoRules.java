package ue9.task2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTwoRules {
    static Random random = new Random();
    static int randomIterations = 1000;
    static int positiveRandom() {
        return Math.abs(random.nextInt(100)) + 1;
    }
    static int wholeRandom() {
        return positiveRandom() * ((positiveRandom() < (positiveRandom()/2)) ? 1 : -1);
    }

    @Test
    void queue() {
        Queue<Object> queue = new LinkedList<>();
        WSchlange wSchlange = new WSchlange();

        for (int i = 0; i < randomIterations; i++) {
            int element = positiveRandom();
            wSchlange.add(element);
            queue.add(element);
        }

        for (int i = 0; i < randomIterations; i++) {
            Object element1 = queue.poll();
            Object element2 = wSchlange.poll();

            assertEquals(element1, element2);
        }
    }

    @Test
    void pollEmpty() {
        WSchlange wSchlange = new WSchlange();
        assertThrows(Exception.class, wSchlange::poll);
    }
}
