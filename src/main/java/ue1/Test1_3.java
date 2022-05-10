package ue1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static ue1.Submission1_3.prost;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Die Funktion prost soll:
 *  + einen Parameter "n" vom Typ int übernehmen
 *  + den Rückgabetyp int haben
 *  + rekursiv programmiert sein (d.h. kein for oder while)
 *  + die Anzahl Anstöße auf einer Party berechnen
 *
 *  Nicht explizit genannt:
 *  + soll terminieren für alle n ∈ ℤ (also auch negative n), genauer:
 *   + soll für n=0 genau 0 ausgeben (denn niemand kann mit niemandem anstoßen)
 *   + soll für n=1 auch 0 ausgeben (denn eine Person kann mit einem Glas nicht
 *         mit sich selbst anstoßen)
 *   + soll für n<0 auch 0 ausgeben
 */
public class Test1_3 {

    private int prostDiscreteFormula(int people) {
        return Math.floorDiv(people * (people-1), 2);
    }

    @Test
    void prostForOnePerson() {
        assertEquals(0, prost(1));
    }

    @Test
    void prostForZeroPerson() {
        assertEquals(0, prost(0));
    }

    @Test
    void prostForNegativePerson() {
        assertEquals(0, prost(-1));
    }

    @Test
    void prostWithSimpleNumbers() {
        assertEquals(prostDiscreteFormula(2), prost(2));
        assertEquals(prostDiscreteFormula(3), prost(3));
        assertEquals(prostDiscreteFormula(5), prost(5));
    }

    @Test
    void prostWithRandomizedNumbersChecksNegative() {
        Random random = new Random();

        int boundary = 1000;

        for (int i = 0; i < 10; i++) {
            int people = random.nextInt(boundary);
            int solution = Math.floorDiv(people * (people-1), 2);
            int studentSolution = prost(people);

            assertEquals(
                    solution,
                    studentSolution
            );

            assertEquals(
                    0,
                    prost(people * -1)
            );

            System.out.println("Correct answer for: " + people + " which equates to " + solution + " and student got " + studentSolution);
        }
    }
}


