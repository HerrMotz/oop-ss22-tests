package ue4.koenigreich;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestKoenigreich1 {
    ArrayList<Einwohner> einwohnerUndBauer = new ArrayList<>(){{
        add(new Einwohner());
        add(new Bauer());
    }};

    static int randomLoops = 100;
    static Random random;

    static int zufallsZahl() {
        return random.nextInt(1000);
    }

    @BeforeAll
    static void init() {
        random = new Random();
    }

    @Test
    void einwoherHatMindestensEinenGuldenSteuer() {
        for (Einwohner einwohner: einwohnerUndBauer) {
            einwohner.setEinkommen(0);
            assertEquals(
                    0,
                    einwohner.zuVersteuerndesEinkommen()
            );

            assertEquals(
                    1,
                    einwohner.steuer()
            );
        }
    }

    @Test
    void einwohnerNegativesEinkommen() {
        for (Einwohner einwohner: einwohnerUndBauer) {
            einwohner.setEinkommen(-10);
            assertEquals(
                    -10,
                    einwohner.zuVersteuerndesEinkommen()
            );

            assertEquals(
                    1,
                    einwohner.steuer()
            );
        }
    }

    @Test
    void einwohnerMindestensEinGulden() {
        for (Einwohner einwohner: einwohnerUndBauer) {
            einwohner.setEinkommen(1);
            assertEquals(
                    1,
                    einwohner.zuVersteuerndesEinkommen()
            );

            assertEquals(
                    1,
                    einwohner.steuer()
            );
        }
    }

    @Test
    void steuerWirdAbgerundet() {
        for (Einwohner einwohner: einwohnerUndBauer) {
            einwohner.setEinkommen(19);
            assertEquals(
                    19,
                    einwohner.zuVersteuerndesEinkommen()
            );

            assertEquals(
                    1,
                    einwohner.steuer()
            );
        }
    }

    @Test
    void einwohnerSteuerBerechnungUndZuVersteuerndesEinkommen() {
        for (Einwohner einwohner: einwohnerUndBauer) {
            for (int i = 0; i < randomLoops; i++) {
                int einkommen = zufallsZahl();

                einwohner.setEinkommen(einkommen);

                assertEquals(
                        Math.max((int)Math.floor((einkommen * 0.1f)), 1),
                        einwohner.steuer()
                );

                assertEquals(
                        einkommen,
                        einwohner.zuVersteuerndesEinkommen()
                );
            }
        }
    }

    @Test
    void adelZahltMindestensZwanzigGulden() {
        Adel adel = new Adel();

        adel.setEinkommen(5);

        assertEquals(
                20,
                adel.steuer()
        );

        adel.setEinkommen(0);

        assertEquals(
                20,
                adel.steuer()
        );

        adel.setEinkommen(-100);

        assertEquals(
                20,
                adel.steuer()
        );
    }

    @Test
    void koenigZahltKeineSteuern() {
        Koenig koenig = new Koenig();

        for (int i = 0; i < randomLoops; i++) {
            int einkommen = random.nextInt();

            koenig.setEinkommen(einkommen);

            assertEquals(
                    0,
                    koenig.steuer()
            );

            if (koenig.zuVersteuerndesEinkommen() == 0) {
                return;
            }
            assertEquals(
                    einkommen,
                    koenig.zuVersteuerndesEinkommen()
            );
        }
    }

    @Test
    void leibEigenerKriegtZwoelfGuldenSteuerRabatt() {
        Leibeigener leibeigener = new Leibeigener();

        for (int i = 0; i < randomLoops; i++) {
            int einkommen = zufallsZahl();

            leibeigener.setEinkommen(einkommen);

            assertEquals(
                    Math.max((int)Math.floor(((einkommen-12) * 0.1f)), 1),
                    leibeigener.steuer()
            );

            assertEquals(
                    (einkommen-12),
                    leibeigener.zuVersteuerndesEinkommen()
            );
        }
    }

    @Test
    void ruleNumber1() {
        Bauer bauer = new Bauer();
        bauer.setEinkommen(100);
        assertEquals(10, bauer.steuer());
    }

    @Test
    void ruleNumber2FirstSentence() {
        Einwohner einwohner = new Einwohner();
        einwohner.setEinkommen(100);
        assertEquals(10, einwohner.steuer());
    }

    @Test
    void ruleNumber2SecondSentence() {
        Einwohner einwohner = new Einwohner();
        einwohner.setEinkommen(11);
        assertEquals(1, einwohner.steuer());
    }

    @Test
    void ruleNumber2ThirdSentence() {
        Einwohner einwohner = new Einwohner();
        einwohner.setEinkommen(0);
        assertEquals(1, einwohner.steuer());

        einwohner.setEinkommen(9);
        assertEquals(1, einwohner.steuer());

        einwohner.setEinkommen(1);
        assertEquals(1, einwohner.steuer());
    }

    @Test
    void ruleNumber3() {
        Koenig koenig = new Koenig();
        koenig.setEinkommen(100);
        assertEquals(0, koenig.steuer());
    }

    @Test
    void ruleNumber4() {
        Adel adel = new Adel();
        adel.setEinkommen(0);
        assertEquals(20, adel.steuer());

        adel.setEinkommen(20);
        assertEquals(20, adel.steuer());

        adel.setEinkommen(100);
        assertEquals(20, adel.steuer());

        adel.setEinkommen(1000);
        assertTrue(adel.steuer() > 20);
    }

    @Test
    void ruleNumber5() {
        Leibeigener leibeigener = new Leibeigener();
        leibeigener.setEinkommen(12);
        assertEquals(1, leibeigener.steuer());
        leibeigener.setEinkommen(32);
        assertEquals(2, leibeigener.steuer());
    }
}
