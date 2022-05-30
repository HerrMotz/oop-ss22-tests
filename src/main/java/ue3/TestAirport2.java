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
    static Random random;

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
        int maxFlights = 1;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);

        // test length
        assertEquals(1, airport.getFlights().length);

        // test whether entered properties are accessible and correct
        assertEquals(exampleFlight1.location, airport.getFlights()[0].location);
        assertEquals(exampleFlight1.gate, airport.getFlights()[0].gate);
        assertEquals(exampleFlight1.time, airport.getFlights()[0].time);
    }

    @Test
    void addMoreThanMaxFlights() {
        int maxFlights = 1;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);

        airport.addNewFlight(exampleFlight2);

        assertTrue(out.toString().contains("Fehler"));
    }

    @Test
    void addSameFlightTwice() {
        int maxFlights = 1;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);

        airport.addNewFlight(exampleFlight1);

        assertTrue(out.toString().contains("Fehler"));
    }

    @Test
    void testDepartures() {
        int maxFlights = 2;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);
        airport.addNewFlight(exampleFlight2);

        airport.listDeparturesOnScreen();

        assertTrue(out.toString().contains(
                        Integer.toString(exampleFlight1.flightNumber)
        ));

        assertFalse(out.toString().contains(
                Integer.toString(exampleFlight2.flightNumber)
        ));
    }

    @Test
    void testArrivals() {
        int maxFlights = 2;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);
        airport.addNewFlight(exampleFlight2);

        airport.listArrivalsOnScreen();

        assertFalse(out.toString().contains(
                Integer.toString(exampleFlight1.flightNumber)
        ));

        assertTrue(out.toString().contains(
                Integer.toString(exampleFlight2.flightNumber)
        ));
    }

    @Test
    void removeFlight() {
        int maxFlights = 2;
        Airport airport = new Airport(maxFlights);

        airport.addNewFlight(exampleFlight1);
        airport.addNewFlight(exampleFlight2);

        airport.removeFlight(exampleFlight1.flightNumber);
        assertFalse(
                Arrays.stream(airport.getFlights()).toList().contains(exampleFlight1)
        );
        assertTrue(
                Arrays.stream(airport.getFlights()).toList().contains(exampleFlight2)
        );

        airport.removeFlight(exampleFlight2.flightNumber);
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
