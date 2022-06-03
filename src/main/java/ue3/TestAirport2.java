package ue3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestAirport2 {
    static boolean trueMeansDeparture = true;
    static Random random;

    Flight randomFlight() {
        return new Flight(
                random.nextInt(100000),
                "BER",
                "Drölf",
                "Zu spät",
                true
        );
    }

    Flight exampleFlight1 = new Flight(
            654654,
            "DRS",
            "B400",
            "3 Uhr Morgens",
            false
    );

    Flight exampleFlight2 = new Flight(
            258984,
            "FRA",
            "P400000",
            "Mittags",
            true
    );

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreInitialStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);

        System.out.println(out);
    }

    @BeforeAll
    static void init() {
        random = new Random();
    }

    @Test
    void constructorTest() {
        int maxFlights = random.nextInt(1000);

        Airport airport = new Airport(maxFlights);

        assertEquals(maxFlights, airport.getMaxFlights());
    }

    @Test
    void addFlight() {
        int maxFlights = 2;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);

        // test length
        assertEquals(maxFlights, airport.getFlights().length);

        // test whether entered properties are accessible and correct
        assertEquals(exampleFlight1.location, airport.getFlights()[0].location);
        assertEquals(exampleFlight1.gate, airport.getFlights()[0].gate);
        assertEquals(exampleFlight1.time, airport.getFlights()[0].time);
    }

    @Test
    void addMoreThanMaxFlights() {
        int maxFlights = random.nextInt(100);
        Airport airport = new Airport(maxFlights);

        for (int i = 0; i < maxFlights + 1 + random.nextInt(100); i++) {
            try {
                airport.addNewFlight(randomFlight());
            } catch (Error e) {
                System.out.println("Fehler");
            }
        }

        assertTrue(
            out.toString().toLowerCase().contains("fehler") ||
            out.toString().toLowerCase().contains("error")
        );
    }

    @Test
    void addSameFlightTwice() {
        int maxFlights = 3;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);

        try {
            airport.addNewFlight(exampleFlight1);
        } catch (Error e) {
            System.out.println("Fehler");
        }

        assertTrue(
            out.toString().contains("Fehler") ||
            out.toString().contains("Error")
        );
    }

    @Test
    void testDepartures() {
        int maxFlights = 2;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);
        airport.addNewFlight(exampleFlight2);

        airport.listDeparturesOnScreen();

        Flight flightToBeListed;
        Flight flightNotToBeListed;

        if (trueMeansDeparture) {
            flightToBeListed = exampleFlight1;
            flightNotToBeListed = exampleFlight2;
        } else {
            flightToBeListed = exampleFlight2;
            flightNotToBeListed = exampleFlight1;
        }

        assertFalse(out.toString().contains(
                Integer.toString(flightToBeListed.flightNumber)
        ));

        assertTrue(out.toString().contains(
                Integer.toString(flightNotToBeListed.flightNumber)
        ));
    }

    @Test
    void testArrivals() {
        int maxFlights = 2;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);
        airport.addNewFlight(exampleFlight2);

        airport.listArrivalsOnScreen();

        Flight flightToBeListed;
        Flight flightNotToBeListed;

        if (trueMeansDeparture) {
            flightToBeListed = exampleFlight2; // false
            flightNotToBeListed = exampleFlight1;
        } else {
            flightToBeListed = exampleFlight1;
            flightNotToBeListed = exampleFlight2;
        }

        assertFalse(out.toString().contains(
                Integer.toString(flightToBeListed.flightNumber)
        ));

        assertTrue(out.toString().contains(
                Integer.toString(flightNotToBeListed.flightNumber)
        ));
    }

    @Test
    void removeFlight() {
        int maxFlights = 2;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);
        airport.addNewFlight(exampleFlight2);

        System.out.println(Arrays.toString(airport.getFlights()));

        airport.removeFlight(exampleFlight1.flightNumber);
        System.out.println(Arrays.toString(airport.getFlights()));

        assertFalse(
                Arrays.stream(airport.getFlights()).toList().contains(exampleFlight1)
        );
        assertTrue(
                Arrays.stream(airport.getFlights()).toList().contains(exampleFlight2)
        );

        airport.removeFlight(exampleFlight2.flightNumber);
        System.out.println(Arrays.toString(airport.getFlights()));
        assertFalse(
                Arrays.stream(airport.getFlights()).toList().contains(exampleFlight2)
        );
    }

    @Test
    void removeFlightThatDoesNotExist() {
        int maxFlights = 2;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);

        airport.removeFlight(exampleFlight2.flightNumber);
    }
}
