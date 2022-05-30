package ue3;

public class Flight {
    int flightNumber;   // Flugnummer
    String location;    // Abflugs-/Zielort
    String gate;        // Gate
    String time;        // Abflugs-/Ankunftszeit
    boolean inOut;      // ein- oder abgehender Flug, true = arrivals, false = departures
    // Attribute nicht private, weil Aufgabenstellung das nicht vorsieht

    Flight(int flightNumber, String location, String gate, String time, boolean inOut) {
        this.flightNumber = flightNumber;
        this.location = location;
        this.gate = gate;
        this.time = time;
        this.inOut = inOut;
    }
}
