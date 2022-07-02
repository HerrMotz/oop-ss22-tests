package ue8.tetrapack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTwoRules {
    static Random random;
    static int randomIterations = 1000;

    static double roundTwoDecimalPlaces(double number) {
        return Math.round(number * 100f) / 100f;
    }

    static int positiveRandom() {
        return Math.abs(random.nextInt(100));
    }

    static float fractionalRandom() {
        return ((float)positiveRandom() / (float)positiveRandom()) * ((positiveRandom() < (positiveRandom()/2)) ? 1 : -1);
    }

    static int wholeRandom() {
        return positiveRandom() * ((positiveRandom() < (positiveRandom()/2)) ? 1 : -1);
    }

    @BeforeAll
    static void init() {
        random = new Random();
    }

    @Test
    void doseVolumen() {
        for (int i = 0; i < randomIterations; i++) {
            int radius = positiveRandom();
            int height = positiveRandom();
            Dose dose = new Dose(radius, height);

            assertEquals(
                    roundTwoDecimalPlaces(Math.PI * Math.pow(radius, 2) * height),
                    roundTwoDecimalPlaces(dose.volumen())
            );
        }
    }

    @Test
    void quaderVolumen() {
        for (int i = 0; i < randomIterations; i++) {
            int a = positiveRandom();
            int b = positiveRandom();
            int c = positiveRandom();
            Tetrapack tetrapack = new Tetrapack(a, b, c);

            assertEquals(
                    roundTwoDecimalPlaces(a*b*c),
                    roundTwoDecimalPlaces(tetrapack.volumen())
            );
        }
    }

    @Test
    void behaeltnisseVolumen() {
        for (int i = 0; i < randomIterations; i++) {
            int a = positiveRandom();
            int b = positiveRandom();
            int c = positiveRandom();
            Behaeltnis behaeltnis = new Tetrapack(a, b, c);

            assertEquals(
                    roundTwoDecimalPlaces(a*b*c),
                    roundTwoDecimalPlaces(behaeltnis.volumen())
            );
        }

        for (int i = 0; i < randomIterations; i++) {
            int radius = positiveRandom();
            int height = positiveRandom();
            Behaeltnis behaeltnis = new Dose(radius, height);

            assertEquals(
                    roundTwoDecimalPlaces(Math.PI * Math.pow(radius, 2) * height),
                    roundTwoDecimalPlaces(behaeltnis.volumen())
            );
        }
    }

    @Test
    void negativeParameters() {
        assertThrows(
                Exception.class, () -> {
                    Behaeltnis behaeltnis = new Tetrapack(-2, -2, -1);
                }
        );

        assertThrows(
                Exception.class, () -> {
                    Behaeltnis behaeltnis = new Dose(-2, -2);
                }
        );
    }

    @Test
    void auftragsabwicklung() {
        final double produktion = 200; // Wochenproduktion
        // fülle die Bestellung mit Flüssigkeitsbehältnissen
        Behaeltnis[] bestellung = {
                new Tetrapack(2.3, 0.9, 0.7), new Dose(0.59 , 1.15),
                new Dose(0.59 , 1.15), new Tetrapack(1.1, 0.7, 0.7) // ...
        };

        // gebe Liste aller bestellten Flüssigkeitsbehältnisse aus
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < bestellung.length; i++) {
            bestellung[i].println();
        }
        // berechne das Gesamtvolumen der Bestellung
        // und die Restmenge der Wochenproduktion
        double volumen = 0;
        for (Behaeltnis j : bestellung) {
            volumen += j.volumen();
        }
        System.out.println("Das Volumen der Bestellung beträgt: " + String.format("%.2f", volumen) + " VE");
        double restmenge = produktion - volumen;
        System.out.println("Die Restmenge ist " + String.format("%.2f", restmenge) + " VE");
    }

    public static void main(String args[]) {
        final double produktion = 200; // Wochenproduktion

        Behaeltnis[] bestellung = {
                new Tetrapack(2.3, 0.9, 0.7), new Dose(0.59 , 1.15),
                new Dose(0.59 , 1.15), new Tetrapack(1.1, 0.7, 0.7) // ...
        };

        for (int i = 0; i < bestellung.length; i++) {
            bestellung[i].println();
        }
        // berechne das Gesamtvolumen der Bestellung
        // und die Restmenge der Wochenproduktion
        // >>> Diesen Programmteil sollen Sie hier ergaenzen! <<<

        double gesamtvolumen = 0;

        for(Behaeltnis beh : bestellung) {
            if (beh == null) { continue; }

            gesamtvolumen += beh.volumen();
        }

        System.out.println("Gesamtvolumen der Bestellung: " + gesamtvolumen);
        System.out.println("Differenz mit der Wochenproduktion: " + (produktion - gesamtvolumen));
    }
}
