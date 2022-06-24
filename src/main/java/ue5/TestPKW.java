package ue5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class TestPKW {
    static Random random;
    static int randomIterations = 1000;

    static boolean antenneAusgefahren = true;

    static int zufallsZahl() {
        return random.nextInt();
    }

    @BeforeAll
    static void init() {
        random = new Random();
    }

    /**
     * Kennzeichen
     */

    @Test
    void autoStandardKennzeichen() {
        Auto auto = new Auto();

        assertEquals(
                "J-AA 01",
                auto.getKennzeichen()
        );
    }

    @Test
    void autoStandardSitzplaetze() {
        Auto auto = new Auto();
        assertEquals(
                5,
                auto.getSitzplaetze()
        );
    }

    @Test
    void pickUpStandardKennzeichen() {
        PickUp pickUp = new PickUp(500);

        assertEquals(
                2,
                pickUp.getSitzplaetze()
        );

        assertEquals(
                "J-AA 01",
                pickUp.getKennzeichen()
        );
    }

    @Test
    void autoAnderesKennzeichen() {
        Auto auto = new Auto("Z-GU 61");

        assertEquals(
                5,
                auto.getSitzplaetze()
        );

        assertEquals(
                "Z-GU 61",
                auto.getKennzeichen()
        );
    }

    @Test
    void pickUpAnderesKennzeichen() {
        PickUp pickUp = new PickUp("Z-GU 61", 5000);

        assertEquals(
                2,
                pickUp.getSitzplaetze()
        );


        assertEquals(
                "Z-GU 61",
                pickUp.getKennzeichen()
        );
    }

    /**
     * Kilometerstände
     */

    @Test
    void autoKeineKilometerBeiNeufahrzeug() {
        Auto auto = new Auto();
        assertEquals(
                0,
                auto.getKilometerstand()
        );
    }

    @Test
    void pickUpKeineKilometerBeiNeufahrzeug() {
        Auto auto = new Auto();
        assertEquals(
                0,
                auto.getKilometerstand()
        );
    }

    @Test
    void autoKilometerstandNachFahren() {
        System.out.println("HINWEIS: Hier müssen Ausgaben pro Fahrtstrecke erscheinen. Sonst Abzug.");
        Auto auto = new Auto();
        int summeKilometer = 0;

        for (int i = 0; i < randomIterations; i++) {
            int kilometer = Math.abs(zufallsZahl());
            summeKilometer += kilometer;
            auto.fahre(kilometer);
            System.out.println(kilometer);
            assertEquals(
                    summeKilometer,
                    auto.getKilometerstand()
            );
        }
    }

    @Test
    void pickUpKilometerstandNachFahren() {
        System.out.println("HINWEIS: Hier müssen Ausgaben pro Fahrtstrecke erscheinen. Sonst Abzug.");
        Auto auto = new PickUp(5000);
        int summeKilometer = 0;

        for (int i = 0; i < randomIterations; i++) {
            int kilometer = Math.abs(zufallsZahl());
            summeKilometer += kilometer;
            auto.fahre(kilometer);
            assertEquals(
                    summeKilometer,
                    auto.getKilometerstand()
            );
        }
    }

    @Test
    void pickUpNegativeKilometerFahren() {
        System.out.println("HINWEIS: Hier muss eine Fehlermeldung auftauchen. Sonst Abzug.");
        Auto auto = new PickUp(50);
        auto.fahre(-1 * Math.abs(zufallsZahl()));
        assertEquals(
                0,
                auto.getKilometerstand()
        );
    }

    /**
     * Sitzplätze
     */
    @Test
    void autoFuenfSitzplaetze() {
        Auto auto = new Auto();
        assertEquals(
                5,
                auto.getSitzplaetze()
        );
    }

    @Test
    void pickUpZweiSitzplaetzeBei() {
        Auto auto = new PickUp(5000);
        assertEquals(
                2,
                auto.getSitzplaetze()
        );
    }

    @Test
    void autoZweiSitzPlaetze() {
        Auto auto = new Auto(true);
        assertEquals(
                2,
                auto.getSitzplaetze()
        );
    }

    /**
     * Antenne
     */

    @Test
    void pickUpAntenneAusUndEinfahren() {
        System.out.println("HINWEIS: Hier müssen Ausgaben pro Ein- bzw. Ausfahren erscheinen. Sonst Abzug.");
        Auto auto = new PickUp(5);
        auto.fahreAntenneAus();
        assertEquals(antenneAusgefahren, auto.antenneAusgefahren);

        auto.fahreAntenneAus();
        assertEquals(antenneAusgefahren, auto.antenneAusgefahren);

        auto.fahreAntenneEin();
        assertEquals(antenneAusgefahren, !auto.antenneAusgefahren);

        auto.fahreAntenneEin();
        assertEquals(antenneAusgefahren, !auto.antenneAusgefahren);

        auto.fahreAntenneAus();
        assertEquals(antenneAusgefahren, auto.antenneAusgefahren);
    }

    @Test
    void autoAntenneAusUndEinfahren() {
        System.out.println("HINWEIS: Hier müssen Ausgaben pro Ein- bzw. Ausfahren erscheinen. Sonst Abzug.");
        Auto auto = new Auto();
        auto.fahreAntenneAus();
        assertEquals(antenneAusgefahren, auto.antenneAusgefahren);

        auto.fahreAntenneAus();
        assertEquals(antenneAusgefahren, auto.antenneAusgefahren);

        auto.fahreAntenneEin();
        assertEquals(antenneAusgefahren, !auto.antenneAusgefahren);

        auto.fahreAntenneEin();
        assertEquals(antenneAusgefahren, !auto.antenneAusgefahren);

        auto.fahreAntenneAus();
        assertEquals(antenneAusgefahren, auto.antenneAusgefahren);
    }

    /**
     * Waschen
     */

    @Test
    void autoBereiteWaschenVor() {
        System.out.println("HINWEIS: Hier muss eine Ausgabe, dass die Antenne eingefahren wird, erscheinen. Sonst Abzug.");
        Auto auto = new Auto();

        auto.bereiteWaschenVor();
        assertEquals(antenneAusgefahren, !auto.antenneAusgefahren);

        auto.bereiteWaschenVor();
        assertEquals(antenneAusgefahren, !auto.antenneAusgefahren);
    }

    @Test
    void autoWasche() {
        System.out.println("HINWEIS: Hier muss eine Ausgabe, dass die Antenne eingefahren wird und, dass das Auto gewaschen wird, erscheinen. Sonst Abzug.");
        Auto auto = new Auto();

        auto.wasche();
    }

    @Test
    void pickUpBereiteWaschenVor() {
        System.out.println("HINWEIS: Hier muss eine Ausgabe, dass die Antenne eingefahren wird, erscheinen. Sonst Abzug.");
        Auto auto = new PickUp(5);

        auto.bereiteWaschenVor();
        assertEquals(antenneAusgefahren, !auto.antenneAusgefahren);

        auto.bereiteWaschenVor();
        assertEquals(antenneAusgefahren, !auto.antenneAusgefahren);
    }

    @Test
    void pickUpWasche() {
        System.out.println("HINWEIS: Hier muss eine Ausgabe, dass die Antenne eingefahren wird und, dass das Auto gewaschen wird, erscheinen. Sonst Abzug.");
        Auto auto = new PickUp(5);

        auto.wasche();
    }

    /**
     * Ausgabe des Autos als String
     */

    @Test
    void autoAlsString1() {
        String kennzeichen = "R-NM 98";
        Auto auto = new Auto(kennzeichen);

        assertTrue(
                auto.toString().contains(kennzeichen)
        );

        assertTrue(
                auto.toString().contains("5") || auto.toString().toLowerCase().contains("fünf") || auto.toString().toLowerCase().contains("fuenf") // Sitzplatzanzahl
        );
    }

    @Test
    void autoAlsString2() {
        String kennzeichen = "R-NM 12";
        Auto auto = new Auto(kennzeichen, true);

        assertTrue(
                auto.toString().contains(kennzeichen)
        );

        assertTrue(
                auto.toString().contains("2") || auto.toString().toLowerCase().contains("zwei") // Sitzplatzanzahl
        );
    }

    /**
     * Spezifische Tests für PickUps
     */

    @Test
    void pickUpAlsString() {
        String kennzeichen = "R-NM 12";
        Auto auto = new PickUp(kennzeichen, 5);

        assertTrue(
                auto.toString().contains(kennzeichen)
        );

        assertTrue(
                auto.toString().contains("2") || auto.toString().toLowerCase().contains("zwei") // Sitzplatzanzahl
        );

        System.out.println(auto);
    }

    @Test
    void pickUpKannNichtUeberladenWerden() {
        for (int i = 0; i < randomIterations; i++) {
            int kapazitaet = Math.abs(zufallsZahl());
            PickUp pickUp = new PickUp(kapazitaet);

            System.out.println(kapazitaet);

            assertEquals(0, pickUp.getLadung());

            // Mehr als die Kapazität kann man nicht aufladen
            assertFalse(pickUp.beladen(kapazitaet + 1));

            assertTrue(pickUp.beladen(kapazitaet / 2));
            assertTrue(pickUp.beladen(kapazitaet / 2));
            assertFalse(pickUp.beladen(2));
        }
    }

    @Test
    void pickUpKannNichtNegativEntladenWerden() {
        PickUp pickUp = new PickUp(1000);
        pickUp.entladen(-10000);
        assertEquals(0, pickUp.getLadung());
    }

    @Test
    void pickUpKannNichtNegativBeladenWerden() {
        PickUp pickUp = new PickUp(1000);
        boolean rueckgabe = pickUp.beladen(-100);

        if (!rueckgabe) {
            assertEquals(0, pickUp.getLadung());
        }
    }

    @Test
    void pickUpEntladen() {
        PickUp pickUp = new PickUp(500);
        boolean rueckgabe = pickUp.beladen(10);
        assertEquals(10, pickUp.getLadung());
        pickUp.entladen();
        assertEquals(0, pickUp.getLadung());
    }
}
