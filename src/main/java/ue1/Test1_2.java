package ue1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

import static ue1.Submission1_2.studentFibonacci;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Die Funktion "fibonacci" soll:
 *  + _iterativ_ programmiert sein, d.h. kein rekursiver Aufruf (MANUELL)
 *  + das Programm soll eine Eingabe erwarten (d.h. Abfrage stdin) (MANUELL)
 *  + für Eingabe n das n-te Fibonacci-Glied ausgeben (TEST)
 *  + beenden, wenn der Benutzer eine negative Zahl eingibt (TEST)
 */
public class Test1_2 {

    @BeforeAll
    static void init() {}

    /**
     * Wenn der Benutzer eine negative Zahl eingibt,
     * soll das Programm beendet werden.
     */
    @Test
    void exitsForNegativeNumbers() {
        Random random = new Random();

        int boundary = 1000;

        int randomNegativeInteger = -1 * random.nextInt(boundary);

        try {
            catchSystemExit(() -> {
                int r = studentFibonacci(-1);
            });
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        try {
            catchSystemExit(() -> {
                int r = studentFibonacci(randomNegativeInteger);
            });
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Das erste Glied (Index 0) hat den Wert 0,
     * das zweite (Index 1) hat den Wert 1.
     *
     * Alle weiteren Glieder stellen jeweils die Summe ihrer zwei
     * Vorgänger dar.
     */
    @Test
    void someNumbersIncludingZero() {
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
            assertEquals(fibonacciNumbers[i], studentFibonacci(i));
        }
    }
}


