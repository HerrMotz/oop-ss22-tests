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
            for (int i = 0; i < 10; i++) {
                int einkommen = zufallsZahl();

                einwohner.setEinkommen(einkommen);

                assertEquals(
                        Math.max((int)Math.floor((einwohner.zuVersteuerndesEinkommen() * 0.1f)), 1),
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

        for (int i = 0; i < 10; i++) {
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

        for (int i = 0; i < 10; i++) {
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
}
