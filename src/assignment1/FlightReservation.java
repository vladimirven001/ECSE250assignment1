package assignment1;

public class FlightReservation extends Reservation {

    private Airport departure;
    private Airport arrival;

    public FlightReservation(String name, Airport departure, Airport arrival) {
        
        super(name);
        this.departure = departure;
        this.arrival = arrival;
    
        if (departure.equals(arrival)) {
            throw new IllegalArgumentException("Departure and arrival airports are the same.");
        }
    }

    public int getCost() {
        
        double planeFees = 5375;
        double fuelCost = 124;
        double fuelEfficiency = 167.52;

        int dist = Airport.getDistance(departure, arrival);

        return (int)Math.ceil((fuelCost * dist / fuelEfficiency) + planeFees + departure.getFees() + arrival.getFees());

    }

    public boolean equals(Object o) {

        if (o instanceof FlightReservation && ((FlightReservation) o).reservationName() == this.reservationName() 
            && ((FlightReservation) o).departure == this.departure && ((FlightReservation) o).arrival == this.arrival) {
            return true;
        }

        return false;

    }

}
