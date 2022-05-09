package ue1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static ue1.Submission3.prost;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class Test3 {

    private int prostDiscreteFormula(int people) {
        return Math.floorDiv(people * (people-1), 2);
    }

    @Test
    void prostForZeroOrOneOrNegativePerson() {
        assertEquals(0, prost(1));
        assertEquals(0, prost(0));
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


