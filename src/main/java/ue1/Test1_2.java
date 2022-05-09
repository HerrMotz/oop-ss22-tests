package ue1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static ue1.Submission1_2.fibonacci;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test1_2 {

    @BeforeAll
    static void init() {}

    @Test
    void someNumbers() {
        int[] fibonacciNumbers = {
                0,
                1,
                1,
                2,
                3,
                5,
                8,
                13,
                21,
                34,
                55,
                89,
                144,
                233,
                377,
                610,
                987,
                1597,
                2584,
                4181,
                6765
        };

        for (int i = 0; i < fibonacciNumbers.length; i++) {
            assertEquals(fibonacciNumbers[i], fibonacci(i));
        }
    }
}


