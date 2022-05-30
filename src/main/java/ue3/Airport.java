package ue3;

public class Airport {
    // NECESSARY FOR TEST
    public int getMaxFlights() {
        return maxFlights;
    }
    // NECESSARY FOR TEST
    public Flight[] getFlights() {
        return flights;
    }

    private int maxFlights;
    private Flight[] flights;

    Airport(int maxFlights) {
        this.maxFlights = maxFlights;
        this.flights = new Flight[maxFlights];
    }

    void addNewFlight(Flight flight) {
        for (Flight j : flights) {
            if (j != null && j.flightNumber == flight.flightNumber) {
                System.out.println("Fehlermeldung: Flugnummer " + flight.flightNumber + " ist bereits vorhanden.");
                return;
                // Es steht zwar nicht in der Aufgabenstellung
                // das hier die Funktion beendet werden soll
                // aber es ergibt im Kontext des Problems
                // "Flughafen" Sinn.
                // Es passt auch zum Kontext von removeFlight
                // denn dort ist gefordert, dass _der_ Flug
                // mit der Flugnummer entfernt werden soll
            }
        }
        for (int i = 0; i < maxFlights; i++){
            if (flights[i] == null) {
                flights[i] = flight;
                return;
            }
        }

        System.out.println("Fehlermeldung: Die maximale Zahl an Flügen ist überschritten.");
    }

    void removeFlight(int flightNumber) {
        for (int i = 0; i < maxFlights; i++) {
            if (flights[i] != null && flights[i].flightNumber == flightNumber) {
                flights[i] = null;
                return;
            }
        }
    }

    void listDeparturesOnScreen() {
        System.out.println(
                """

                Departures:"""
        );

        System.out.format("%15s%15s%15s%15s%n", "Flugnummer", "Abflugszeit", "Gate", "Zielort");

        for (Flight j : flights) {
            if (j != null && !j.inOut) {
                System.out.format("%15s%15s%15s%15s%n", j.flightNumber, j.time, j.gate, j.location);
            }
        }
    }

    void listArrivalsOnScreen() {
        System.out.println(
                """

                Arrivals:"""
        );

        System.out.format("%15s%15s%15s%15s%n", "Flugnummer", "Ankunftszeit", "Gate", "Abflugsort");

        for (Flight j : flights) {
            if (j != null && j.inOut) {
                System.out.format("%15s%15s%15s%15s%n", j.flightNumber, j.time, j.gate, j.location);
            }
        }
    }
}
